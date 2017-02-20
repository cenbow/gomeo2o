/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:39:42
 */
package com.gomeo2o.facade.account.service;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.BudgetTotal;

/**
 * @Description: 预算总额 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:39:42
 */
public interface BudgetTotalFacade {
	/**
	 * 
	 * @Description: 查询预算信息
     * @author: fengxin
     * @date: 2015年5月6日 上午11:39:56
     * @param map
     * @return List<BudgetTotal>
	 */
	public CommonResultEntity<List<Map<String,Object>>> queryBudgetTotal(Map<String,Object> map);
	/**
	 * 
	 * @Description: 扣减预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午4:01:38
     * @param map
     * @return List<Map<String,Object>> list
	 */
	public CommonResultEntity<String> updateCutBudgetInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description: 冻结预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午4:01:38
     * @param list
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateFrBudgetInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description: 撤销冻结
     * @author: fengxin
     * @date: 2015年5月4日 下午7:35:53
     * @param list
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateReSetFrBudgetInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description: 扣减预算总额（批量）
     * @author: fengxin
     * @date: 2015年4月30日 下午4:01:38
     * @param list
     * @return List<Map<String,Object>> list
	 */
	public CommonResultEntity<String> updateCutBudgetInfo(List<Map<String,Object>> list);
	/**
	 * 
	 * @Description: 直接扣减预算额度
     * @author: fengxin
     * @date: 2015年9月23日 上午11:27:33
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCutBudgetInfoNoFr(Map<String,Object> map);
	/**
	 * 
	 * @Description: 直接扣减预算额度 批量
     * @author: fengxin
     * @date: 2015年9月24日 下午12:17:20
     * @param list
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCutBudgetInfoNoFr(List<Map<String,Object>> list);
	/**
	 * 
	 * @Description: 冻结预算总额（批量）
     * @author: fengxin
     * @date: 2015年4月30日 下午4:01:38
     * @param list
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateFrBudgetInfo(List<Map<String,Object>> list);
	/**
	 * 
	 * @Description: 撤销冻结（批量）
     * @author: fengxin
     * @date: 2015年5月4日 下午7:35:53
     * @param list
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateReSetFrBudgetInfo(List<Map<String,Object>> list);
	
	/**
	 * 
	 * @Description: 根据参数查询预算总额信息
     * @author: fengxin
     * @date: 2015年5月19日 下午12:26:08
     * @param map
     * @return CommonResultEntity<BudgetTotal>    
	 */
	public CommonResultEntity<BudgetTotal> queryBudgetTotalByParamer(Map<String,Object> map);
	/**
	 * 
	 * @Description: 查询预算总额  分页
     * @author: fengxin
     * @date: 2015年6月3日 下午5:13:27
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryBudgetTotalByParamer(Map<String,Object> reqParam,PageParam pageParam);
	/**
	 * 
	 * @Description: 添加预算总额
     * @author: fengxin
     * @date: 2015年6月17日 下午4:19:29
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> createBudgetTotalBySAP(Map<String,Object> reqParam);

}
