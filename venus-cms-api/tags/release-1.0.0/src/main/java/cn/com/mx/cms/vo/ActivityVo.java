package cn.com.mx.cms.vo;

import java.io.Serializable;

/**
 * @Description 促销活动
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class ActivityVo implements Serializable {

	private static final long serialVersionUID = 3302022192414177847L;

	//活动图片
	private String activityImage = "";
	//活动主题
	private String activityTitle = "";
	//活动范围
	private String scope = "";
	//开始时间
	private String beginTime = "";
	//结束时间
	private String stopTime = "";
	//活动url
	private String activityUrl = "";

	public String getActivityImage() {
		return activityImage;
	}

	public void setActivityImage(String activityImage) {
		this.activityImage = activityImage;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

}
