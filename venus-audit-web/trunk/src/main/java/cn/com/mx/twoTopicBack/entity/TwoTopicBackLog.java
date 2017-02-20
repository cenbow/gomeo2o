package cn.com.mx.twoTopicBack.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description 审核二级回复日志
 * @author yuanchangjun
 * @date 2016年2月23日 下午3:34:02
 */
@Document
public class TwoTopicBackLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6988973121914969015L;

	// id
	private String id;

	// 审核id
	private String twoTopicBackId;

	// 创建时间
	private String createTime;

	// 内容
	private String content = "";

	// 上级回复id
	private String firstTopicId;

	// 创建人
	private String createOperator;

	// 1:未审核 2:审核通过 3:审核不通过
	private int auditUserState;

	// 1:未审核 2:审核通过 3:审核不通过
	private int auditState = 1;
	// 审核人
	private String auditUser = "";
	// 审核人id
	private String auditUserId = "";
	// 审核时间
	private String auditTime;
	// 不通过原因
	private String notThroughReason = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTwoTopicBackId() {
		return twoTopicBackId;
	}

	public void setTwoTopicBackId(String twoTopicBackId) {
		this.twoTopicBackId = twoTopicBackId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFirstTopicId() {
		return firstTopicId;
	}

	public void setFirstTopicId(String firstTopicId) {
		this.firstTopicId = firstTopicId;
	}

	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}

	public int getAuditUserState() {
		return auditUserState;
	}

	public void setAuditUserState(int auditUserState) {
		this.auditUserState = auditUserState;
	}

	public int getAuditState() {
		return auditState;
	}

	public void setAuditState(int auditState) {
		this.auditState = auditState;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public String getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}

	public String getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}

	public String getNotThroughReason() {
		return notThroughReason;
	}

	public void setNotThroughReason(String notThroughReason) {
		this.notThroughReason = notThroughReason;
	}

}