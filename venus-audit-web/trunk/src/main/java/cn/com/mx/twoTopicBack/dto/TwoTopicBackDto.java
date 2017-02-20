package cn.com.mx.twoTopicBack.dto;

import java.io.Serializable;

/**
 * @Description 话题回复
 * @author yuanchangjun
 * @date 2016年2月23日 下午2:20:32
 */
public class TwoTopicBackDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 755854733044581429L;

	// 二级回复id
	private String id;
	// 话题id
	private String firstTopicId;
	// 内容
	private String content;
	// 创建人
	private String createOperator;
	// 创建时间
	private String createTime;
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

	public String getFirstTopicId() {
		return firstTopicId;
	}

	public void setFirstTopicId(String firstTopicId) {
		this.firstTopicId = firstTopicId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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