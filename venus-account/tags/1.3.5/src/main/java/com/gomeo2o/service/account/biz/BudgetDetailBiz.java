/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:14:50
 */
package com.gomeo2o.service.account.biz;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.service.account.dao.BudgetDetailDao;

/**
 * @Description: 预算流水
 * @author: fengxin
 * @date: 2015年4月30日 下午3:14:50
 */
@Service("budgetDetailBiz")
public class BudgetDetailBiz {
	
	@Autowired
	private BudgetDetailDao budgetDetailDao;
	
	/**
	 * 
	 * @Description: 增加预算流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:29:48
     * @param map
     * @return void    
	 */
	public void addBudgetDetail(Map<String,Object> map){
		this.budgetDetailDao.addBudgetDetail(map);
	}
	/**
	 * 
	 * @Description: 预算流水分页查询 带条件
     * @author: fengxin
     * @date: 2015年4月30日 下午5:02:11
     * @param reqParam
     * @param pageParam
     * @return List<BudgetDetail>    
	 */
	public PageBean queryBudgetDetailByParamer(Map<String,Object> reqParam,PageParam pageParam){
		return budgetDetailDao.listPage(pageParam, reqParam);
	}
	
	
}
