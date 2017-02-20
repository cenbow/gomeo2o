package com.gomeo2o.facade.account.entity;

import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;
/**
 * 
 * @Description: 积分信息实体
 * @author: fengxin
 * @date: 2015年3月20日 下午1:55:33
 */
public class ScoreInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2920324272709880520L;
	/**
	 * 可用积分
	 */
	private Integer count;
	/**
	 * 积分状态：1：可用，0，冻结
	 */
	private Integer state;
	/**
	 * 交易日期
	 */
	private Date dealTime;
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 累计积分
	 */
	private Integer totalCount;
	/**
	 * 查询参数  交易开始时间
	 */
	private Date siStartDealTime;
	/**
	 * 查询参数  交易结束时间
	 */
	private Date siEndDealTime;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Date getSiStartDealTime() {
		return siStartDealTime;
	}
	public void setSiStartDealTime(Date siStartDealTime) {
		this.siStartDealTime = siStartDealTime;
	}
	public Date getSiEndDealTime() {
		return siEndDealTime;
	}
	public void setSiEndDealTime(Date siEndDealTime) {
		this.siEndDealTime = siEndDealTime;
	}
	
	
	
}
