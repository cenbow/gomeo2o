/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月17日 上午10:07:31
 */
package com.gomeo2o.facade.account.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description: 账户现金余额明细
 * @author: fengxin
 * @date: 2015年4月17日 上午10:07:31
 */
public class MoneyDetail extends BaseEntity {

	private static final long serialVersionUID = -2922212400012734534L;
	/**
	 * 流水号
	 */
	private String detailNo;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 交易日期
	 */
	private Date dealTime;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 现金余额到账日期
	 */
	private Date recordTime; 
	/**
	 * 交易类型，充值，消费，退款，等
	 */
	private Integer dealType;
	/**
	 * 交易摘要
	 */
	private String dealRemark;   
	/**
	 * 1：增加，2：减少
	 */
	private Integer recordRule;  
	/**
	 * 具体数值
	 */
	private BigDecimal recordValue;  
	/**
	 * 流水摘要
	 */
	private String detailRemark;
	/**
	 * 现金余额是否已经入账 1：已经入账，0：没有入账
	 */
	private Integer state;
	
	private String creator;

	/**
	 * @return the detailNo
	 */
	public String getDetailNo() {
		return detailNo;
	}

	/**
	 * @param detailNo the detailNo to set
	 */
	public void setDetailNo(String detailNo) {
		this.detailNo = detailNo;
	}

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
	 * @return the dealTime
	 */
	public Date getDealTime() {
		return dealTime;
	}

	/**
	 * @param dealTime the dealTime to set
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	/**
	 * @return the recordTime
	 */
	public Date getRecordTime() {
		return recordTime;
	}

	/**
	 * @param recordTime the recordTime to set
	 */
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	/**
	 * @return the dealType
	 */
	public Integer getDealType() {
		return dealType;
	}

	/**
	 * @param dealType the dealType to set
	 */
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}

	/**
	 * @return the dealRemark
	 */
	public String getDealRemark() {
		return dealRemark;
	}

	/**
	 * @param dealRemark the dealRemark to set
	 */
	public void setDealRemark(String dealRemark) {
		this.dealRemark = dealRemark;
	}

	/**
	 * @return the recordRule
	 */
	public Integer getRecordRule() {
		return recordRule;
	}

	/**
	 * @param recordRule the recordRule to set
	 */
	public void setRecordRule(Integer recordRule) {
		this.recordRule = recordRule;
	}

	/**
	 * @return the detailRemark
	 */
	public String getDetailRemark() {
		return detailRemark;
	}

	/**
	 * @param detailRemark the detailRemark to set
	 */
	public void setDetailRemark(String detailRemark) {
		this.detailRemark = detailRemark;
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
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the recordValue
	 */
	public BigDecimal getRecordValue() {
		return recordValue;
	}

	/**
	 * @param recordValue the recordValue to set
	 */
	public void setRecordValue(BigDecimal recordValue) {
		this.recordValue = recordValue;
	}
	         

}
