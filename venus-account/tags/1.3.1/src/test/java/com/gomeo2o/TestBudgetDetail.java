/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午2:42:17
 */
package com.gomeo2o;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gomeo2o.BaseTest;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.service.BudgetDetailFacade;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午2:42:17
 */
public class TestBudgetDetail extends BaseTest {
	
	public static BudgetDetailFacade budgetDetailFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		budgetDetailFacade = (BudgetDetailFacade) context
				.getBean("budgetDetailFacade");
	}
	/**
	 * 
	 * @Description: 测试增加预算流水
     * @author: fengxin
     * @date: 2015年5月4日 下午2:53:31
     * @return void    
     * @throws
	 */
	public void testAddBudgetDetail(){
		for(int i =0;i<10;i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", 12345678);
			map.put("orderNo", "12123213");
			map.put("cardId", 1);
			map.put("budgetNo", 12);
			map.put("budgetTime", new Date());
			map.put("budgetType", 1);
			map.put("recordValue", 10.1);
			map.put("state", 1);
			CommonResultEntity<String> crs = budgetDetailFacade.addBudgetDetail(map);
			assertTrue("添加成功", crs.getCode()==0);
		}
		
	}
	/**
	 * @throws ParseException 
	 * 
	 * @Description: 分页查询预算流水  带条件
     * @author: fengxin
     * @date: 2015年5月4日 下午3:10:01
     * @return void    
     * @throws
	 */
	public void testQueryBudgetDetailByParamer() throws ParseException{
		Map<String,Object> map = new HashMap<String,Object>();
		/*map.put("userId", 1);
		map.put("budgetNo", 12);*/
		
		map.put("queryStartTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-06-01 23:12:12"));
		map.put("queryEndTime", new Date());
		CommonResultEntity<PageBean> crs  = budgetDetailFacade.queryBudgetDetailByParamer(map, new PageParam(1, 1));
		assertNotNull("未查询到结果", crs.getBusinessObj());
	}

}
