/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月17日 上午10:12:28
 */
package com.gomeo2o.facade.account.entity;

import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;
import com.gomeo2o.facade.account.utils.ValidAnnotation;
import com.gomeo2o.facade.account.utils.RegexType;

/**
 * @Description: 账户积分明细
 * @author: fengxin
 * @date: 2015年4月17日 上午10:12:28
 */
public class ScoreDetail extends BaseEntity {

	private static final long serialVersionUID = -453439335364303908L;
	/**
	 * 用户ID
	 */
	@ValidAnnotation(description="用户id",nullable=false)
	private Long userId;
	/**
	 * 流水号
	 */
	private String detailNo;
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 商品编号
	 */
	private Long productId;
	/**
	 * 交易日期
	 */
	/**
	 * 交易日期
	 */
	@ValidAnnotation(description="交易日期",nullable=false)
	private Date dealTime;
	/**
	 * 账户积分到账日期
	 */
	private Date recordTime;
	/**
	 * 积分交易备注
	 */
	@ValidAnnotation(description="交易摘要",nullable=false)
	private String dealRemark;
	/**
	 * 交易类型 5：分享返积分，4：邀请注册返积分，3：订单成功返积分，2：评价晒单返积分，1：意见反馈返积分，0：积分兑换
	 */
	@ValidAnnotation(description="交易类型",minLength=1,maxLength=1,nullable=false)
	private Integer dealType;
	/**
	 * 交易积分的具体数值
	 */
	@ValidAnnotation(description="入账值 ",nullable=false,regexType=RegexType.NUMBER)
	private Integer recordValue;
	/**
	 * 账户积分是否已经入账 1：已经入账，0：没有入账
	 */
	@ValidAnnotation(description="账户积分是否已经入账 ",minLength=1,maxLength=1,nullable=false)
	private Integer state;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 积分埋点id
	 */
	private Long pointId;
	/**
	 * 积分规则id
	 */
	private Long ruleId;
	/**
	 * 查询参数 交易日期开始时间
	 */
	private Date siStartDealTime;
	/**
	 * 查询参数 交易日期结束时间
	 */
	private Date siEndDealTime;
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
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
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
	 * @return the recordValue
	 */
	public Integer getRecordValue() {
		return recordValue;
	}
	/**
	 * @param recordValue the recordValue to set
	 */
	public void setRecordValue(Integer recordValue) {
		this.recordValue = recordValue;
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
	 * @return the pointId
	 */
	public Long getPointId() {
		return pointId;
	}
	/**
	 * @param pointId the pointId to set
	 */
	public void setPointId(Long pointId) {
		this.pointId = pointId;
	}
	/**
	 * @return the ruleId
	 */
	public Long getRuleId() {
		return ruleId;
	}
	/**
	 * @param ruleId the ruleId to set
	 */
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * @return the siStartDealTime
	 */
	public Date getSiStartDealTime() {
		return siStartDealTime;
	}
	/**
	 * @param siStartDealTime the siStartDealTime to set
	 */
	public void setSiStartDealTime(Date siStartDealTime) {
		this.siStartDealTime = siStartDealTime;
	}
	/**
	 * @return the siEndDealTime
	 */
	public Date getSiEndDealTime() {
		return siEndDealTime;
	}
	/**
	 * @param siEndDealTime the siEndDealTime to set
	 */
	public void setSiEndDealTime(Date siEndDealTime) {
		this.siEndDealTime = siEndDealTime;
	}
	
	         
}
