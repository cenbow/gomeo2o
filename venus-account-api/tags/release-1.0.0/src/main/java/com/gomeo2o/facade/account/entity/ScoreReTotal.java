package com.gomeo2o.facade.account.entity;

import com.gomeo2o.common.entity.BaseEntity;
/**
 * 
 * @Description: 总积分上限余额
 * @author: fengxin
 * @date: 2015年3月31日 上午10:33:27
 */
public class ScoreReTotal extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7994270443089276839L;
	/**
	 * 规格ID
	 */
	private long ruleId;
	/**
	 * 积分总上限余额
	 */
	private Integer totalTop;
	
	public long getRuleId() {
		return ruleId;
	}
	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}
	public Integer getTotalTop() {
		return totalTop;
	}
	public void setTotalTop(Integer totalTop) {
		this.totalTop = totalTop;
	}
	
}
