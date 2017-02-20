/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午3:51:29
 */
package com.gomeo2o.facade.account.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description:预算流水
 * @author: fengxin
 * @date: 2015年4月29日 下午3:51:29
 */
public class BudgetDetail extends BaseEntity {

	private static final long serialVersionUID = -2509611874575527201L;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 预算号
	 */
	private String budgetNo;
	/**
	 * 流水号
	 */
	private String detailNo;
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 优惠券或返利id
	 */
	private String cardId;
	/**
	 * 预算产生时间
	 */
	private Date budgetTime;
	/**
	 * 预算类型 1：返利预算，2：优惠券预算
	 */
	private Integer budgetType;
	/**
	 * 预算入账值
	 */
	private BigDecimal recordValue;
	/**
	 * 状态 1：已入账，0：冻结中
	 */
	private Integer state;
	
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
	 * @return the budgetTime
	 */
	public Date getBudgetTime() {
		return budgetTime;
	}
	/**
	 * @param budgetTime the budgetTime to set
	 */
	public void setBudgetTime(Date budgetTime) {
		this.budgetTime = budgetTime;
	}
	/**
	 * @return the budgetType
	 */
	public Integer getBudgetType() {
		return budgetType;
	}
	/**
	 * @param budgetType the budgetType to set
	 */
	public void setBudgetType(Integer budgetType) {
		this.budgetType = budgetType;
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
	 * @return the budgetNo
	 */
	public String getBudgetNo() {
		return budgetNo;
	}
	/**
	 * @param budgetNo the budgetNo to set
	 */
	public void setBudgetNo(String budgetNo) {
		this.budgetNo = budgetNo;
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
	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	

}
