/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午3:29:14
 */
package com.gomeo2o;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.h2.constant.SysProperties;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.BudgetTotal;
import com.gomeo2o.facade.account.service.BudgetTotalFacade;
import com.gomeo2o.utils.Constants;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午3:29:14
 */
public class TestBudgetTotal extends BaseTest {
	
	public static BudgetTotalFacade budgetTotalFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		budgetTotalFacade = (BudgetTotalFacade) context
				.getBean("budgetTotalFacade");
	}
	/**
	 * 
	 * @Description: 冻结预算余额 同时插入预算流水
     * @author: fengxin
     * @date: 2015年5月4日 下午3:37:28
     * @return void    
     * @throws
	 */
	public void utestUpdateFrBudgetInfo(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("recordValue", 1.23);
		map.put("budgetNo", 991);
		//预算流水部分信息
		map.put("userId", 1);
		map.put("detailNo", Constants.getRebateDetailNo());
		map.put("orderNo", 1);
		map.put("cardId", 1);
		map.put("budgetTime", new Date());
		map.put("budgetType", 1);
		map.put("state", 0);
		list.add(map);
		CommonResultEntity<String> crs = budgetTotalFacade.updateFrBudgetInfo(list);
		assertTrue("保存失败", crs.getCode()==0);
	}
	/**
	 * 
	 * @Description: 扣减预算余额
     * @author: fengxin
     * @date: 2015年5月4日 下午3:37:41
     * @return void    
     * @throws
	 */
	public void utestUpdateCutBudgetInfo(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("recordValue", 884);
		map.put("budgetNo", "12");
		//预算流水部分信息
		map.put("userId", 12345678);
		map.put("orderNo", 1);
		map.put("cardId", 1);
		map.put("budgetTime", new Date());
		map.put("budgetType", 1);
		map.put("state", 1);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map);
		CommonResultEntity<String> crs = budgetTotalFacade.updateCutBudgetInfo(list);
		assertTrue("保存失败", crs.getCode()==0);
	}
	/**
	 * 
	 * @Description: 撤销预算值
     * @author: fengxin
     * @date: 2015年5月6日 下午3:53:17
     * @return void    
	 */
	public void utestUpdateReSetFrBudgetInfo(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("recordValue", 100);
		map.put("budgetNo", 12);
		//预算流水部分信息
		map.put("userId", 1);
		map.put("detailNo", Constants.getRebateDetailNo());
		map.put("orderNo", 1);
		map.put("cardId", 1);
		map.put("budgetTime", new Date());
		map.put("budgetType", 1);
		map.put("state", 2);
		list.add(map);
		CommonResultEntity<String> crs  = budgetTotalFacade.updateReSetFrBudgetInfo(list);
		assertTrue("保存失败", crs.getCode()==0);
	}
	/**
	 * 
	 * @Description: 查询预算信心列表
     * @author: fengxin
     * @date: 2015年5月6日 下午12:08:24
     * @return void    
	 */
	public void utestQueryBudgetTotal(){
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("budgetType", 1);
		CommonResultEntity<List<Map<String,Object>>> crs  = budgetTotalFacade.queryBudgetTotal(map);
		assertNotNull("查询结果为空", crs.getBusinessObj());
	}
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年5月19日 下午12:39:55
     * @return void    
	 */
	public void utestQueryBudgetTotalByParamer(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("budgetNo", 12);
		CommonResultEntity<BudgetTotal> crs = budgetTotalFacade.queryBudgetTotalByParamer(map);
		assertNotNull("查询结果为空", crs.getBusinessObj());
	}
	
	public void utestQueryBudgetTotalByPage(){
		Map<String,Object> map = new HashMap<String,Object>();
		CommonResultEntity<PageBean> crs = budgetTotalFacade.queryBudgetTotalByParamer(map, new PageParam(1, 3));
		System.out.println(crs.getBusinessObj().getRecordList().size());
	}
	
	public void testCreateBudgetTotalBySAP(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("budgetNo", "000100000068");
		map.put("budgetTotal", -100);
		map.put("startTime", "2017-01-01 00:00:00");
		map.put("endTime", "2016-12-31 00:00:00");
		map.put("budgetType", 1);
		map.put("budgetBa", map.get("budgetTotal"));
		map.put("marketLimit", "这是一个测试");
		map.put("budgetYear", "2016");
		CommonResultEntity<String> crs = budgetTotalFacade.createBudgetTotalBySAP(map);
		System.out.println("fengixn");
	}
}
