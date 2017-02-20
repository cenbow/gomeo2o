/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:03:30
 */
package com.gomeo2o.service.account.dao;

import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.BudgetInfo;

/**
 * @Description: 预算信息dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:03:30
 */
public interface BudgetInfoDao extends BaseDao<BudgetInfo> {
	
	/**
	 * 
	 * @Description: 增加预算信息
     * @author: fengxin
     * @date: 2015年4月30日 下午3:16:27
     * @param map
     * @return void    
	 */
	public void addBudgetInfo(Map<String,Object> map);
}
