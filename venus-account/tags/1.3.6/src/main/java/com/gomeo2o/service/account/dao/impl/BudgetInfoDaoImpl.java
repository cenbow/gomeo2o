/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:04:23
 */
package com.gomeo2o.service.account.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.BudgetInfo;
import com.gomeo2o.service.account.dao.BudgetInfoDao;

/**
 * @Description: 预算信息dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:04:23
 */
@Repository("budgetInfoDao")
public class BudgetInfoDaoImpl extends BaseDaoImpl<BudgetInfo> implements BudgetInfoDao {
	/**
	 * 
	 * @Description: 增加预算信息
     * @author: fengxin
     * @date: 2015年4月30日 下午3:16:27
     * @param map
     * @return void    
	 */
	public void addBudgetInfo(Map<String,Object> map){
		this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.BudgetInfoDaoImpl.addBudgetInfo", map);
	}
}
