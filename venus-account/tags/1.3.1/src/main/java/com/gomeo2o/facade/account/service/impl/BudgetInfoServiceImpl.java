/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:14:33
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.service.BudgetInfoFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.BudgetInfoBiz;

/**
 * @Description: 预算信息
 * @author: fengxin
 * @date: 2015年4月30日 下午3:14:33
 */
@Service("budgetInfoFacade")
public class BudgetInfoServiceImpl implements BudgetInfoFacade {
	
	@Autowired
	private BudgetInfoBiz budgetInfoBiz;
	
	/**
	 * 
	 * @Description: 增加预算信息
     * @author: fengxin
     * @date: 2015年4月30日 下午3:16:27
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addBudgetInfo(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(map);
		this.budgetInfoBiz.addBudgetInfo(map);
		return crs;
	}
	
	/**
	 * 
	 * @Description: 预算列表查询 带分页 带条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:55:33
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryBudgetByParamer(Map<String,Object> reqParam,PageParam pageParam){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(budgetInfoBiz.queryBudgetByParamer(reqParam, pageParam));
		return crs;
	}

}
