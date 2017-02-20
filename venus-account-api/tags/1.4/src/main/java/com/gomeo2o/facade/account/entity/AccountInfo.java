/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月16日 下午5:08:58
 */
package com.gomeo2o.facade.account.entity;


import java.math.BigDecimal;
import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description: 账户信息
 * @author: fengxin
 * @date: 2015年4月16日 下午5:08:58
 */
public class AccountInfo extends BaseEntity {

	private static final long serialVersionUID = -7112141503222483020L;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户昵称
	 */
	private String userName;
	/**
	 * 用户手机号
	 */
	private String userPhone;
	/**
	 * 支付密码 MD5加密
	 */
	private String payPassword;
	/**
	 * 账户总额
	 */
	private BigDecimal accountTotal;
	/**
	 * 账户可用余额
	 */
	private BigDecimal scoreBa;
	/**
	 * 积分账户冻结
	 */
	private BigDecimal scoreFr;
	/**
	 * 返利可用余额
	 */
	private BigDecimal rebateBa;
	/**
	 * 返利冻结余额
	 */
	private BigDecimal rebateFr;   
	/**
	 * 返利 历史记录
	 */
	private BigDecimal rebateHy;
	/**
	 * 现金可用余额
	 */
	private BigDecimal moneyBa;
	/**
	 * 现金冻结余额
	 */
	private BigDecimal moneyFr;
	/**
	 * 账户状态   1：启用，0：冻结
	 */
	private Integer state;
	/**
	 * 支付密码错误次数对应的日期 yyyy-MM-dd格式
	 */
	private String payErrorDate;
	/**
	 * 支付密码当日错误次数
	 */
	private Integer payErrorNo;
	/**
	 * 非数据库字段
	 * 查询开始时间
	 */
	private Date acStartUpdateTime;
	/**
	 * 非数据库字段
	 * 查询结束字段
	 */
	private Date acEndUpdateTime;
	/**
	 * 非数据库字段 
	 * 页面显示红包可用数量
	 */
	private Integer couponSum;
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the userPhone
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 * @return the acStartUpdateTime
	 */
	public Date getAcStartUpdateTime() {
		return acStartUpdateTime;
	}
	/**
	 * @param acStartUpdateTime the acStartUpdateTime to set
	 */
	public void setAcStartUpdateTime(Date acStartUpdateTime) {
		this.acStartUpdateTime = acStartUpdateTime;
	}
	/**
	 * @return the acEndUpdateTime
	 */
	public Date getAcEndUpdateTime() {
		return acEndUpdateTime;
	}
	/**
	 * @param acEndUpdateTime the acEndUpdateTime to set
	 */
	public void setAcEndUpdateTime(Date acEndUpdateTime) {
		this.acEndUpdateTime = acEndUpdateTime;
	}
	/**
	 * @return the couponSum
	 */
	public Integer getCouponSum() {
		return couponSum;
	}
	/**
	 * @param couponSum the couponSum to set
	 */
	public void setCouponSum(Integer couponSum) {
		this.couponSum = couponSum;
	}
	/**
	 * @return the payPassword
	 */
	public String getPayPassword() {
		return payPassword;
	}
	/**
	 * @param payPassword the payPassword to set
	 */
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	/**
	 * @return the accountTotal
	 */
	public BigDecimal getAccountTotal() {
		return accountTotal;
	}
	/**
	 * @param accountTotal the accountTotal to set
	 */
	public void setAccountTotal(BigDecimal accountTotal) {
		this.accountTotal = accountTotal;
	}
	/**
	 * @return the scoreBa
	 */
	public BigDecimal getScoreBa() {
		return scoreBa;
	}
	/**
	 * @param scoreBa the scoreBa to set
	 */
	public void setScoreBa(BigDecimal scoreBa) {
		this.scoreBa = scoreBa;
	}
	/**
	 * @return the scoreFr
	 */
	public BigDecimal getScoreFr() {
		return scoreFr;
	}
	/**
	 * @param scoreFr the scoreFr to set
	 */
	public void setScoreFr(BigDecimal scoreFr) {
		this.scoreFr = scoreFr;
	}
	/**
	 * @return the rebateBa
	 */
	public BigDecimal getRebateBa() {
		return rebateBa;
	}
	/**
	 * @param rebateBa the rebateBa to set
	 */
	public void setRebateBa(BigDecimal rebateBa) {
		this.rebateBa = rebateBa;
	}
	/**
	 * @return the rebateFr
	 */
	public BigDecimal getRebateFr() {
		return rebateFr;
	}
	/**
	 * @param rebateFr the rebateFr to set
	 */
	public void setRebateFr(BigDecimal rebateFr) {
		this.rebateFr = rebateFr;
	}
	/**
	 * @return the moneyBa
	 */
	public BigDecimal getMoneyBa() {
		return moneyBa;
	}
	/**
	 * @param moneyBa the moneyBa to set
	 */
	public void setMoneyBa(BigDecimal moneyBa) {
		this.moneyBa = moneyBa;
	}
	/**
	 * @return the moneyFr
	 */
	public BigDecimal getMoneyFr() {
		return moneyFr;
	}
	/**
	 * @param moneyFr the moneyFr to set
	 */
	public void setMoneyFr(BigDecimal moneyFr) {
		this.moneyFr = moneyFr;
	}
	/**
	 * @return the rebateHy
	 */
	public BigDecimal getRebateHy() {
		return rebateHy;
	}
	/**
	 * @param rebateHy the rebateHy to set
	 */
	public void setRebateHy(BigDecimal rebateHy) {
		this.rebateHy = rebateHy;
	}
	/**
	 * @return the payErrorDate
	 */
	public String getPayErrorDate() {
		return payErrorDate;
	}
	/**
	 * @param payErrorDate the payErrorDate to set
	 */
	public void setPayErrorDate(String payErrorDate) {
		this.payErrorDate = payErrorDate;
	}
	/**
	 * @return the payErrorNo
	 */
	public Integer getPayErrorNo() {
		return payErrorNo;
	}
	/**
	 * @param payErrorNo the payErrorNo to set
	 */
	public void setPayErrorNo(Integer payErrorNo) {
		this.payErrorNo = payErrorNo;
	}
	

}
