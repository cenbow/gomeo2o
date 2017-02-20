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
import com.gomeo2o.service.account.dao.BudgetInfoDao;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:14:50
 */
@Service("budgetInfoBiz")
public class BudgetInfoBiz {
	
	@Autowired
	private BudgetInfoDao budgetInfoDao;
	
	/**
	 * 
	 * @Description: 增加预算信息
     * @author: fengxin
     * @date: 2015年4月30日 下午3:16:27
     * @param map
     * @return void    
	 */
	public void addBudgetInfo(Map<String,Object> map){
		this.budgetInfoDao.addBudgetInfo(map);
	}
	/**
	 * 
	 * @Description: 预算列表查询 带分页 带条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:53:34
     * @param reqParam
     * @param pageParam
     * @return List<BudgetInfo>    
	 */
	public PageBean queryBudgetByParamer(Map<String,Object> reqParam,PageParam pageParam){
		return this.budgetInfoDao.listPage(pageParam, reqParam);
	}
}
