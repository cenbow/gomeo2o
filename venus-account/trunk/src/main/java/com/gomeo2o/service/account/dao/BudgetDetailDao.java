/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:00:56
 */
package com.gomeo2o.service.account.dao;

import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.BudgetDetail;

/**
 * @Description: 预算明细dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:00:56
 */
public interface BudgetDetailDao extends BaseDao<BudgetDetail> {
	/**
	 * 
	 * @Description: 增加预算流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:29:48
     * @param map
     * @return void    
	 */
	public void addBudgetDetail(Map<String,Object> map);

}
