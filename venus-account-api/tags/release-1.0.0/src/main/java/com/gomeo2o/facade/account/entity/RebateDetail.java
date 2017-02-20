/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: gongjiaming
 * @date: 2015年4月16日 下午4:39:05
 */
package com.gomeo2o.facade.account.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;
/**
 * @Description:账户返利明细实体
 * @author:gongjiaming
 * @date: 2015年4月16日
 */
public class RebateDetail extends BaseEntity {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -305641126965625311L;
	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 流水号
	 */
	private String detailNo;
	/**
	 * 商品id
	 */
	private Long productId;
	/**
	 * 商铺Id
	 */
	private Long shopId;
	/**
	 * 返利类型：1：平台返利 2：商家返利
	 */
	private Integer rebateState;
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 
	 */
	private Date dealTime;
	/**
	 * 预计返利时间(订单生成)
	 */
	private Date expectTime;
	/**
	 * 返利发放时间(妥投+7)
	 */
	private Date recordTime;
	/**
	 * 商家返利金额
	 */
	private BigDecimal merchantRebate;
	/**
	 * 平台返利金额
	 */
	private BigDecimal platformRebate;
	/**
	 * 出/入账值
	 */
	private BigDecimal recordValue;
	/**
	 * 1：增加，2：减少
	 */
	private Integer recordRule;
	/**
	 * 交易摘要
	 */
	private String dealRemark;
	/**
	 * 交易类型  1:返利 2:消费 3:退款退还 4:冻结  5：解冻 ,
	 */
	private Integer dealType;
	/**
	 * 返利金额是否已经入账 1：已经入账，0：没有入账
	 */
	private Integer state;
	/**
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
	 * @return the expectTime
	 */
	public Date getExpectTime() {
		return expectTime;
	}
	/**
	 * @param expectTime the expectTime to set
	 */
	public void setExpectTime(Date expectTime) {
		this.expectTime = expectTime;
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
	 * @return the rebateState
	 */
	public Integer getRebateState() {
		return rebateState;
	}
	/**
	 * @param rebateState the rebateState to set
	 */
	public void setRebateState(Integer rebateState) {
		this.rebateState = rebateState;
	}
	/**
	 * @return the merchantRebate
	 */
	public BigDecimal getMerchantRebate() {
		return merchantRebate;
	}
	/**
	 * @param merchantRebate the merchantRebate to set
	 */
	public void setMerchantRebate(BigDecimal merchantRebate) {
		this.merchantRebate = merchantRebate;
	}
	/**
	 * @return the platformRebate
	 */
	public BigDecimal getPlatformRebate() {
		return platformRebate;
	}
	/**
	 * @param platformRebate the platformRebate to set
	 */
	public void setPlatformRebate(BigDecimal platformRebate) {
		this.platformRebate = platformRebate;
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
