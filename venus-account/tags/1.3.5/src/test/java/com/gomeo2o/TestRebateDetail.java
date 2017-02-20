/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午5:03:35
 */
package com.gomeo2o;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.service.RebateDetailFacade;
import com.gomeo2o.utils.Constants;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午5:03:35
 */
public class TestRebateDetail extends BaseTest {
	
	public static RebateDetailFacade rebateDetailFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		rebateDetailFacade = (RebateDetailFacade) context
				.getBean("rebateDetailFacade");
	}
	/**
	 * 
	 * @Description: 修改返利明细状态
     * @author: fengxin
     * @date: 2015年5月4日 下午5:09:14
     * @return void    
	 */
	public void utestUpdateRebateDetailState(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 1);
		map.put("version", 0);
		map.put("detailNo", 1);
		map.put("state", 2);
		CommonResultEntity<String> crs = rebateDetailFacade.updateRebateDetailState(map);
		assertTrue("修改失败", crs.getCode()==0);
	}
	/**
	 * 
	 * @Description: 返利分页查询 以及带条件
     * @author: fengxin
     * @date: 2015年5月4日 下午5:18:24
     * @return void    
	 */
	public void utestQueryRebateDetailByParamer(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", 1);
		CommonResultEntity<PageBean> crs = rebateDetailFacade.queryRebateDetailByParamer(map, new PageParam(1, 1));
		assertNotNull("查询结果为空", crs.getBusinessObj());
	}
	/**
	 * 
	 * @Description: 增加返利流水
     * @author: fengxin
     * @date: 2015年5月15日 下午2:47:27
     * @return void    
     * @throws
	 */
	public void testAddRebateDetail(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 2; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", 12345678);
			map.put("orderNo", Constants.getMoneyDetailNo());
			map.put("dealTime", new Date());
			map.put("expectTime", new Date());
			map.put("recordTime", new Date());
			map.put("merchantRebate", 20);
			map.put("platformRebate", 0);
			map.put("recordValue", 20);
			map.put("recordRule", 1);
			map.put("dealRemark", "这是一个测试");
			map.put("dealType", 1);
			map.put("state", 1);
			map.put("creator", "冯鑫");
			map.put("productId", 1);
			map.put("shopId", 123123);
			map.put("rebateState", 1);
			list.add(map);
		}
		CommonResultEntity<String> str = rebateDetailFacade.addRebateDetail(list);
		assertTrue("保存失败",str.getCode()==0);
	}

}
