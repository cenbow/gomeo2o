package cn.com.mx.topic.service.impl;

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
import cn.com.mx.log.dao.TopicLogDao;
import cn.com.mx.social.entity.topic.SocialTopic;
import cn.com.mx.social.events.service.IExternalEventsFacade;
import cn.com.mx.topic.dao.TopicDao;
import cn.com.mx.topic.dto.TopicDto;
import cn.com.mx.topic.entity.TopicLog;
import cn.com.mx.topic.service.ITopicService;
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
public class TopicServiceImpl implements ITopicService {
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private TopicLogDao topicLogDao;
	
	@Autowired
	private IExternalEventsFacade externalEventsFacade;
	
	@Autowired
    private ConfigReadService configReadService;
	
	/**
	 * @Description 未审,审核,审核未通过 话题  
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午5:28:23
	 * @param jsonArray
	 * @return
	 */
	@Override
	public List<TopicDto> findTopic(final JSONObject jsonArray) {
		final List<TopicDto> list = new ArrayList<TopicDto>();
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			if(jsonArray.getInt("type")!=3){
				dc.append("states", new BasicDBObject("$ne", 1));
			}
			String topicName = URLDecoder.decode(jsonArray.getString("topicName"),"UTF-8");
			if(!StringUtils.isBlank(topicName)){
				dc.append("topicName", topicName);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			MongoDbUtil.getResultForMongo("socialTopic",dc,jsonArray,-1,"updateTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final TopicDto gna= new TopicDto();
					gna.setId(String.valueOf(doc.getObjectId("_id")));
					gna.setCreateTime(sdf.format(doc.getDate("createTime")));
					gna.setTopicName(JsoupUtils.getJsonp(doc.getString("topicName"),ip));
					gna.setContent(JsoupUtils.getJsonp(doc.getString("content"),ip));
					gna.setTopicPic(doc.getString("topicPic"));
					List<?> listGroupName = MongoDbUtil.getResultObject("socialGroup", new Document().append("_id", doc.get("groupId")), "groupName");
					if(listGroupName!=null&&listGroupName.size()>0){
						gna.setGroupName(String.valueOf(listGroupName.get(0)));
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
			log.error("未审,审核,审核未通过 话题   ",e);
		}
		return list;
	}
	
	/**
	 * @Description 未审,审核,审核未通过 话题  数量
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午5:42:22
	 * @param jsonArray
	 * @return
	 */
	@Override
	public int findTopicCount(JSONObject jsonArray) {
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			if(jsonArray.getInt("type")!=3){
				dc.append("states", new BasicDBObject("$ne", 1));
			}
			String topicName = URLDecoder.decode(jsonArray.getString("topicName"),"UTF-8");
			if(!StringUtils.isBlank(topicName)){
				dc.append("topicName", topicName);
			}
			return MongoDbUtil.getResultCount("socialTopic",dc);
		} catch (Exception e) {
			log.error("未审,审核,审核未通过 话题  数量 ",e);
		}
		return 0;
	}
	
	/**
	 * @Description 审核通过或不通过
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:37:17
	 * @param jsonArray
	 * @return
	 */
	@Override
	public boolean toExamine(JSONObject jsonArray) {
		try {
			if(jsonArray.getBoolean("egis")){
				if(jsonArray.getBoolean("singleton")){
					if(jsonArray.containsKey("cuntent")){
						if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
							SocialTopic topicKey = this.topicDao.findById(jsonArray.getString("check"));
							this.topicDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("groupId").is(topicKey.getGroupId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")).set("states", 1));
							if(this.topicDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
								topicLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
								return true;
							}
						}else{
							SocialTopic topicKey = this.topicDao.findById(jsonArray.getString("check"));
							this.topicDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("groupId").is(topicKey.getGroupId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")).set("states", 1));
							if(this.topicDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
								topicLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
								return true;
							}
						}
					}else{
						SocialTopic topicKey = this.topicDao.findById(jsonArray.getString("check"));
						this.topicDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("groupId").is(topicKey.getGroupId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
						if(this.topicDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
							topicLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
							return true;
						}
					}
				}else{
					List<String> listChecks = (List<String>) jsonArray.get("check");
					for (String string : listChecks) {
						SocialTopic topicKey = this.topicDao.findById(string);
						if(jsonArray.containsKey("cuntent")){
							if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
								this.topicDao.update(new Query(Criteria.where("id").is(string).and("groupId").is(topicKey.getGroupId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")).set("states", 1));
								topicLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}else{
								this.topicDao.update(new Query(Criteria.where("id").is(string).and("groupId").is(topicKey.getGroupId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")).set("states", 1));
								topicLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}
						}else{
							this.topicDao.update(new Query(Criteria.where("id").is(string).and("groupId").is(topicKey.getGroupId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
							topicLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
						}
					}
					return true;
				}
			}
		} catch (Exception e) {
			log.error("审核通过或不通过",e);
			return false;
		}
		return false;
	}
	
	/**
	 * @Description 话题操作日志 
	 * @author yuanchangjun
	 * @date 2016年2月23日 上午11:40:40
	 * @param id
	 * @param flag
	 * @param message
	 * @param jsonArray
	 */
	public void topicLog(String id,boolean flag,String message,JSONObject jsonArray){
		try {
			SocialTopic socialTopic = this.topicDao.findById(id);
			if(socialTopic!=null){
				this.externalEventsFacade.throughTheAuditTopic(jsonArray.toString(),id);
				TopicLog groupLog = new TopicLog();
				groupLog.setTopicId(socialTopic.getId());
				groupLog.setTopicName(socialTopic.getTopicName());
				groupLog.setContent(socialTopic.getContent());
				groupLog.setTopicPic(socialTopic.getTopicPic());
				groupLog.setAuditState(jsonArray.getInt("state"));
				groupLog.setAuditTime(DateUtil.dateToString(new Date()));
				groupLog.setAuditUserState(jsonArray.getInt("state"));
				groupLog.setCreateOperator(jsonArray.getString("auditUserId"));
				groupLog.setAuditUserId(groupLog.getCreateOperator());
				groupLog.setCreateTime(groupLog.getAuditTime());
				if(message!=null){
					groupLog.setNotThroughReason(message);
				}
				this.topicLogDao.save(groupLog);
			}else{
				log.debug("未查询到话题");
			}
		} catch (Exception e) {
			log.error("话题操作日志 ",e);
		}
	}
}