/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:33:07
 */
package com.gomeo2o.facade.account.service;

import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;

/**
 * @Description: 预算流水
 * @author: fengxin
 * @date: 2015年4月30日 下午3:33:07
 */
public interface BudgetDetailFacade {
	/**
	 * 
	 * @Description: 增加预算流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:34:08
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addBudgetDetail(Map<String,Object> map);
	/**
	 * 
	 * @Description: 预算流水分页查询 带条件
     * @author: fengxin
     * @date: 2015年4月30日 下午5:02:11
     * @param reqParam
     * @param pageParam
     * @return List<BudgetDetail>    
	 */
	public CommonResultEntity<PageBean> queryBudgetDetailByParamer(Map<String,Object> reqParam,PageParam pageParam);

}
