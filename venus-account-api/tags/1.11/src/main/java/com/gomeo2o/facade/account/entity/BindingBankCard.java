/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午5:50:20
 */
package com.gomeo2o.facade.account.entity;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午5:50:20
 */
public class BindingBankCard  extends BaseEntity{
	
	private static final long serialVersionUID = -1995268360050780323L;
	/**
	 * 银行卡已绑定常量
	 */
	public static final String BANK_CARD_BINDING = "binding";
	/**
	 * 银行卡已绑定常量
	 */
	public static final String BANK_CARD_NO_BINDING = "no";
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 支持银行ID
	 */
	private String supportBankId;
	/**
	 * 银行卡号
	 */
	private String cardNo;
	/**
	 * 银行卡后四位
	 */
	private String lastFour;
	/**
	 * 身份证
	 */
	private String certificate;
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 银行名 非数据库字段
	 */
	private String bankName;
	/**
	 * 银行logo 非数据库字段
	 */
	private String bankLogo;
	/**
	 * 银行卡类型 非数据库字段
	 */
	private Integer cardType;
	/**
	 * 银行编码 非数据库字段
	 */
	private String bankCode;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSupportBankId() {
		return supportBankId;
	}
	public void setSupportBankId(String supportBankId) {
		this.supportBankId = supportBankId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getLastFour() {
		return lastFour;
	}
	public void setLastFour(String lastFour) {
		this.lastFour = lastFour;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankLogo() {
		return bankLogo;
	}
	public void setBankLogo(String bankLogo) {
		this.bankLogo = bankLogo;
	}
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}
	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	
}
