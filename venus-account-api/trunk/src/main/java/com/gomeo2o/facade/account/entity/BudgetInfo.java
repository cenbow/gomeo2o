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
 * @Description:预算信息
 * @author: fengxin
 * @date: 2015年4月29日 下午3:51:29
 */
public class BudgetInfo extends BaseEntity {

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
	 * 预算总额，返利预算总额或优惠券预算总额
	 */
	private BigDecimal budgetValue;
	/**
	 * 预算类型 1：返利预算，2：优惠券预算
	 */
	private Integer budgetType;
	/**
	 * 预算开始时间
	 */
	private Date startTime;
	/**
	 * 预算有效期截止时间
	 */
	private Date endTime;
	/**
	 * 二级品类品牌限制
	 */
	private String marketLimit;
	
	/**
	 * 状态 1：可用，2：禁用
	 */
	private Integer state;
	/**
	 * 备注
	 */
	private String remark;
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
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the marketLimit
	 */
	public String getMarketLimit() {
		return marketLimit;
	}
	/**
	 * @param marketLimit the marketLimit to set
	 */
	public void setMarketLimit(String marketLimit) {
		this.marketLimit = marketLimit;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the budgetValue
	 */
	public BigDecimal getBudgetValue() {
		return budgetValue;
	}
	/**
	 * @param budgetValue the budgetValue to set
	 */
	public void setBudgetValue(BigDecimal budgetValue) {
		this.budgetValue = budgetValue;
	}
	

}
