package com.gomeo2o.facade.account.entity;

import com.gomeo2o.common.entity.BaseEntity;
/**
 * @Description: 人/日积分上限余额
 * @author: fengxin
 * @date: 2015年3月31日 上午10:38:48
 */
public class ScoreReSingle extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6601335198507164863L;
	/**
	 * 日期  yyyy-MM-dd
	 */
	private String recordDate;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 规格ID
	 */
	private Long ruleId;
	/**
	 * 人/日积分上限余额
	 */
	private Integer singleTop;
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	public Integer getSingleTop() {
		return singleTop;
	}
	public void setSingleTop(Integer singleTop) {
		this.singleTop = singleTop;
	}

}
