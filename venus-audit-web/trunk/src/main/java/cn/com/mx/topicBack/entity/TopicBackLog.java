package cn.com.mx.topicBack.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description 审核回复日志 
 * @author yuanchangjun
 * @date 2016年2月23日 下午3:34:02
 */
@Document
public class TopicBackLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6988973121914969015L;

	// 话题回复id
	private String id;
	
	//审核回复id
	private String topicBackId;
	
	// 创建时间
	private String createTime;
	
	// 内容
	private String content="";
	
	// 图片路径
	private String pics="";
	
	// 话题
	private String topicName="";
	
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
	public String getTopicBackId() {
		return topicBackId;
	}
	public void setTopicBackId(String topicBackId) {
		this.topicBackId = topicBackId;
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
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
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
	public int getAuditUserState() {
		return auditUserState;
	}
	public void setAuditUserState(int auditUserState) {
		this.auditUserState = auditUserState;
	}
}