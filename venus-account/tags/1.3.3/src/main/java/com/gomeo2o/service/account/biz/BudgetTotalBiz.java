/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午3:39:03
 */
package com.gomeo2o.service.account.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.BudgetTotal;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.dao.BudgetDetailDao;
import com.gomeo2o.service.account.dao.BudgetTotalDao;
import com.gomeo2o.utils.Constants;

/**
 * @Description: 预算总额
 * @author: fengxin
 * @date: 2015年4月30日 下午3:39:03
 */
@Service("budgetTotalBiz")
public class BudgetTotalBiz {
	/**
	 * 预算总额Dao
	 */
	@Autowired
	private BudgetTotalDao budgetTotalDao;
	/**
	 * 预算流水Dao
	 */
	@Autowired
	private BudgetDetailDao budgetDetailDao;
	
	/**
	 * 
	 * @Description: 查询预算信息
     * @author: fengxin
     * @date: 2015年5月6日 上午11:39:56
     * @param map
     * @return List<BudgetTotal>
	 */
	public List<BudgetTotal> queryBudgetTotal(Map<String,Object> map){
		return this.budgetTotalDao.queryBudgetTotal(map);
	}
	
	/**
	 * 
	 * @Description: 冻结预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param map
     * @return void
	 */
	@Transactional
	public void updateFrBudgetInfo(Map<String,Object> map){
		int updateFlag = this.budgetTotalDao.updateFrBudgetInfo(map);
		//如果修改条数大于0
		if(updateFlag>0){
			this.budgetDetailDao.addBudgetDetail(map);
		}else{
			throw AccountException.BUDGET_UPDATE_ERROE;
		}
	}
	/**
	 * 
	 * @Description: 撤销冻结预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param map
     * @return void
	 */
	@Transactional
	public void updateReSetFrBudgetInfo(Map<String,Object> map){
		int updateFlag = this.budgetTotalDao.updateReSetFrBudgetInfo(map);
		if(updateFlag>0){
			this.budgetDetailDao.addBudgetDetail(map);
		}else{
			throw AccountException.BUDGET_UPDATE_ERROE;
		}
	}
	/**
	 * 
	 * @Description: 扣减预算总额
     * @author: fengxin
     * @date: 2015年4月30日 下午3:36:49
     * @param map
     * @return void
	 */
	@Transactional
	public void updateCutBudgetInfo(Map<String,Object> map){
		int updateFlag = this.budgetTotalDao.updateCutBudgetInfo(map);
		if(updateFlag>0){
			this.budgetDetailDao.addBudgetDetail(map);
		}else{
			throw AccountException.BUDGET_UPDATE_ERROE;
		}
	}
	/**
	 * 
	 * @Description: 直接扣减预算额度
     * @author: fengxin
     * @date: 2015年9月23日 上午11:26:07
     * @param map
     * @return void    
	 */
	@Transactional
	public void updateCutBudgetInfoNoFr(Map<String,Object> map){
		int updateFlag = this.budgetTotalDao.updateCutBudgetInfoNoFr(map);
		if(updateFlag>0){
			this.budgetDetailDao.addBudgetDetail(map);
		}else{
			throw AccountException.BUDGET_UPDATE_ERROE;
		}
	}
	/**
	 * 
	 * @Description: 直接扣减预算额度 批量
     * @author: fengxin
     * @date: 2015年9月24日 下午12:13:29
     * @param list
     * @return void    
	 */
	@Transactional
	public void updateCutBudgetInfoNoFr(List<Map<String,Object>> list){
		if(list.size()>0){
			Map<String,Object> map = new HashMap<String,Object>();
			for (int i = 0; i < list.size(); i++) {
				map = list.get(i);
				ValidateMapService.validate(map);
				map.put("detailNo", Constants.getRebateDetailNo());
				int updateFlag = 0;
				updateFlag = this.budgetTotalDao.updateCutBudgetInfoNoFr(map);
				if(updateFlag>0){
					this.budgetDetailDao.addBudgetDetail(map);
				}else{
					throw AccountException.BUDGET_UPDATE_ERROE;
				}

			}
			
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
		BudgetTotal budgetTotal = this.budgetTotalDao.queryBudgetTotalByParamer(map);
		if(budgetTotal!=null&&!"".equals(budgetTotal)){
			return budgetTotal;
		}else{
			throw AccountException.BUDGET_NOLL_ERROE;
		}
	}
	/**
	 * 
	 * @Description: 查询预算额度  分页
     * @author: fengxin
     * @date: 2015年6月3日 下午5:15:01
     * @param reqParam
     * @param pageParam
     * @return PageBean    
	 */
	public PageBean queryBudgetTotalByParamer(Map<String,Object> reqParam,PageParam pageParam){
		return this.budgetTotalDao.listPage(pageParam, reqParam);
	}
	/**
	 * 
	 * @Description: 添加预算总额
     * @author: fengxin
     * @date: 2015年6月17日 下午4:19:29
     * @param reqParam
     * @return void    
	 */
	public void createBudgetTotalBySAP(Map<String,Object> reqParam){
		BudgetTotal budgetTotal = this.budgetTotalDao.queryBudgetTotalByParamer(reqParam);
		if(budgetTotal==null){
			reqParam.put("budgetBa", reqParam.get("budgetTotal"));
			reqParam.put("budgetFr", 0);
			this.budgetTotalDao.createBudgetTotal(reqParam);
		}else{
			this.budgetTotalDao.updateBudgetTotal(reqParam);
		}
	}
}
