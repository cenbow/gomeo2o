/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:14:00
 */
package com.gomeo2o.facade.account.service;

import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;

/**
 * @Description: 预算信息
 * @author: fengxin
 * @date: 2015年4月30日 下午3:14:00
 */
public interface BudgetInfoFacade {
	
	/**
	 * 
	 * @Description: 增加预算信息
     * @author: fengxin
     * @date: 2015年4月30日 下午3:16:27
     * @param map
     * @return void    
	 */
	public CommonResultEntity<String> addBudgetInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description: 预算列表查询 带分页 带条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:55:33
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<List<BudgetInfo>>    
	 */
	public CommonResultEntity<PageBean> queryBudgetByParamer(Map<String,Object> reqParam,PageParam pageParam);
}
