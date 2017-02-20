package cn.com.mx.group.model.dto;

import java.io.Serializable;
import java.util.Date;

import cn.com.mx.utils.DateUtils;

/**
 * @Description 群组未审核dto
 * @author yuanchangjun
 * @date 2016年1月28日 上午11:14:17
 */
public class GroupNotAudited implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4272167227060606859L;

	private String id;
	
	private String groupId;
	// 群名
	private String groupName = "";
	// 群头像
	private String groupIcon = "";
	// 简介
	private String introduction = "";

	private String createOperator;
	// 创建时间
	private Date createTime;

	private String createTimeStr;

	// 审核人
	private String auditUser = "";
	// 审核时间
	private Date auditTime;
	
	private String auditTimeStr;
	
	//不通过原因
	private String notThroughReason;
	
	private String modifyType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupIcon() {
		return groupIcon;
	}

	public void setGroupIcon(String groupIcon) {
		this.groupIcon = groupIcon;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		if (null != createTime) {
			createTimeStr = DateUtils.formatDatetime(createTime);
		}
		return createTimeStr;
	}
	
	public String getAuditTimeStr() {
		if (null != auditTime) {
			auditTimeStr = DateUtils.formatDatetime(auditTime);
		}
		return auditTimeStr;
	}
	
	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}


	public void setAuditTimeStr(String auditTimeStr) {
		this.auditTimeStr = auditTimeStr;
	}

	public String getNotThroughReason() {
		return notThroughReason;
	}

	public void setNotThroughReason(String notThroughReason) {
		this.notThroughReason = notThroughReason;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getModifyType() {
		return modifyType;
	}

	public void setModifyType(String modifyType) {
		this.modifyType = modifyType;
	}
}