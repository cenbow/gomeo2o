package cn.com.mx.group.service.impl;

import io.terminus.ecp.config.service.ConfigReadService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

import cn.com.mx.group.dao.EditGroupDao;
import cn.com.mx.group.dao.EditGroupLogDao;
import cn.com.mx.group.dao.GroupDao;
import cn.com.mx.group.dao.GroupLogDao;
import cn.com.mx.group.entity.EditGroupLog;
import cn.com.mx.group.entity.GroupLog;
import cn.com.mx.group.model.dto.GroupNotAudited;
import cn.com.mx.group.service.IGroupService;
import cn.com.mx.social.entity.group.SocialGroup;
import cn.com.mx.social.entity.group.SocialGroupPending;
import cn.com.mx.social.events.service.IExternalEventsFacade;
import cn.com.mx.utils.DateUtil;
import cn.com.mx.utils.JsoupUtils;
import cn.com.mx.utils.MongoDbUtil;

import com.mongodb.Block;

/**
 * @Description 群组审核实现类 
 * @author yuanchangjun
 * @date 2016年1月28日 上午10:16:20
 */
@Slf4j
@Service
@SuppressWarnings("all")
public class GroupServiceImpl implements IGroupService {
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private GroupLogDao groupLogDao;
	
	@Autowired
	private EditGroupDao editGroupDao;
	
	@Autowired
	private EditGroupLogDao editGroupLogDao;
	
	@Autowired
	private IExternalEventsFacade externalEventsFacade;
	
	@Autowired
    private ConfigReadService configReadService;
	
