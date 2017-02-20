/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午4:37:13
 */
package com.gomeo2o.facade.account.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description: 预算总额
 * @author: fengxin
 * @date: 2015年4月29日 下午4:37:13
 */
public class BudgetTotal extends BaseEntity {

	private static final long serialVersionUID = 2033915830608786964L;
	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 预算总额度
	 */
	private BigDecimal budgetTotal;
	/**
	 * 二级品类类目限制
	 */
	private String marketLimit;
	/**
	 * 预算可用总额，返利预算或优惠券预算
	 */
	private BigDecimal budgetBa;
	/**
	 * 预算号
	 */
	private String budgetNo;
	/**
	 * 预算冻结额度
	 */
	private BigDecimal budgetFr;
	/**
	 * 预算年度
	 */
	private String budgetYear;
	/**
	 * 预算开始时间
	 */
	private Date startTime;
	/**
	 * 预算结束时间
	 */
	private Date endTime;
	/**
	 * 预算类型 1：返利预算，2：优惠券预算
	 */
	private Integer budgetType;
	/**
	 * 是否超出预算，1：是，0：否（超出预算90%发出预警？）
	 */
	private Integer isexcessed;
	/**
	 * 状态 1：可用，2：禁用
	 */
	private Integer state;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 预算凭证号 SAP提供
	 */
	private String voucCode;
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
	 * @return the isexcessed
	 */
	public Integer getIsexcessed() {
		return isexcessed;
	}
	/**
	 * @param isexcessed the isexcessed to set
	 */
	public void setIsexcessed(Integer isexcessed) {
		this.isexcessed = isexcessed;
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
	 * @return the budgetTotal
	 */
	public BigDecimal getBudgetTotal() {
		return budgetTotal;
	}
	/**
	 * @param budgetTotal the budgetTotal to set
	 */
	public void setBudgetTotal(BigDecimal budgetTotal) {
		this.budgetTotal = budgetTotal;
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
	 * @return the budgetBa
	 */
	public BigDecimal getBudgetBa() {
		return budgetBa;
	}
	/**
	 * @param budgetBa the budgetBa to set
	 */
	public void setBudgetBa(BigDecimal budgetBa) {
		this.budgetBa = budgetBa;
	}
	/**
	 * @return the budgetFr
	 */
	public BigDecimal getBudgetFr() {
		return budgetFr;
	}
	/**
	 * @param budgetFr the budgetFr to set
	 */
	public void setBudgetFr(BigDecimal budgetFr) {
		this.budgetFr = budgetFr;
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
	 * @return the voucCode
	 */
	public String getVoucCode() {
		return voucCode;
	}
	/**
	 * @param voucCode the voucCode to set
	 */
	public void setVoucCode(String voucCode) {
		this.voucCode = voucCode;
	}
	/**
	 * @return the budgetYear
	 */
	public String getBudgetYear() {
		return budgetYear;
	}
	/**
	 * @param budgetYear the budgetYear to set
	 */
	public void setBudgetYear(String budgetYear) {
		this.budgetYear = budgetYear;
	}
	

}
