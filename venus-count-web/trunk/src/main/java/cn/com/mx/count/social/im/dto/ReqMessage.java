package cn.com.mx.count.social.im.dto;

import java.io.Serializable;

/**
 * 
 * @Description: 发送消息 Request model 
 * @author: xuguoqi
 * @date: 2016年1月18日 下午3:55:48
 */
public class ReqMessage extends BaseRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6103210979886933930L;
	private long senderId;
	private String senderName;
	private int groupType;
	private long receiveId;
	private String groupId;
	private String groupName;
	private String content;

	public int getGroupType() {
		return groupType;
	}

	public void setGroupType(int groupType) {
		this.groupType = groupType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(long receiveId) {
		this.receiveId = receiveId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