	/**
	 * @Description 查询[未审,审核,审核未通过]核群组 
	 * @author yuanchangjun
	 * @date 2016年1月28日 下午3:48:06
	 * @return
	 */
	@Override
	public List<GroupNotAudited> findNotAuditedGroup(final JSONObject jsonArray) {
		final List<GroupNotAudited> list = new ArrayList<GroupNotAudited>();
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			String groupName = URLDecoder.decode(jsonArray.getString("interfaceGroup"),"UTF-8");
			if(!StringUtils.isBlank(groupName)){
				dc.append("groupName", groupName);
			}
			if(jsonArray.getInt("type")!=3){
				dc.append("state", 0);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			MongoDbUtil.getResultForMongo("socialGroup",dc,jsonArray,-1,"updateTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final GroupNotAudited gna= new GroupNotAudited();
					gna.setId(doc.getString("_id"));
					gna.setCreateTime(doc.getDate("createTime"));
					gna.setGroupName(JsoupUtils.getJsonp(doc.getString("groupName").replaceAll("<", "&lt;").replaceAll(">", "&gt;"),ip));
					gna.setIntroduction(JsoupUtils.getJsonp(doc.getString("introduction"),ip));
					gna.setGroupIcon(doc.getString("groupIcon"));
					gna.setCreateOperator(doc.getString("createOperator"));
					if(jsonArray.getInt("type")!=1){
						if(!StringUtils.isBlank(doc.getString("auditUserId"))){
							List<?> listUserName = MongoDbUtil.getResultObject("user", new Document().append("_id", new ObjectId(doc.getString("auditUserId"))), "account");
							if(listUserName!=null&&listUserName.size()>0){
								gna.setAuditUser(String.valueOf(listUserName.get(0)));
							}
						}
						gna.setAuditTime(doc.getDate("auditTime"));
					}
					if(jsonArray.getInt("type")==3){
						gna.setNotThroughReason(doc.getString("notThroughReason"));
					}
					list.add(gna);
				}	
			});
			return list;
		} catch (Exception e) {
			log.error("查询未审核群组 ",e);
		}
		return list;
	}
	
	/**
	 * @Description 查询修改
	 * @author yuanchangjun
	 * @date 2016年3月2日 下午4:05:55
	 * @param jsonArray
	 * @return
	 */
	@Override
	public List<GroupNotAudited> findEditGroup(final JSONObject jsonArray) {
		final List<GroupNotAudited> list = new ArrayList<GroupNotAudited>();
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			String groupName = URLDecoder.decode(jsonArray.getString("interfaceGroup"),"UTF-8");
			if(!StringUtils.isBlank(groupName)){
				dc.append("groupName", groupName);
			}
			final String ip = configReadService.getByKey("sensitive").getResult().getValue();
			MongoDbUtil.getResultForMongo("socialGroupPending",dc,jsonArray,-1,"updateTime").forEach(new Block<Document>() {
				@Override
				public void apply(Document doc) {
					final GroupNotAudited gna= new GroupNotAudited();
					gna.setId(String.valueOf(doc.getObjectId("_id")));
					gna.setGroupId(doc.getString("groupId"));
					gna.setCreateTime(doc.getDate("createTime"));
					gna.setGroupName(JsoupUtils.getJsonp(doc.getString("groupName"),ip));
					gna.setIntroduction(JsoupUtils.getJsonp(doc.getString("introduction"),ip));
					gna.setGroupIcon(doc.getString("groupIcon"));
					gna.setCreateOperator(doc.getString("createOperator"));
					gna.setModifyType(doc.getString("modifyType"));
					if(jsonArray.getInt("type")!=1){
						List<?> listUserName = MongoDbUtil.getResultObject("user", new Document().append("_id", new ObjectId(doc.getString("auditUserId"))), "account");
						if(listUserName!=null&&listUserName.size()>0){
							gna.setAuditUser(String.valueOf(listUserName.get(0)));
						}
						gna.setAuditTime(doc.getDate("auditTime"));
					}
					if(jsonArray.getInt("type")==3){
						gna.setNotThroughReason(doc.getString("notThroughReason"));
					}
					list.add(gna);
				}	
			});
			return list;
		} catch (Exception e) {
			log.error("查询未审核群组 ",e);
		}
		return list;
	}
	
	/**
	 * @Description 未审核群组数量 
	 * @author yuanchangjun
	 * @date 2016年1月28日 下午3:48:19
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public int findNotAuditedGroupCount(JSONObject jsonArray) {
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			String groupName = URLDecoder.decode(jsonArray.getString("interfaceGroup"),"UTF-8");
			if(!StringUtils.isBlank(groupName)){
				dc.append("groupName", groupName);
			}
			if(jsonArray.getInt("type")!=3){
				dc.append("state", 0);
			}
			return MongoDbUtil.getResultCount("socialGroup",dc);
		} catch (Exception e) {
			log.error("未审核群组数量 ",e);
		}
		return 0;
	}

	/**
	 * @Description 查询修改[未审,审核,审核未通过]核群组数量 
	 * @author yuanchangjun
	 * @date 2016年3月2日 下午4:07:50
	 * @param jsonArray
	 * @return
	 */
	@Override
	public int findEditCount(JSONObject jsonArray) {
		try {
			Document dc = new Document().append("auditState", jsonArray.getInt("type"));
			String groupName = URLDecoder.decode(jsonArray.getString("interfaceGroup"),"UTF-8");
			if(!StringUtils.isBlank(groupName)){
				dc.append("groupName", groupName);
			}
			return MongoDbUtil.getResultCount("socialGroupPending",dc);
		} catch (Exception e) {
			log.error("未审核群组数量 ",e);
		}
		return 0;
	}
	
	/**
	 * @Description 审核通过和审核不通过
	 * @author yuanchangjun
	 * @date 2016年2月19日 下午1:46:37
	 * @param jsonArray
	 */
	@Override
	public boolean toExamine(JSONObject jsonArray) {
		try {
			if(jsonArray.getBoolean("egis")){
				if(jsonArray.getBoolean("singleton")){
					if(jsonArray.containsKey("cuntent")){
						if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
							this.groupDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check"))), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")).set("state", 1));
							if(this.groupDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
								groupLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
								return true;
							}
						}else{
							this.groupDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check"))), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")).set("state", 1));
							if(this.groupDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
								groupLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
								return true;
							}
						}
					}else{
						this.groupDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check"))), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
						if(this.groupDao.findById(jsonArray.getString("check")).getAuditState()==jsonArray.getInt("state")){
							groupLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
							return true;
						}
					}
				}else{
					List<String> listChecks = (List<String>) jsonArray.get("check");
					for (String string : listChecks) {
						if(jsonArray.containsKey("cuntent")){
							if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
								this.groupDao.update(new Query(Criteria.where("id").is(string)), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")).set("state", 1));
								groupLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}else{
								this.groupDao.update(new Query(Criteria.where("id").is(string)), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")).set("state", 1));
								groupLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}
						}else{
							this.groupDao.update(new Query(Criteria.where("id").is(string)), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
							groupLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
						}
					}
					return true;
				}
			}
		} catch (Exception e) {
			log.error("审核群组格式化时间失败",e);
		}
		return false;
	}
	
	/**
	 * @Description 修改圈子审核通过和审核不通过 
	 * @author yuanchangjun
	 * @date 2016年3月2日 下午4:41:55
	 * @param jsonArray
	 * @return
	 */
	@Override
	public boolean toEditExamine(JSONObject jsonArray) {
		try {
			if(jsonArray.getBoolean("egis")){
				if(jsonArray.getBoolean("singleton")){
					if(jsonArray.containsKey("cuntent")){
						if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
							this.editGroupDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check"))), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")));
							editGroupLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
							return true;
						}else{
							this.editGroupDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check"))), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")));
							editGroupLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
							return true;
						}
					}else{
						this.editGroupDao.update(new Query(Criteria.where("id").is(jsonArray.getString("check"))), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
						editGroupLog(jsonArray.getString("check"),jsonArray.containsKey("cuntent"),null,jsonArray);
						return true;
					}
				}else{
					List<String> listChecks = (List<String>) jsonArray.get("check");
					for (String string : listChecks) {
						if(jsonArray.containsKey("cuntent")){
							if(!StringUtils.isBlank(jsonArray.getString("cuntent"))){
								this.editGroupDao.update(new Query(Criteria.where("id").is(string)), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("cuntent")));
								editGroupLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}else{
								this.editGroupDao.update(new Query(Criteria.where("id").is(string)), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()).set("notThroughReason", jsonArray.getString("radioValue")));
								editGroupLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
							}
						}else{
							this.editGroupDao.update(new Query(Criteria.where("id").is(string)), Update.update("auditState", jsonArray.getInt("state")).set("updateTime", DateUtil.getNowDate()).set("auditUserId", jsonArray.getString("auditUserId")).set("auditTime", DateUtil.getNowDate()));
							editGroupLog(string,jsonArray.containsKey("cuntent"),null,jsonArray);
						}
					}
					return true;
				}
			}
		} catch (Exception e) {
			log.error("修改圈子审核通过和审核不通过",e);
		}
		return false;
	}
	
	/**
	 * @Description 修改群组日志表
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午12:43:41
	 * @param id
	 * @param message
	 */
	public void editGroupLog(String id,boolean flag,String message,JSONObject jsonArray){
		try {
			SocialGroupPending socialGroup = this.editGroupDao.findById(id);
			if(socialGroup!=null){
				this.externalEventsFacade.throughEditGroup(jsonArray.toString(),socialGroup);
				if(jsonArray.getInt("state")==2){
					for (int i = 1; i < socialGroup.getModifyType().split("").length; i++) {
						int type  = Integer.parseInt(socialGroup.getModifyType().split("")[i]);
						if(type==1){
							this.groupDao.update(new Query(Criteria.where("id").is(socialGroup.getGroupId())), Update.update("groupName", socialGroup.getGroupName()));
						}else if(type==2){
							this.groupDao.update(new Query(Criteria.where("id").is(socialGroup.getGroupId())), Update.update("introduction", socialGroup.getIntroduction()));
						}else if(type==4){
							this.groupDao.update(new Query(Criteria.where("id").is(socialGroup.getGroupId())), Update.update("groupIcon", socialGroup.getGroupIcon()));
						}
					}
				}
				EditGroupLog groupLog = new EditGroupLog();
				groupLog.setAuditState(jsonArray.getInt("state"));
				groupLog.setAuditTime(DateUtil.dateToString(new Date()));
				groupLog.setAuditUserState(jsonArray.getInt("state"));
				groupLog.setCreateOperator(jsonArray.getString("auditUserId"));
				groupLog.setAuditUserId(groupLog.getCreateOperator());
				groupLog.setCreateTime(groupLog.getAuditTime());
				groupLog.setGroupIcon(socialGroup.getGroupIcon());
				groupLog.setGroupName(socialGroup.getGroupName());
				groupLog.setIntroduction(socialGroup.getIntroduction());
				this.editGroupLogDao.save(groupLog);
			}else{
				log.debug("未查询到群组");
			}
		} catch (Exception e) {
			log.error("修改群组日志表失败",e);
		}
	}
	
	/**
	 * @Description 存储群组审核日志 
	 * @author yuanchangjun
	 * @date 2016年2月22日 下午12:43:41
	 * @param id
	 * @param message
	 */
	public void groupLog(String id,boolean flag,String message,JSONObject jsonArray){
		try {
			this.externalEventsFacade.throughTheAuditGroup(jsonArray.toString(),id);
			SocialGroup socialGroup = this.groupDao.findById(id);
			if(socialGroup!=null){
				GroupLog groupLog = new GroupLog();
				groupLog.setAuditState(jsonArray.getInt("state"));
				groupLog.setAuditTime(DateUtil.dateToString(new Date()));
				groupLog.setAuditUserState(jsonArray.getInt("state"));
				groupLog.setCreateOperator(jsonArray.getString("auditUserId"));
				groupLog.setAuditUserId(groupLog.getCreateOperator());
				groupLog.setCreateTime(groupLog.getAuditTime());
				groupLog.setGroupIcon(socialGroup.getGroupIcon());
				groupLog.setGroupName(socialGroup.getGroupName());
				groupLog.setIntroduction(socialGroup.getIntroduction());
				this.groupLogDao.save(groupLog);
			}else{
				log.debug("未查询到群组");
			}
		} catch (Exception e) {
			log.error("存储群组审核日志失败",e);
		}
	}
}