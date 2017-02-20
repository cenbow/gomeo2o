/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午5:49:16
 */
package com.gomeo2o.facade.account.entity;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午5:49:16
 */
public class SupportBank   extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8605160296889392200L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 银行编码
	 */
	private String bankNo;
	/**
	 * 银行名
	 */
	private String bankName;
	/**
	 * 银行logo
	 */
	private String bankLogo;
	/**
	 * 银行卡类型
	 */
	private Integer cardType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
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
	

}
