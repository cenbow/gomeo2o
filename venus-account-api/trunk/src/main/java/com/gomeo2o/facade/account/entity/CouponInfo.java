/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午4:55:52
 */
package com.gomeo2o.facade.account.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description: 账户优惠券信息
 * @author: fengxin
 * @date: 2015年4月29日 下午4:55:52
 */
public class CouponInfo extends BaseEntity {

	private static final long serialVersionUID = 3036709895161331717L;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 店铺编号
	 */
	private Long shopId;
	/**
	 * 红包类型 1：店铺券，2：平台劵
	 */
	private Integer couponType;
	/**
	 * ecp系统红包id
	 */
	private Long couponEcpId;
	/**
	 * 红包对呀流水id
	 */
	private Long detailId;
	/**
	 * 红包金额
	 */
	private BigDecimal couponValue;
	/**
	 * 红包使用 最低金额
	 */
	private BigDecimal baseMoney;
	/**
	 * 红包发送时间
	 */
	private Date sendTime;
	/**
	 * 红包截止时间
	 */
	private Date endTime;
	/**
	 * 红包状态 3：已使用 2：可用， 1：冻结，0：已过期
	 */
	private Integer state;
	/**
	 * 红包备注
	 */
	private String remark;
	/**
	 * 红包来源：1:商家店铺，2:平台
	 */
	private Integer resource;
	
	/**非数据库字段
	 * 流水号
	 */
	private String detailNo;
	/**非数据库字段
	 * 订单号
	 */
	private String orderNo;
	/**非数据库字段
	 * 交易时间
	 */
	private Date dealTime;
	/**非数据库字段
	 * 红包使用时间
	 */
	private Date recordTime;
	/**非数据库字段
	 * 优惠券面额
	 */
	private BigDecimal recordValue;
	/**非数据库字段
	 * 创建人
	 */
	private String creator;
	
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
	 * @return the shopId
	 */
	public Long getShopId() {
		return shopId;
	}
	/**
	 * @param shopId the shopId to set
	 */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	/**
	 * @return the couponType
	 */
	public Integer getCouponType() {
		return couponType;
	}
	/**
	 * @param couponType the couponType to set
	 */
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	/**
	 * @return the couponEcpId
	 */
	public Long getCouponEcpId() {
		return couponEcpId;
	}
	/**
	 * @param couponEcpId the CouponEcpId to set
	 */
	public void setCouponEcpId(Long couponEcpId) {
		this.couponEcpId = couponEcpId;
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
	public Integer getResource() {
		return resource;
	}
	public void setResource(Integer resource) {
		this.resource = resource;
	}
	/**
	 * @return the couponValue
	 */
	public BigDecimal getCouponValue() {
		return couponValue;
	}
	/**
	 * @param couponValue the couponValue to set
	 */
	public void setCouponValue(BigDecimal couponValue) {
		this.couponValue = couponValue;
	}
	/*
	 * @return the baseMoney
	 */
	public BigDecimal getBaseMoney() {
		return baseMoney;
	}
	/**
	 * @param baseMoney the baseMoney to set
	 */
	public void setBaseMoney(BigDecimal baseMoney) {
		this.baseMoney = baseMoney;
	}
	/**
	 * @return the detailId
	 */
	public Long getDetailId() {
		return detailId;
	}
	/**
	 * @param detailId the detailId to set
	 */
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
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
}
