package cn.com.mx.cms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 热门话题
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class TopicVo implements Serializable {

	private static final long serialVersionUID = 7546412698631464802L;

	// 话题id
	private String topicId = "";
	// 话题名称
	private String topicName = "";
	// 话题内容
	private String topicContent = "";
	// 群名称
	private String groupName = "";
	// 回帖数
	private int commentNum = 0;
	// 被查看次数
	private int lookedNum = 0;
	// 话题图片url列表
	private List<String> image = new ArrayList<String>();
	
	private String groupId="";

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getLookedNum() {
		return lookedNum;
	}

	public void setLookedNum(int lookedNum) {
		this.lookedNum = lookedNum;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
