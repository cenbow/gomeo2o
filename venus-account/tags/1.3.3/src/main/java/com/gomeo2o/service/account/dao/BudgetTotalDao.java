/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:10:05
 */
package com.gomeo2o.service.account.dao;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.BudgetTotal;

/**
 * @Description: 预算总额Dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:10:05
 */
public interface BudgetTotalDao extends BaseDao<BudgetTotal> {
	/**
	 * 
	 * @Description: 查询预算信息
     * @author: fengxin
     * @date: 2015年5月6日 上午11:39:56
     * @param map
     * @return List<BudgetTotal>
	 */
	public List<BudgetTotal> queryBudgetTotal(Map<String,Object> map);
	
	/**
	 * 
	 * @Description: 扣减预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @return int
	 */
	public int updateFrBudgetInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description: 撤销扣减预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param map
     * @return int
	 */
	public int updateReSetFrBudgetInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description: 扣减预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param map
     * @return int
	 */
	public int updateCutBudgetInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description: 直接扣减预算
     * @author: fengxin
     * @date: 2015年9月23日 上午11:21:58
     * @param map
     * @return int    
	 */
	public int updateCutBudgetInfoNoFr(Map<String,Object> map);
	/**
	 * 
	 * @Description: 根据参数查询预算总额信息
     * @author: fengxin
     * @date: 2015年5月19日 下午12:26:08
     * @param map
     * @return BudgetTotal    
	 */
	public BudgetTotal queryBudgetTotalByParamer(Map<String,Object> map);
	/**
	 * 
	 * @Description: 创建预算总额信息
     * @author: fengxin
     * @date: 2015年6月17日 下午4:33:02
     * @param map
     * @return int    
	 */
	public int createBudgetTotal(Map<String,Object> map);
	/**
	 * 
	 * @Description: 修改预算总额
     * @author: fengxin
     * @date: 2015年6月17日 下午4:43:52
     * @param map
     * @return int    
	 */
	public int updateBudgetTotal(Map<String,Object> map);

}
