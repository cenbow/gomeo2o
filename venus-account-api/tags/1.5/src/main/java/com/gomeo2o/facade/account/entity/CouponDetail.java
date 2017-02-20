/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午4:44:46
 */
package com.gomeo2o.facade.account.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description: 用户优惠券明细
 * @author: fengxin
 * @date: 2015年4月29日 下午4:44:46
 */
public class CouponDetail extends BaseEntity {

	private static final long serialVersionUID = 1009629426762273561L;
	/**
	 * 红包编号
	 */
	private Long couponEcpId;
	/**
	 * 用户编号
	 */
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
	 * 交易时间
	 */
	private Date dealTime;
	/**
	 * 红包使用时间
	 */
	private Date recordTime;
	/**
	 * 优惠券面额
	 */
	private BigDecimal recordValue;
	/**
	 * 红包类型 红包类型 1：店铺券，2：平台劵
	 */
	private Integer couponType;
	/**
	 * 交易状态 1：已完成，0：冻结中
	 */
	private Integer state;
	/**
	 * 红包交易备注
	 */
	private String remark;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 优惠券领取时间
	 */
	private Date sendTime;
	/**
	 * @return the coupon_id
	 */
	public Long getCouponEcpId() {
		return couponEcpId;
	}
	/**
	 * @param couponEcpId the coupon_id to set
	 */
	public void setCouponEcpId(Long couponEcpId) {
		this.couponEcpId = couponEcpId;
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
	 * @return the creater
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator the creater to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
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
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	/**
	 * @return the sendTime
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

}
