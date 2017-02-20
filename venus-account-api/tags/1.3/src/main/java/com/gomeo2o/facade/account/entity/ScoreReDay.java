package com.gomeo2o.facade.account.entity;

import com.gomeo2o.common.entity.BaseEntity;
/**
 * 
 * @Description: 日积分上限余额
 * @author: fengxin
 * @date: 2015年3月31日 上午10:35:50
 */
public class ScoreReDay extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5884989991832253706L;
	
	/**
	 * 年月日
	 */
	private String recordDate;
	/**
	 * 规格ID
	 */
	private long ruleId;
	/**
	 * 日积分上限余额
	 */
	private Integer dayTop;
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public long getRuleId() {
		return ruleId;
	}
	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}
	public Integer getDayTop() {
		return dayTop;
	}
	public void setDayTop(Integer dayTop) {
		this.dayTop = dayTop;
	}

}
