package com.gomeo2o.facade.account.entity;

import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;
import com.gomeo2o.facade.account.utils.RegexType;
import com.gomeo2o.facade.account.utils.ValidAnnotation;
/**
 * 
 * @Description: 积分规则实体
 * @author: fengxin
 * @date: 2015年3月20日 下午1:56:48
 */
public class ScoreRule extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6415429102342793080L;
	/**
	 * 积分规则名称
	 */
	@ValidAnnotation(description="积分规则名称",nullable=false)
	private String ruleName;
	/**
	 * 积分获取规则类型  1 ：按次分享返积分 2：按比例返积分 3:阶梯式满返积分
	 */
	@ValidAnnotation(description="积分获取规则类型",nullable=false)
	private Integer ruleState;
	/**
	 * 积分获取值
	 */
	@ValidAnnotation(description="积分获取值",nullable=false)
	private String recordValue;
	/**	
	 * 多少天之后开始返积分
	 */
	@ValidAnnotation(description="多少天之后开始返积分",nullable=false,regexType=RegexType.NUMBER)
	private Integer recordTimeStr;
	/**
	 * 开始时间
	 */
	@ValidAnnotation(description="开始时间",nullable=false)
	private Date startTime;
	/**
	 * 结束时间
	 */
	@ValidAnnotation(description="结束时间",nullable=false)
	private Date endTime;
	/**
	 * 日积分上限
	 */
	@ValidAnnotation(description="日积分上限",nullable=false,regexType=RegexType.NUMBER)
	private Integer dayTop;
	/**
	 * 总积分上限
	 */
	@ValidAnnotation(description="总积分上限",nullable=false,regexType=RegexType.NUMBER)
	private Integer totalTop;
	/**
	 * 人/日获取积分上限
	 */
	@ValidAnnotation(description="人/日获取积分上限",nullable=false,regexType=RegexType.NUMBER)
	private Integer singleTop;
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public Integer getRuleState() {
		return ruleState;
	}
	public void setRuleState(Integer ruleState) {
		this.ruleState = ruleState;
	}
	public String getRecordValue() {
		return recordValue;
	}
	public void setRecordValue(String recordValue) {
		this.recordValue = recordValue;
	}
	public Integer getRecordTimeStr() {
		return recordTimeStr;
	}
	public void setRecordTimeStr(Integer recordTimeStr) {
		this.recordTimeStr = recordTimeStr;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getDayTop() {
		return dayTop;
	}
	public void setDayTop(Integer dayTop) {
		this.dayTop = dayTop;
	}
	public Integer getTotalTop() {
		return totalTop;
	}
	public void setTotalTop(Integer totalTop) {
		this.totalTop = totalTop;
	}
	public Integer getSingleTop() {
		return singleTop;
	}
	public void setSingleTop(Integer singleTop) {
		this.singleTop = singleTop;
	}
	
	
}
