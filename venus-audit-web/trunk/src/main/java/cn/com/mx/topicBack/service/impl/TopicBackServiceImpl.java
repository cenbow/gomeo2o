package cn.com.mx.topicBack.service.impl;

import io.terminus.ecp.config.service.ConfigReadService;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.com.mx.group.dao.GroupDao;
import cn.com.mx.social.entity.topic.SocialTopic;
import cn.com.mx.social.entity.topic.SocialTopicPerson;
import cn.com.mx.social.events.service.IExternalEventsFacade;
import cn.com.mx.topic.dao.TopicDao;
import cn.com.mx.topicBack.dao.ITopicBackDao;
import cn.com.mx.topicBack.dao.ITopicBackLogDao;
import cn.com.mx.topicBack.dto.TopicBackDto;
import cn.com.mx.topicBack.entity.TopicBackLog;
import cn.com.mx.topicBack.service.ITopicBackService;
import cn.com.mx.utils.DateUtil;
import cn.com.mx.utils.JsoupUtils;
import cn.com.mx.utils.MongoDbUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;

/**
 * @Description 群组审核实现类 
 * @author yuanchangjun
 * @date 2016年1月28日 上午10:16:20
 */
@Slf4j
@Service
@SuppressWarnings("all")
public class TopicBackServiceImpl implements ITopicBackService {
	
	@Autowired
	private ITopicBackDao topicBackDao;
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private ITopicBackLogDao topicBackLogDao;
	
	@Autowired
	private IExternalEventsFacade externalEventsFacade;
	
	@Autowired
    private ConfigReadService configReadService;
	
