/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午3:10:48
 */
package com.gomeo2o;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.service.BudgetInfoFacade;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午3:10:48
 */
public class TestBudgetInfo extends BaseTest {
	
	public static BudgetInfoFacade budgetInfoFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		budgetInfoFacade = (BudgetInfoFacade) context
				.getBean("budgetInfoFacade");
	}
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年5月4日 下午3:11:53
     * @return void    
     * @throws
	 */
	public void testAddBudgetInfo(){
		for (int i = 0; i < 1; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			//#{userId},#{budgetNo},#{budgetValue},#{budgetType},#{startTime},#{endTime},#{marketLimit},#{remark}
			map.put("userId", 12345678);
			map.put("budgetNo", 11111002);
			map.put("budgetValue", 100000);
			map.put("budgetType", 1);
			map.put("startTime", new Date());
			map.put("endTime", new Date());
			map.put("marketLimit", "二级品类类目限制");
			map.put("remark", "这是一个测试");
			CommonResultEntity<String> crs = budgetInfoFacade.addBudgetInfo(map);
			assertTrue("添加失败", crs.getCode()==0);
		}
		
	}
	/**
	 * 
	 * @Description: 测试查询分页方法
     * @author: fengxin
     * @date: 2015年5月4日 下午3:22:13
     * @return void    
     * @throws
	 */
	public void utestQueryBudgetByParamer(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", 1);
		CommonResultEntity<PageBean> crs = budgetInfoFacade.queryBudgetByParamer(map, new PageParam(1, 3));
		assertNotNull("未查询到结果", crs.getBusinessObj());
	}

}
