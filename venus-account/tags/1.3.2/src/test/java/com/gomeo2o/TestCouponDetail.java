/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午3:38:51
 */
package com.gomeo2o;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.dubbo.common.json.JSON;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.service.CouponDetailFacade;
import com.gomeo2o.utils.Constants;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午3:38:51
 */
public class TestCouponDetail extends BaseTest {
	
	public static CouponDetailFacade couponDetailFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		couponDetailFacade = (CouponDetailFacade) context
				.getBean("couponDetailFacade");
	}
	/**
	 * 
	 * @Description: 增加优惠券流水
     * @author: fengxin
     * @date: 2015年5月4日 下午3:59:27
     * @return void    
	 */
	public void testAddCouponDetail(){
		//#{couponId},#{userId},#{detailNo},#{orderNo},#{dealTime},#{recordTime},#{state},#{remark},#{creator},0
		for (int i = 1; i < 2; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("couponEcpId", 123123123);
			map.put("userId", 12345678);
			map.put("orderNo", Constants.getMoneyDetailNo());
			map.put("dealTime", new Date());
			map.put("recordTime", new Date());
			map.put("state", 1);
			map.put("remark", "这是测试");
			map.put("creator", "冯鑫");
			map.put("sendTime", new Date());
			map.put("couponType", 1);
			map.put("recordValue", 12.12);
			CommonResultEntity<String> crs = couponDetailFacade.addCouponDetail(map);
			assertTrue("保存失败", crs.getCode()==0);
		}
		
	}
	/**
	 * 
	 * @Description: 修改优惠券流水状态
     * @author: fengxin
     * @date: 2015年5月4日 下午4:10:00
     * @return void    
     * @throws
	 */
	public void utestUpdateCouponDetailState(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("couponId", 1);
		map.put("userId", 1);
		map.put("detailNo", "12");
		map.put("state", 2);
		CommonResultEntity<String> crs = couponDetailFacade.updateCouponDetailState(map);
		assertTrue("修改失败", crs.getCode()==0);
	}
	/**
	 * 
	 * @Description:分页查询优惠券流水状态
     * @author: fengxin
     * @date: 2015年5月4日 下午4:10:18
     * @return void    
     * @throws
	 */
	public void utestQueryCouponDetailByParamer(){
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("userId", 1);
		CommonResultEntity<PageBean> crs = couponDetailFacade.queryCouponDetailByParamer(map, new PageParam(1, 1));
		assertNotNull("查询结果为空", crs.getBusinessObj());
	}
}