/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月9日 下午1:31:26
 */
package com.gomeo2o.facade.account.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 收支信息VO
 * @author: fengxin
 * @date: 2015年5月9日 下午1:31:26
 */
public class BalancePaymentsVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8567431715430098258L;
	/**
	 * 返利id或者余额提现id
	 */
	private Long id;
	/**
	 * 0:返利流水
	 * 1：余额提现流水
	 */
	private Integer type;
	/**
	 * 返利流水号或者余额提现流水号
	 */
	private String detailNo;
	/**
	 * 余额提现数值或者返利数值
	 */
	private Double recordValue;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 记录成功日期
	 */
	private Date recordTime;
	/**
	 * 收支信息类型中文名称
	 */
	private String typeName;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
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
	 * @return the recordValue
	 */
	public Double getRecordValue() {
		return recordValue;
	}
	/**
	 * @param recordValue the recordValue to set
	 */
	public void setRecordValue(Double recordValue) {
		this.recordValue = recordValue;
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
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	

}
