/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:40:23
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.BudgetTotal;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.facade.account.service.BudgetTotalFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.BudgetTotalBiz;
import com.gomeo2o.utils.Constants;

/**
 * @Description: 预算总额
 * @author: fengxin
 * @date: 2015年4月30日 下午3:40:23
 */
@Service("budgetTotalFacade")
public class BudgetTotalServiceImpl implements BudgetTotalFacade{
	
	@Autowired
	private BudgetTotalBiz budgetTotalBiz;
	
	/**
	 * 
	 * @Description: 查询预算信息
     * @author: fengxin
     * @date: 2015年5月6日 上午11:39:56
     * @param map
     * @return CommonResultEntity<List<Map<String,Object>>>
	 */
	public CommonResultEntity<List<Map<String,Object>>> queryBudgetTotal(Map<String,Object> map){
		CommonResultEntity<List<Map<String,Object>>> crs = new CommonResultEntity<List<Map<String,Object>>>();
		List<BudgetTotal> list = this.budgetTotalBiz.queryBudgetTotal(map);
		List<Map<String,Object>> re_list = new ArrayList<Map<String,Object>>();
		Map<String,Object> re_map = null;
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				re_map = new HashMap<String,Object>();
				re_map.put("budgetNo", list.get(i).getBudgetNo());
				re_map.put("budgetTotal", list.get(i).getBudgetTotal());
				re_map.put("budgetBa", list.get(i).getBudgetBa());
				re_map.put("budgetFr", list.get(i).getBudgetFr());
				re_map.put("marketLimit", list.get(i).getMarketLimit());
				re_map.put("startTime", list.get(i).getStartTime());
				re_map.put("endTime", list.get(i).getEndTime());
				re_list.add(re_map);
			}
		}
		crs.setBusinessObj(re_list);
		return crs;
	}
	/**
	 * 
	 * @Description: 冻结预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateFrBudgetInfo(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(map);
		map.put("detailNo", Constants.getRebateDetailNo());
		this.budgetTotalBiz.updateFrBudgetInfo(map);
		return crs;
	}
	/**
	 * 
	 * @Description: 扣减预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param map
     * @return List<Map<String,Object>> list
	 */
	public CommonResultEntity<String> updateCutBudgetInfo(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(map);
		map.put("detailNo", Constants.getRebateDetailNo());
		this.budgetTotalBiz.updateCutBudgetInfo(map);
		return crs;
	}
	/**
	 * 
	 * @Description: 直接扣减预算额度
     * @author: fengxin
     * @date: 2015年9月23日 上午11:27:33
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCutBudgetInfoNoFr(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(map);
		map.put("detailNo", Constants.getRebateDetailNo());
		this.budgetTotalBiz.updateCutBudgetInfoNoFr(map);
		return crs;
	}
	/**
	 * 
	 * @Description: 直接扣减预算额度 批量
     * @author: fengxin
     * @date: 2015年9月24日 下午12:17:20
     * @param list
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCutBudgetInfoNoFr(List<Map<String,Object>> list){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		this.budgetTotalBiz.updateCutBudgetInfoNoFr(list);
		return crs;
	}
	/**
	 * 
	 * @Description: 撤销冻结
     * @author: fengxin
     * @date: 2015年5月4日 下午7:35:53
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateReSetFrBudgetInfo(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(map);
		map.put("detailNo", Constants.getRebateDetailNo());
		this.budgetTotalBiz.updateReSetFrBudgetInfo(map);
		return crs;
	}
	
	/**
	 * 
	 * @Description: 冻结预算总额(批量)
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param list
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateFrBudgetInfo(List<Map<String,Object>> list){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				map = list.get(i);
				ValidateMapService.validate(map);
				map.put("detailNo", Constants.getRebateDetailNo());
				this.budgetTotalBiz.updateFrBudgetInfo(map);
			}
		}else{
			throw AccountException.REQLIST_ERROE;
		}
		return crs;
	}
	/**
	 * 
	 * @Description: 扣减预算总额（批量）
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param list
     * @return List<Map<String,Object>> list
	 */
	public CommonResultEntity<String> updateCutBudgetInfo(List<Map<String,Object>> list){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				map = list.get(i);
				ValidateMapService.validate(map);
				map.put("detailNo", Constants.getRebateDetailNo());
				this.budgetTotalBiz.updateCutBudgetInfo(map);
			}
		}else{
			throw AccountException.REQLIST_ERROE;
		}
		return crs;
	}
	/**
	 * 
	 * @Description: 撤销冻结（批量）
     * @author: fengxin
     * @date: 2015年5月4日 下午7:35:53
     * @param list
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateReSetFrBudgetInfo(List<Map<String,Object>> list){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				map = list.get(i);
				ValidateMapService.validate(map);
				map.put("detailNo", Constants.getRebateDetailNo());
				this.budgetTotalBiz.updateReSetFrBudgetInfo(map);
			}
		}else{
			throw AccountException.REQLIST_ERROE;
		}
		return crs;
	}
	
	/**
	 * 
	 * @Description: 根据参数查询预算总额信息
     * @author: fengxin
     * @date: 2015年5月19日 下午12:26:08
     * @param map
     * @return CommonResultEntity<BudgetTotal>    
	 */
	public CommonResultEntity<BudgetTotal> queryBudgetTotalByParamer(Map<String,Object> map){
		CommonResultEntity<BudgetTotal> crs = new CommonResultEntity<BudgetTotal>();
		ValidateMapService.validate(map);
		crs.setBusinessObj(this.budgetTotalBiz.queryBudgetTotalByParamer(map));
		return crs;
	}
	/**
	 * 
	 * @Description: 查询预算总额  分页
     * @author: fengxin
     * @date: 2015年6月3日 下午5:13:27
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryBudgetTotalByParamer(Map<String,Object> reqParam,PageParam pageParam){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(this.budgetTotalBiz.queryBudgetTotalByParamer(reqParam, pageParam));
		return crs;
	}
	
	/**
	 * 
	 * @Description: 添加预算总额
     * @author: fengxin
     * @date: 2015年6月17日 下午4:19:29
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> createBudgetTotalBySAP(Map<String,Object> reqParam){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		this.budgetTotalBiz.createBudgetTotalBySAP(reqParam);
		return crs;
	}

}
