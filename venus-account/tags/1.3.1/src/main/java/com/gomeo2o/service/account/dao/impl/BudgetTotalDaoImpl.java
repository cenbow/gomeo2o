/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:10:35
 */
package com.gomeo2o.service.account.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.BudgetTotal;
import com.gomeo2o.service.account.dao.BudgetTotalDao;

/**
 * @Description: 预算总额Dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:10:35
 */
@Repository("budgetTotalDao")
public class BudgetTotalDaoImpl extends BaseDaoImpl<BudgetTotal> implements
		BudgetTotalDao {
	/**
	 * 
	 * @Description: 查询预算信息
     * @author: fengxin
     * @date: 2015年5月6日 上午11:39:56
     * @param map
     * @return List<BudgetTotal>
	 */
	public List<BudgetTotal> queryBudgetTotal(Map<String,Object> map){
		return this.getSessionTemplate().selectList("com.gomeo2o.service.account.dao.impl.BudgetTotalDaoImpl.queryBudgetTotal", map);
	}
	
	/**
	 * 
	 * @Description: 冻结预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @return void
	 */
	public int updateFrBudgetInfo(Map<String,Object> map){
		if("0".equals(String.valueOf(map.get("recordValue")))){
			return 1;
		}else{
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.BudgetTotalDaoImpl.updateFrBudgetInfo", map);
		}
	}
	/**
	 * 
	 * @Description: 扣减预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @return int
	 */
	public int updateCutBudgetInfo(Map<String,Object> map){
		if("0".equals(String.valueOf(map.get("recordValue")))){
			return 1;
		}else{
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.BudgetTotalDaoImpl.updateCutBudgetInfo", map);
		}
	}
	/**
	 * 
	 * @Description: 直接扣减预算
     * @author: fengxin
     * @date: 2015年9月23日 上午11:21:58
     * @param map
     * @return int    
	 */
	public int updateCutBudgetInfoNoFr(Map<String,Object> map){
		if("0".equals(String.valueOf(map.get("recordValue")))){
			return 1;
		}else{
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.BudgetTotalDaoImpl.updateCutBudgetInfoNoFr", map);
		}
	}
	
	/**
	 * 
	 * @Description: 撤销扣减预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @return CommonResultEntity<String>    
	 */
	public int updateReSetFrBudgetInfo(Map<String,Object> map){
		if("0".equals(String.valueOf(map.get("recordValue")))){
			return 1;
		}else{
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.BudgetTotalDaoImpl.updateReSetFrBudgetInfo", map);
		}
	}
	/**
	 * 
	 * @Description: 根据参数查询预算总额信息
     * @author: fengxin
     * @date: 2015年5月19日 下午12:26:08
     * @param map
     * @return BudgetTotal    
	 */
	public BudgetTotal queryBudgetTotalByParamer(Map<String,Object> map){
		return this.getSessionTemplate().selectOne("com.gomeo2o.service.account.dao.impl.BudgetTotalDaoImpl.queryBudgetTotalByParamer", map);
	}
	/**
	 * 
	 * @Description: 创建预算总额信息
     * @author: fengxin
     * @date: 2015年6月17日 下午4:33:02
     * @param map
     * @return int    
	 */
	public int createBudgetTotal(Map<String,Object> map){
		return this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.BudgetTotalDaoImpl.addBudgetTotal", map);
	}
	
	/**
	 * 
	 * @Description: 修改预算总额
     * @author: fengxin
     * @date: 2015年6月17日 下午4:43:52
     * @param map
     * @return int    
	 */
	public int updateBudgetTotal(Map<String,Object> map){
		return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.BudgetTotalDaoImpl.updateBudgetTotal", map);
	}


}
