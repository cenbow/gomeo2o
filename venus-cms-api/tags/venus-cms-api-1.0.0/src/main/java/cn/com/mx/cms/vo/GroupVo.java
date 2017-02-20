package cn.com.mx.cms.vo;

import java.io.Serializable;

/**
 * @Description 热门群组
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class GroupVo implements Serializable {

	private static final long serialVersionUID = -8561853149697020573L;
	// 群组Id
	private String groupId;
	// 群名
	private String groupName = "";
	// 群分类id
	private int groupTypeId ;
	// 群logo
	private String groupLogo = "";
	// 消息数
	private int messageNum = 0;
	// 群成员
	private int groupMembers = 0;
	
	private String groupInfo;

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


	public int getGroupTypeId() {
		return groupTypeId;
	}

	public void setGroupTypeId(int groupTypeId) {
		this.groupTypeId = groupTypeId;
	}

	public String getGroupLogo() {
		return groupLogo;
	}

	public void setGroupLogo(String groupLogo) {
		this.groupLogo = groupLogo;
	}

	public int getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(int groupMembers) {
		this.groupMembers = groupMembers;
	}

	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}

	@Override
	public String toString() {
		return "GroupVo [groupId=" + groupId + ", groupName=" + groupName + ", groupTypeId=" + groupTypeId + ", groupLogo=" + groupLogo + ", messageNum=" + messageNum + ", groupMembers=" + groupMembers + "]";
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

}