	/**
	 * @Description 审核话题回复
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午2:23:17
	 * @param jsonArray
	 * @return
	 */
	@Override
	public List<TopicBackDto> findTopicBack(final JSONObject jsonArray) {
		final List<TopicBackDto> list = new ArrayList<TopicBackDto>();
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			String topicBackContent = URLDecoder.decode(jsonArray.getString("topicBackContent"),"UTF-8");
			if(!StringUtils.isBlank(topicBackContent)){
				dc.append("content", topicBackContent);
			}
			if(jsonArray.getInt("type")!=3){
				dc.append("states", 0);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			MongoDbUtil.getResultForMongo("socialTopicPerson",dc,jsonArray,-1,"updateTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final TopicBackDto gna= new TopicBackDto();
					gna.setId(String.valueOf(doc.getObjectId("_id")));
					gna.setCreateTime(sdf.format(doc.getDate("createTime")));
					gna.setContent(JsoupUtils.getJsonp(doc.getString("content"),ip));
					gna.setPics(doc.getString("pics"));
					List<?> listGroupName = MongoDbUtil.getResultObject("socialTopic", new Document().append("_id",new ObjectId(doc.getString("topicId"))), "topicName");
					if(listGroupName!=null&&listGroupName.size()>0){
						gna.setTopicName(String.valueOf(listGroupName.get(0)));
					}
					gna.setCreateOperator(doc.getString("createOperator"));
					if(jsonArray.getInt("type")!=1){
						if(!StringUtils.isBlank(doc.getString("auditUserId"))){
							List<?> listUserName = MongoDbUtil.getResultObject("user", new Document().append("_id", new ObjectId(doc.getString("auditUserId"))), "account");
							if(listUserName!=null&&listUserName.size()>0){
								gna.setAuditUser(String.valueOf(listUserName.get(0)));
							}
						}
						if(doc.getDate("auditTime")!=null){
							gna.setAuditTime(sdf.format(doc.getDate("auditTime")));
						}
					}
					if(jsonArray.getInt("type")==3){
						gna.setNotThroughReason(doc.getString("notThroughReason"));
					}
					list.add(gna);
				}	
			});
			return list;
		} catch (Exception e) {
			log.error("审核话题回复   ",e);
		}
		return list;
	}
	
	/**
	 * @Description 审核话题回复数量 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午2:23:06
	 * @param jsonArray
	 * @return
	 */
	@Override
	public int findTopicBackCount(JSONObject jsonArray) {
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			String topicBackContent = URLDecoder.decode(jsonArray.getString("topicBackContent"),"UTF-8");
			if(!StringUtils.isBlank(topicBackContent)){
				dc.append("content", topicBackContent);
			}
			if(jsonArray.getInt("type")!=3){
				dc.append("states", 0);
			}
			return MongoDbUtil.getResultCount("socialTopicPerson",dc);
		} catch (Exception e) {
			log.error("审核话题回复数量  ",e);
		}
		return 0;
	}
	
	/**
	 * @Description 审核话题回复 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午2:22:52
	 * @param jsonArray
	 * @return
	 */
	@Override
	public boolean toExamine(JSONObject jsonArray) {
		try {
			if(jsonArray.getBoolean("egis")){
				if(jsonArray.getBoolean("singleton")){
					SocialTopicPerson socialTopicPerson = this.topicBackDao.findById(jsonArray.getString("check"));
					if(jsonArray.containsKey("cuntent")){
						if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
							this.topicBackDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("topicId").is(socialTopicPerson.getTopicId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")).set("states", 1));
							if(this.topicBackDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
								topicBackLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
								return true;
							}
						}else{
							this.topicBackDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("topicId").is(socialTopicPerson.getTopicId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")).set("states", 1));
							if(this.topicBackDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
								topicBackLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
								return true;
							}
						}
					}else{
						this.topicBackDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("topicId").is(socialTopicPerson.getTopicId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
						if(this.topicBackDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
							topicBackLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
							return true;
						}
					}
				}else{
					List<String> listChecks = (List<String>) jsonArray.get("check");
					for (String string : listChecks) {
						SocialTopicPerson socialTopicPerson = this.topicBackDao.findById(string);
						if(jsonArray.containsKey("cuntent")){
							if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
								this.topicBackDao.update(new Query(Criteria.where("id").is(string).and("topicId").is(socialTopicPerson.getTopicId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")).set("states", 1));
								topicBackLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}else{
								this.topicBackDao.update(new Query(Criteria.where("id").is(string).and("topicId").is(socialTopicPerson.getTopicId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")).set("states", 1));
								topicBackLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}
						}else{
							this.topicBackDao.update(new Query(Criteria.where("id").is(string).and("topicId").is(socialTopicPerson.getTopicId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
							topicBackLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
						}
					}
					return true;
				}
			}
		} catch (Exception e) {
			log.error("审核话题回复",e);
			return false;
		}
		return false;
	}
	
	/**
	 * @Description 话题操作回复日志 
	 * @author yuanchangjun
	 * @date 2016年2月23日 上午11:40:40
	 * @param id
	 * @param flag
	 * @param message
	 * @param jsonArray
	 */
	public void topicBackLog(String id,boolean flag,String message,JSONObject jsonArray){
		try {
			SocialTopicPerson socialTopicPerson = this.topicBackDao.findById(id);
			if(socialTopicPerson!=null){
				this.externalEventsFacade.throughTheAuditTopicBack(jsonArray.toString(),id);
				TopicBackLog groupLog = new TopicBackLog();
				groupLog.setTopicBackId(socialTopicPerson.getId());
				//所属话题
				SocialTopic socialTopic = this.topicDao.findById(socialTopicPerson.getTopicId());
				if(socialTopic!=null){
					groupLog.setTopicName(socialTopic.getTopicName());
				}
				groupLog.setContent(socialTopicPerson.getContent());
				groupLog.setPics(socialTopicPerson.getPics());
				groupLog.setAuditState(jsonArray.getInt("state"));
				groupLog.setAuditTime(DateUtil.dateToString(new Date()));
				groupLog.setAuditUserState(jsonArray.getInt("state"));
				groupLog.setCreateOperator(jsonArray.getString("auditUserId"));
				groupLog.setAuditUserId(groupLog.getCreateOperator());
				groupLog.setCreateTime(groupLog.getAuditTime());
				if(message!=null){
					groupLog.setNotThroughReason(message);
				}
				this.topicBackLogDao.save(groupLog);
			}else{
				log.debug("未查询到话题回复");
			}
		} catch (Exception e) {
			log.error("话题操作回复日志  ",e);
		}
	}
	
}