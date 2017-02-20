package com.gomeo2o.facade.account.entity;

import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;
import com.gomeo2o.facade.account.utils.ValidAnnotation;
/**
 * 
 * @Description: 积分配置实体类
 * @author: fengxin
 * @date: 2015年3月20日 上午11:52:11
 */
public class ScoreConfig extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6925447282149092335L;
	/**
	 * 积分配置名称
	 */
	@ValidAnnotation(description="积分配置名称",nullable=false)
	private String configName;
	/**
	 * 是否已经执行  1：已经执行  0：未执行
	 */
	private Integer state;
	/**
	 * 清零时间
	 */
	@ValidAnnotation(description="清零时间",nullable=false)
	private Date resetTime;
	/**
	 * 清零规则  减少、增加
	 */
	@ValidAnnotation(description="清零规则",minLength=1,maxLength=1,nullable=false)
	private Integer resetRule;
	/**
	 * 清零值
	 */
	@ValidAnnotation(description="清零值",nullable=false)
	private Double resetValue;
	/**
	 * 是否邮件通知
	 */
	private Integer isMail;
	/**
	 * 是否短信通知
	 */
	private Integer isSms;
	/**
	 * 是否系统通知
	 */
	private Integer isSystem;
	/**
	 * 是否启用  1:启用  0  未启用
	 */
	@ValidAnnotation(description="是否启用",minLength=1,maxLength=1,nullable=false)
	private Integer isEnable;
	/**
	 * 第一通知时间
	 */
	private Date noticeOne;
	/**
	 * 第二通知时间
	 */
	private Date noticeTwo;
	
	public Date getResetTime() {
		return resetTime;
	}
	public void setResetTime(Date resetTime) {
		this.resetTime = resetTime;
	}
	public Integer getResetRule() {
		return resetRule;
	}
	public void setResetRule(Integer resetRule) {
		this.resetRule = resetRule;
	}
	public Integer getIsMail() {
		return isMail;
	}
	public void setIsMail(Integer isMail) {
		this.isMail = isMail;
	}
	public Integer getIsSms() {
		return isSms;
	}
	public void setIsSms(Integer isSms) {
		this.isSms = isSms;
	}
	public Integer getIsSystem() {
		return isSystem;
	}
	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	public Double getResetValue() {
		return resetValue;
	}
	public void setResetValue(Double resetValue) {
		this.resetValue = resetValue;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the noticeOne
	 */
	public Date getNoticeOne() {
		return noticeOne;
	}
	/**
	 * @param noticeOne the noticeOne to set
	 */
	public void setNoticeOne(Date noticeOne) {
		this.noticeOne = noticeOne;
	}
	/**
	 * @return the noticeTwo
	 */
	public Date getNoticeTwo() {
		return noticeTwo;
	}
	/**
	 * @param noticeTwo the noticeTwo to set
	 */
	public void setNoticeTwo(Date noticeTwo) {
		this.noticeTwo = noticeTwo;
	}
	/**
	 * @return the configName
	 */
	public String getConfigName() {
		return configName;
	}
	/**
	 * @param configName the configName to set
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	}

}
