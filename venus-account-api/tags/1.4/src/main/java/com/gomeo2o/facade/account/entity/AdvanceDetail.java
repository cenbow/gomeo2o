/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午5:41:13
 */
package com.gomeo2o.facade.account.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description: 账户提现明细
 * @author: fengxin
 * @date: 2015年4月29日 下午5:41:13
 */
public class AdvanceDetail extends BaseEntity {

	private static final long serialVersionUID = -1563906639458936581L;
	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 流水号
	 */
	private String detailNo;
	/**
	 * 提现申请时间
	 */
	private Date applyTime;
	/**
	 * 审核通过时间
	 */
	private Date auditTime;
	/**
	 * 提现受理时间
	 */
	private Date acceptTime;
	/**
	 * 提现成功时间
	 */
	private Date successTime;
	/**
	 * 提现帐号
	 */
	private String cashCardnumber;
	/**
	 * 银行名称和支行名称
	 */
	private String bankName;
	/**
	 * 提现人姓名
	 */
	private String advanceName;
	/**
	 * 提现人身份证号
	 */
	private String identityNum;
	/**
	 * 提现金额
	 */
	private BigDecimal advanceValue;
	/**
	 * 到账金额
	 */
	private BigDecimal recordValue;
	/**
	 * 手续费
	 */
	private BigDecimal cashFee;
	/**
	 * 提现摘要
	 */
	private String advanceRemark;
	/**
	 * 审核人 1：系统，2：人工
	 */
	private Integer verifyType;
	/**
	 * 打款凭证号
	 */
	private String payoffNo;
	/**
	 * 打款凭证日期
	 */
	private Date payoffTime;
	/**
	 * 提现状态  5：提现完成     4：打款成功，3：审核成功，2：审核失败，1：待审核，0：提现失败
	 */
	private Integer state;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 用户业务操作序列号
	 */
	private String userOpNo;
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
	 * @return the applyTime
	 */
	public Date getApplyTime() {
		return applyTime;
	}
	/**
	 * @param applyTime the applyTime to set
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	/**
	 * @return the acceptTime
	 */
	public Date getAcceptTime() {
		return acceptTime;
	}
	/**
	 * @param acceptTime the acceptTime to set
	 */
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	/**
	 * @return the cashCardnumber
	 */
	public String getCashCardnumber() {
		return cashCardnumber;
	}
	/**
	 * @param cashCardnumber the cashCardnumber to set
	 */
	public void setCashCardnumber(String cashCardnumber) {
		this.cashCardnumber = cashCardnumber;
	}
	/**
	 * @return the identityNum
	 */
	public String getIdentityNum() {
		return identityNum;
	}
	/**
	 * @param identityNum the identityNum to set
	 */
	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}
	/**
	 * @return the verifyType
	 */
	public Integer getVerifyType() {
		return verifyType;
	}
	/**
	 * @param verifyType the verifyType to set
	 */
	public void setVerifyType(Integer verifyType) {
		this.verifyType = verifyType;
	}
	/**
	 * @return the payoffNo
	 */
	public String getPayoffNo() {
		return payoffNo;
	}
	/**
	 * @param payoffNo the payoffNo to set
	 */
	public void setPayoffNo(String payoffNo) {
		this.payoffNo = payoffNo;
	}
	/**
	 * @return the payoffTime
	 */
	public Date getPayoffTime() {
		return payoffTime;
	}
	/**
	 * @param payoffTime the payoffTime to set
	 */
	public void setPayoffTime(Date payoffTime) {
		this.payoffTime = payoffTime;
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
	 * @return the auditTime
	 */
	public Date getAuditTime() {
		return auditTime;
	}
	/**
	 * @param auditTime the auditTime to set
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 * @return the successTime
	 */
	public Date getSuccessTime() {
		return successTime;
	}
	/**
	 * @param successTime the successTime to set
	 */
	public void setSuccessTime(Date successTime) {
		this.successTime = successTime;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the advanceName
	 */
	public String getAdvanceName() {
		return advanceName;
	}
	/**
	 * @param advanceName the advanceName to set
	 */
	public void setAdvanceName(String advanceName) {
		this.advanceName = advanceName;
	}
	/**
	 * @return the advanceRemark
	 */
	public String getAdvanceRemark() {
		return advanceRemark;
	}
	/**
	 * @param advanceRemark the advanceRemark to set
	 */
	public void setAdvanceRemark(String advanceRemark) {
		this.advanceRemark = advanceRemark;
	}
	/**
	 * @return the advanceValue
	 */
	public BigDecimal getAdvanceValue() {
		return advanceValue;
	}
	/**
	 * @param advanceValue the advanceValue to set
	 */
	public void setAdvanceValue(BigDecimal advanceValue) {
		this.advanceValue = advanceValue;
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
	 * @return the cashFee
	 */
	public BigDecimal getCashFee() {
		return cashFee;
	}
	/**
	 * @param cashFee the cashFee to set
	 */
	public void setCashFee(BigDecimal cashFee) {
		this.cashFee = cashFee;
	}
	/**
	 * @return the userOpNo
	 */
	public String getUserOpNo() {
		return userOpNo;
	}
	/**
	 * @param userOpNo the userOpNo to set
	 */
	public void setUserOpNo(String userOpNo) {
		this.userOpNo = userOpNo;
	}

}
