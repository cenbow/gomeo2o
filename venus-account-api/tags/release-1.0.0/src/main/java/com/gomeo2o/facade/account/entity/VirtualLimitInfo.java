/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description 国美币交易限额信息
 * @author fengxin
 * @date 2015年11月13日 下午3:32:18
 */
package com.gomeo2o.facade.account.entity;

import com.gomeo2o.common.entity.BaseEntity;

/**
 * @Description 国美币交易限额信息
 * @author fengxin
 * @date 2015年11月13日 下午3:32:18
 */
public class VirtualLimitInfo extends BaseEntity {

	private static final long serialVersionUID = -2708831388800690604L;
	/*
	 * 单笔交易最小金额(分)
	 */
	private Integer singleMin;
	/**
	 * 单笔交易最大金额(分)
	 */
	private Integer singleMax;
	/*
	 * 单日交易最大笔数
	 */
	private Integer dayCount;
	/*
	 * 单日交易最大金额(分)
	 */
	private Integer dayMax;
	/*
	 * 单月最大金额(分)
	 */
	private Integer monthMax;
	/*
	 * 业务类型（1：国美币提现，2：国美币支付）
	 */
	private Integer limitType;
	/**
	 * @return the singleMin
	 */
	public Integer getSingleMin() {
		return singleMin;
	}
	/**
	 * @param singleMin the singleMin to set
	 */
	public void setSingleMin(Integer singleMin) {
		this.singleMin = singleMin;
	}
	/**
	 * @return the singleMax
	 */
	public Integer getSingleMax() {
		return singleMax;
	}
	/**
	 * @param singleMax the singleMax to set
	 */
	public void setSingleMax(Integer singleMax) {
		this.singleMax = singleMax;
	}
	/**
	 * @return the dayCount
	 */
	public Integer getDayCount() {
		return dayCount;
	}
	/**
	 * @param dayCount the dayCount to set
	 */
	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}
	/**
	 * @return the dayMax
	 */
	public Integer getDayMax() {
		return dayMax;
	}
	/**
	 * @param dayMax the dayMax to set
	 */
	public void setDayMax(Integer dayMax) {
		this.dayMax = dayMax;
	}
	/**
	 * @return the monthMax
	 */
	public Integer getMonthMax() {
		return monthMax;
	}
	/**
	 * @param monthMax the monthMax to set
	 */
	public void setMonthMax(Integer monthMax) {
		this.monthMax = monthMax;
	}
	/**
	 * @return the limitType
	 */
	public Integer getLimitType() {
		return limitType;
	}
	/**
	 * @param limitType the limitType to set
	 */
	public void setLimitType(Integer limitType) {
		this.limitType = limitType;
	}
	
	
	

}
