/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:07:58
 */
package com.gomeo2o.service.account.dao.impl;



import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.BudgetDetail;
import com.gomeo2o.service.account.dao.BudgetDetailDao;

/**
 * @Description: 预算明细Dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:07:58
 */
@Repository("budgetDetailDao")
public class BudgetDetailDaoImpl extends BaseDaoImpl<BudgetDetail> implements BudgetDetailDao {
	/**
	 * 
	 * @Description: 增加预算流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:29:48
     * @param map
     * @return void    
	 */
	public void addBudgetDetail(Map<String,Object> map){
		this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.BudgetDetailDaoImpl.addBudgetDetail", map);
	}
	
}
