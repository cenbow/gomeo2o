/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:33:32
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.service.BudgetDetailFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.BudgetDetailBiz;
import com.gomeo2o.utils.Constants;

/**
 * @Description: 预算流水
 * @author: fengxin
 * @date: 2015年4月30日 下午3:33:32
 */
@Service("budgetDetailFacade")
public class BudgetDetailServiceImpl implements BudgetDetailFacade {
	
	@Autowired
	private BudgetDetailBiz budgetDetailBiz;
	
	/**
	 * 
	 * @Description: 增加预算流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:34:08
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addBudgetDetail(Map<String,Object> map){
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		ValidateMapService.validate(map);
		map.put("detailNo", Constants.getBudgetDetailNo());
		this.budgetDetailBiz.addBudgetDetail(map);
		return rcs;
	}
	/**
	 * 
	 * @Description: 预算流水分页查询 带条件
     * @author: fengxin
     * @date: 2015年4月30日 下午5:02:11
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryBudgetDetailByParamer(Map<String,Object> reqParam,PageParam pageParam){
		CommonResultEntity<PageBean> rcs = new CommonResultEntity<PageBean>();
		rcs.setBusinessObj(this.budgetDetailBiz.queryBudgetDetailByParamer(reqParam, pageParam));
		return rcs;
	}

}
