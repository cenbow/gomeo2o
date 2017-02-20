package cn.com.mx.twoTopicBack.service.impl;

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

import cn.com.mx.social.entity.topic.SocialTopicReply;
import cn.com.mx.social.events.service.IExternalEventsFacade;
import cn.com.mx.topic.dao.TopicDao;
import cn.com.mx.twoTopicBack.dao.ITwoTopicBackDao;
import cn.com.mx.twoTopicBack.dao.ITwoTopicBackLogDao;
import cn.com.mx.twoTopicBack.dto.TwoTopicBackDto;
import cn.com.mx.twoTopicBack.entity.TwoTopicBackLog;
import cn.com.mx.twoTopicBack.service.ITwoTopicBackService;
import cn.com.mx.utils.DateUtil;
import cn.com.mx.utils.JsoupUtils;
import cn.com.mx.utils.MongoDbUtil;

import com.mongodb.Block;

/**
 * @Description 二级回复审核 
 * @author yuanchangjun
 * @date 2016年3月1日 下午12:28:03
 */
@Slf4j
@Service
@SuppressWarnings("all")
public class TwoTopicBackServiceImpl implements ITwoTopicBackService {
	
	@Autowired
	private ITwoTopicBackDao twoTopicBackDao;
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private ITwoTopicBackLogDao twoTopicBackLogDao;
	
	@Autowired
	private IExternalEventsFacade externalEventsFacade;
	
	@Autowired
    private ConfigReadService configReadService;

	/**
	 * @Description 二级回复查询
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午12:35:19
	 * @param jsonArray
	 * @return
	 */
	@Override
	public List<TwoTopicBackDto> findTwoTopicBack(final JSONObject jsonArray) {
		final List<TwoTopicBackDto> list = new ArrayList<TwoTopicBackDto>();
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			String topicBackContent = URLDecoder.decode(jsonArray.getString("topicBackContent"),"UTF-8");
			if(!StringUtils.isBlank(topicBackContent)){
				dc.append("content", topicBackContent);
			}
			if(jsonArray.getInt("type")!=3){
				dc.append("status", 1);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			MongoDbUtil.getResultForMongo("socialTopicReply",dc,jsonArray,-1,"createTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final TwoTopicBackDto gna= new TwoTopicBackDto();
					gna.setId(String.valueOf(doc.getObjectId("_id")));
					gna.setCreateTime(sdf.format(doc.getDate("createTime")));
					gna.setContent(JsoupUtils.getJsonp(doc.getString("content"),ip));
					gna.setFirstTopicId(doc.getString("firstReplyId"));
					gna.setCreateOperator(doc.getString("createOperator"));
					if(jsonArray.getInt("type")!=1){
						List<?> listUserName = MongoDbUtil.getResultObject("user", new Document().append("_id", new ObjectId(doc.getString("auditUserId"))), "account");
						if(listUserName!=null&&listUserName.size()>0){
							gna.setAuditUser(String.valueOf(listUserName.get(0)));
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
	 * @Description 二级回复查询数量 
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午12:38:45
	 * @param jsonArray
	 * @return
	 */
	@Override
	public int findTwoTopicBackCount(JSONObject jsonArray) {
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			String topicBackContent = URLDecoder.decode(jsonArray.getString("topicBackContent"),"UTF-8");
			if(!StringUtils.isBlank(topicBackContent)){
				dc.append("content", topicBackContent);
			}
			if(jsonArray.getInt("type")!=3){
				dc.append("status", 1);
			}
			return MongoDbUtil.getResultCount("socialTopicReply",dc);
		} catch (Exception e) {
			log.error("二级回复查询数量",e);
		}
		return 0;
	}
	
	/**
	 * @Description 二级回复审核 
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午1:38:41
	 * @param jsonArray
	 * @return
	 */
	@Override
	public boolean toExamine(JSONObject jsonArray) {
		try {
			if(jsonArray.getBoolean("egis")){
				if(jsonArray.getBoolean("singleton")){
					SocialTopicReply socialTopicReply = this.twoTopicBackDao.findById(jsonArray.getString("check"));
					if(jsonArray.containsKey("cuntent")){
						if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
							this.twoTopicBackDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("firstReplyId").is(socialTopicReply.getFirstReplyId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")).set("status", 0));
							if(this.twoTopicBackDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
								towTopicBackLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
								return true;
							}
						}else{
							this.twoTopicBackDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("firstReplyId").is(socialTopicReply.getFirstReplyId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")).set("status", 0));
							if(this.twoTopicBackDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
								towTopicBackLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
								return true;
							}
						}
					}else{
						this.twoTopicBackDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check")).and("firstReplyId").is(socialTopicReply.getFirstReplyId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
						if(this.twoTopicBackDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
							towTopicBackLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
							return true;
						}
					}
				}else{
					List<String> listChecks = (List<String>) jsonArray.get("check");
					for (String string : listChecks) {
						SocialTopicReply socialTopicReply = this.twoTopicBackDao.findById(string);
						if(jsonArray.containsKey("cuntent")){
							if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
								this.twoTopicBackDao.update(new Query(Criteria.where("id").is(string).and("firstReplyId").is(socialTopicReply.getFirstReplyId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")).set("status", 0));
								towTopicBackLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}else{
								this.twoTopicBackDao.update(new Query(Criteria.where("id").is(string).and("firstReplyId").is(socialTopicReply.getFirstReplyId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")).set("status", 0));
								towTopicBackLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}
						}else{
							this.twoTopicBackDao.update(new Query(Criteria.where("id").is(string).and("firstReplyId").is(socialTopicReply.getFirstReplyId())), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
							towTopicBackLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
						}
					}
					return true;
				}
			}
		} catch (Exception e) {
			log.error("二级回复审核",e);
			return false;
		}
		return false;
	}
	
	/**
	 * @Description 二级回复审核日志 
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午1:40:15
	 * @param id
	 * @param flag
	 * @param message
	 * @param jsonArray
	 */
	public void towTopicBackLog(String id,boolean flag,String message,JSONObject jsonArray){
		try {
			SocialTopicReply  socialTopicReply = this.twoTopicBackDao.findById(id);
			if(socialTopicReply!=null){
				this.externalEventsFacade.throughTwoTopicBack(jsonArray.toString(),id);
				TwoTopicBackLog groupLog = new TwoTopicBackLog();
				groupLog.setTwoTopicBackId(id);
				groupLog.setFirstTopicId(socialTopicReply.getFirstReplyId());
				groupLog.setContent(socialTopicReply.getContent());
				groupLog.setAuditState(jsonArray.getInt("state"));
				groupLog.setAuditTime(DateUtil.dateToString(new Date()));
				groupLog.setAuditUserState(jsonArray.getInt("state"));
				groupLog.setCreateOperator(jsonArray.getString("auditUserId"));
				groupLog.setAuditUserId(groupLog.getCreateOperator());
				groupLog.setCreateTime(groupLog.getAuditTime());
				if(message!=null){
					groupLog.setNotThroughReason(message);
				}
				this.twoTopicBackLogDao.save(groupLog);
			}else{
				log.debug("未查询到二级回复");
			}
		} catch (Exception e) {
			log.error("二级回复审核日志",e);
		}
	}
}