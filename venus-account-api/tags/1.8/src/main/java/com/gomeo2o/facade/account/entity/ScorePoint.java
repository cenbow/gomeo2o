package com.gomeo2o.facade.account.entity;


import com.gomeo2o.common.entity.BaseEntity;
import com.gomeo2o.facade.account.utils.ValidAnnotation;
/**
 * 
 * @Description: 积分埋点实体
 * @author: fengxin
 * @date: 2015年3月20日 下午1:56:05
 */
public class ScorePoint extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 149131343488796286L;
	/**
	 * 积分埋点编号
	 */
	@ValidAnnotation(description="积分埋点编号",nullable=false)
	private String code;
	/**
	 * 积分埋点名称
	 */
	@ValidAnnotation(description="积分埋点名称",nullable=false)
	private String name;
	/**
	 * 积分规则类型
	 */
	@ValidAnnotation(description="积分规则类型",nullable=false)
	private Long ruleId;
	/**
	 * 是否启用  1启用     0 未启用
	 */
	@ValidAnnotation(description="是否启用",minLength=1,maxLength=1,nullable=false)
	private Integer isEnable;
	/**
	 * 创建者
	 */
	@ValidAnnotation(description="创建者",nullable=false)
	private String creator;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRuleId() {
		return ruleId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
	

}
