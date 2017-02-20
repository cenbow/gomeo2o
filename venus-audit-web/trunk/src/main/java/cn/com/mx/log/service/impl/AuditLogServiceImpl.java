package cn.com.mx.log.service.impl;

import io.terminus.ecp.config.service.ConfigReadService;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.mx.group.dao.GroupDao;
import cn.com.mx.group.dao.GroupLogDao;
import cn.com.mx.group.entity.GroupLog;
import cn.com.mx.log.service.IAuditLogService;
import cn.com.mx.topic.entity.TopicLog;
import cn.com.mx.topicBack.entity.TopicBackLog;
import cn.com.mx.twoTopicBack.entity.TwoTopicBackLog;
import cn.com.mx.utils.JsoupUtils;
import cn.com.mx.utils.MongoDbUtil;

import com.mongodb.Block;

/**
 * @Description 群组审核日志实现
 * @author yuanchangjun
 * @date 2016年1月28日 上午10:16:20
 */
@Slf4j
@Service
@SuppressWarnings("all")
public class AuditLogServiceImpl implements IAuditLogService {
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private GroupLogDao groupLogDao;
	
	@Autowired
    private ConfigReadService configReadService;
	
	/**
	 * @Description 查询群组审核日志 
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午1:46:11
	 * @param jsonArray
	 * @return
	 */
	@Override
	public List<GroupLog> findGroupLog(JSONObject jsonArray) {
		final List<GroupLog> list = new ArrayList<GroupLog>();
		try {
			Document dc = new Document();
			String userId = URLDecoder.decode(jsonArray.getString("userId"),"UTF-8");
			if(!StringUtils.isBlank(userId)){
				dc.append("createOperator", userId);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			MongoDbUtil.getResultForMongo(jsonArray.getString("dbtable"),dc,jsonArray,-1,"createTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final GroupLog gna= new GroupLog();
					gna.setId(String.valueOf(doc.getObjectId("_id")));
					gna.setCreateTime(doc.getString("createTime"));
					gna.setGroupName(JsoupUtils.getJsonp(doc.getString("groupName"),ip));
					gna.setIntroduction(JsoupUtils.getJsonp(doc.getString("introduction"),ip));
					gna.setGroupIcon(doc.getString("groupIcon"));
					gna.setCreateOperator(doc.getString("createOperator"));
					gna.setAuditState(doc.getInteger("auditState"));
					gna.setAuditTime(doc.getString("auditTime"));
					List<?> listUserName = MongoDbUtil.getResultObject("user", new Document().append("_id", new ObjectId(doc.getString("auditUserId"))), "account");
					if(listUserName!=null&&listUserName.size()>0){
						gna.setAuditUser(String.valueOf(listUserName.get(0)));
					}
					gna.setAuditUserState(doc.getInteger("auditUserState"));
					list.add(gna);
				}	
			});
			return list;
		} catch (Exception e) {
			log.error("查询群组审核日志  ",e);
		}
		return list;
	}
	
	/**
	 * @Description 查询群组审核日志数量 
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午1:52:46
	 * @param jsonArray
	 * @return
	 */
	@Override
	public int findGroupLogCount(JSONObject jsonArray) {
		try {
			Document dc = new Document();
			String userId = URLDecoder.decode(jsonArray.getString("userId"),"UTF-8");
			if(!StringUtils.isBlank(userId)){
				dc.append("createOperator", userId);
			}
			return MongoDbUtil.getResultCount(jsonArray.getString("dbtable"),dc);
		} catch (Exception e) {
			log.error("查询群组审核日志数量",e);
		}
		return 0;
	}
	
	
	/**
	 * @Description 查询话题日志 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午12:07:00
	 * @param jsonArray
	 * @return
	 */
	@Override
	public List<TopicLog> findTopicLog(JSONObject jsonArray) {
		final List<TopicLog> list = new ArrayList<TopicLog>();
		try {
			Document dc = new Document();
			String userId = URLDecoder.decode(jsonArray.getString("userId"),"UTF-8");
			if(!StringUtils.isBlank(userId)){
				dc.append("createOperator", userId);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			MongoDbUtil.getResultForMongo("topicLog",dc,jsonArray,-1,"createTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final TopicLog gna= new TopicLog();
					gna.setId(String.valueOf(doc.getObjectId("_id")));
					gna.setCreateTime(doc.getString("createTime"));
					gna.setTopicId(doc.getString("topicId"));
					gna.setTopicName(JsoupUtils.getJsonp(doc.getString("topicName"),ip));
					gna.setContent(doc.getString("content"));
					gna.setTopicPic(doc.getString("topicPic"));
					gna.setCreateOperator(doc.getString("createOperator"));
					gna.setAuditState(doc.getInteger("auditState"));
					gna.setAuditTime(doc.getString("auditTime"));
					List<?> listUserName = MongoDbUtil.getResultObject("user", new Document().append("_id", new ObjectId(doc.getString("auditUserId"))), "account");
					if(listUserName!=null&&listUserName.size()>0){
						gna.setAuditUser(String.valueOf(listUserName.get(0)));
					}
					gna.setAuditUserState(doc.getInteger("auditUserState"));
					list.add(gna);
				}	
			});
			return list;
		} catch (Exception e) {
			log.error("查询群组审核日志  ",e);
		}
		return list;
	}
	
	/**
	 * @Description 查询话题日志数量 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午12:01:26
	 * @param jsonArray
	 * @return
	 */
	@Override
	public int findTopicLogCount(JSONObject jsonArray) {
		try {
			Document dc = new Document();
			String userId = URLDecoder.decode(jsonArray.getString("userId"),"UTF-8");
			if(!StringUtils.isBlank(userId)){
				dc.append("createOperator", userId);
			}
			return MongoDbUtil.getResultCount("topicLog",dc);
		} catch (Exception e) {
			log.error("查询群组审核日志数量",e);
		}
		return 0;
	}
	
	/**
	 * @Description 查询话题回复审核日志 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午4:06:50
	 * @param jsonArray
	 * @return
	 */
	@Override
	public List<TopicBackLog> findTopicBackLog(JSONObject jsonArray) {
		final List<TopicBackLog> list = new ArrayList<TopicBackLog>();
		try {
			Document dc = new Document();
			String userId = URLDecoder.decode(jsonArray.getString("userId"),"UTF-8");
			if(!StringUtils.isBlank(userId)){
				dc.append("createOperator", userId);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			MongoDbUtil.getResultForMongo("topicBackLog",dc,jsonArray,-1,"createTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final TopicBackLog gna= new TopicBackLog();
					gna.setId(String.valueOf(doc.getObjectId("_id")));
					gna.setCreateTime(doc.getString("createTime"));
					gna.setTopicBackId(doc.getString("topicBackId"));
					gna.setTopicName(JsoupUtils.getJsonp(doc.getString("topicName"),ip));
					gna.setContent(doc.getString("content"));
					gna.setPics(doc.getString("pics"));
					gna.setCreateOperator(doc.getString("createOperator"));
					gna.setAuditState(doc.getInteger("auditState"));
					gna.setAuditTime(doc.getString("auditTime"));
					List<?> listUserName = MongoDbUtil.getResultObject("user", new Document().append("_id", new ObjectId(doc.getString("auditUserId"))), "account");
					if(listUserName!=null&&listUserName.size()>0){
						gna.setAuditUser(String.valueOf(listUserName.get(0)));
					}
					gna.setAuditUserState(doc.getInteger("auditUserState"));
					list.add(gna);
				}	
			});
			return list;
		} catch (Exception e) {
			log.error("查询话题回复审核日志",e);
		}
		return list;
	}
	
	/**
	 * @Description 查询话题回复审核日志数量 
	 * @author yuanchangjun
	 * @date 2016年2月23日 下午4:05:17
	 * @param jsonArray
	 * @return
	 */
	@Override
	public int findTopicBackLogCount(JSONObject jsonArray) {
		try {
			Document dc = new Document();
			String userId = URLDecoder.decode(jsonArray.getString("userId"),"UTF-8");
			if(!StringUtils.isBlank(userId)){
				dc.append("createOperator", userId);
			}
			return MongoDbUtil.getResultCount("topicBackLog",dc);
		} catch (Exception e) {
			log.error("查询群组审核日志数量",e);
		}
		return 0;
	}

	/**
	 * @Description 查询二级回复审核日志 
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午1:52:17
	 * @param jsonArray
	 * @return
	 */
	@Override
	public List<TwoTopicBackLog> findTwoTopicBackLog(JSONObject jsonArray) {
		final List<TwoTopicBackLog> list = new ArrayList<TwoTopicBackLog>();
		try {
			Document dc = new Document();
			String userId = URLDecoder.decode(jsonArray.getString("userId"),"UTF-8");
			if(!StringUtils.isBlank(userId)){
				dc.append("createOperator", userId);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			MongoDbUtil.getResultForMongo("twoTopicBackLog",dc,jsonArray,-1,"createTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final TwoTopicBackLog gna= new TwoTopicBackLog();
					gna.setId(String.valueOf(doc.getObjectId("_id")));
					gna.setTwoTopicBackId(doc.getString("twoTopicBackId"));
					gna.setCreateTime(doc.getString("createTime"));
					gna.setFirstTopicId(doc.getString("firstTopicId"));
					gna.setContent(JsoupUtils.getJsonp(doc.getString("content"),ip));
					gna.setCreateOperator(doc.getString("createOperator"));
					gna.setAuditState(doc.getInteger("auditState"));
					gna.setAuditTime(doc.getString("auditTime"));
					List<?> listUserName = MongoDbUtil.getResultObject("user", new Document().append("_id", new ObjectId(doc.getString("auditUserId"))), "account");
					if(listUserName!=null&&listUserName.size()>0){
						gna.setAuditUser(String.valueOf(listUserName.get(0)));
					}
					gna.setAuditUserState(doc.getInteger("auditUserState"));
					list.add(gna);
				}	
			});
			return list;
		} catch (Exception e) {
			log.error("查询二级回复审核日志",e);
		}
		return list;
	}

	/**
	 * @Description 查询二级回复审核日志数量   
	 * @author yuanchangjun
	 * @date 2016年3月1日 下午1:51:24
	 * @param jsonArray
	 * @return
	 */
	@Override
	public int findTwoTopicBackLogCount(JSONObject jsonArray) {
		try {
			Document dc = new Document();
			String userId = URLDecoder.decode(jsonArray.getString("userId"),"UTF-8");
			if(!StringUtils.isBlank(userId)){
				dc.append("createOperator", userId);
			}
			return MongoDbUtil.getResultCount("twoTopicBackLog",dc);
		} catch (Exception e) {
			log.error("查询群组审核日志数量",e);
		}
		return 0;
	}
}