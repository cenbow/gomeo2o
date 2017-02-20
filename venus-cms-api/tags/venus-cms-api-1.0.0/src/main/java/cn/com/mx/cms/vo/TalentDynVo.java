package cn.com.mx.cms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 达人动态
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class TalentDynVo implements Serializable {

	private static final long serialVersionUID = -3424136479654099569L;
	//达人名称
	private String talentName = "";
	//达人头像
	private String talentIcon = "";
	//达人类型:运动达人,美妆达人
	private String talentType = "";
	//内容
	private String content = "";
	//开始时间
	private String beginTime = "";
	//回帖数
	private int commentNum = 0;
	//点赞数
	private int thumbNum = 0;
	//图片列表
	private List<String> image = new ArrayList<String>();
	//用户id
	private int userId;

	public String getTalentName() {
		return talentName;
	}

	public void setTalentName(String talentName) {
		this.talentName = talentName;
	}

	public String getTalentIcon() {
		return talentIcon;
	}

	public void setTalentIcon(String talentIcon) {
		this.talentIcon = talentIcon;
	}

	public String getTalentType() {
		return talentType;
	}

	public void setTalentType(String talentType) {
		this.talentType = talentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public int getThumbNum() {
		return thumbNum;
	}

	public void setThumbNum(int thumbNum) {
		this.thumbNum = thumbNum;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
