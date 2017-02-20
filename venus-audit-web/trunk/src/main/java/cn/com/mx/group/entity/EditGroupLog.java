package cn.com.mx.group.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description 修改群组日志表
 * @author yuanchangjun
 * @date 2016年2月22日 下午12:24:05
 */
@Document
public class EditGroupLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 140372165243868340L;
	//mongodbId
	private String id;
	// 群名
	private String groupName = "";
	// 群头像
	private String groupIcon = "";
	// 简介
	private String introduction = "";
	// 创建人
	private String createOperator;
	// 创建时间
	private String createTime;
	// 当前状态 1:未审核 2:审核通过 3:审核不通过
	private int auditState = 1;
	// 审核人
	private String auditUser = "";
	
	private String auditUserId = "";
	// 审核时间
	private String auditTime;
	// 审核状态
	private int auditUserState = 1;
	// 不通过原因
	private String notThroughReason = "";

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



	public int getAuditState() {
		return auditState;
	}

	public void setAuditState(int auditState) {
		this.auditState = auditState;
	}

	public String getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}

	public int getAuditUserState() {
		return auditUserState;
	}

	public void setAuditUserState(int auditUserState) {
		this.auditUserState = auditUserState;
	}

	public String getNotThroughReason() {
		return notThroughReason;
	}

	public void setNotThroughReason(String notThroughReason) {
		this.notThroughReason = notThroughReason;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}
}