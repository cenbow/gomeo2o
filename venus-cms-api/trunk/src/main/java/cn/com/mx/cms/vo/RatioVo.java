package cn.com.mx.cms.vo;

import java.io.Serializable;

/**
 * @Description 资讯广播
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class RatioVo implements Serializable {

	private static final long serialVersionUID = 8248826512530399308L;
	//广播标题
	private String radioTitle = "";
	//广播内容
	private String radioContent = "";
	//图片
	private String image = "";
	//详情url
	private String activityUrl = "";

	public String getRadioTitle() {
		return radioTitle;
	}

	public void setRadioTitle(String radioTitle) {
		this.radioTitle = radioTitle;
	}

	public String getRadioContent() {
		return radioContent;
	}

	public void setRadioContent(String radioContent) {
		this.radioContent = radioContent;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

}
