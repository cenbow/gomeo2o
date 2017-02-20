/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午4:29:21
 */
package com.gomeo2o;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.dubbo.common.json.JSON;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.CouponInfo;
import com.gomeo2o.facade.account.service.CouponInfoFacade;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年5月4日 下午4:29:21
 */
public class TestCouponInfo extends BaseTest {
	
	public static CouponInfoFacade couponInfoFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		couponInfoFacade = (CouponInfoFacade) context
				.getBean("couponInfoFacade");
	}
	/**
	 * 
	 * @Description:增加优惠券用户绑定信息
     * @author: fengxin
     * @date: 2015年5月4日 下午4:30:38
     * @return void    
	 */
	public void utestAddCouponUserInfo(){
		for (int i = 0; i < 1; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", 12345678);
			map.put("couponEcpId", 1);
			map.put("couponType", 1);
			map.put("couponValue", 5);
			map.put("sendTime", new Date());
			map.put("endTime", new Date());
			map.put("state", 1);
			map.put("remark", "这是一个测试");
			map.put("resource", 1);
			CommonResultEntity<String> crs = couponInfoFacade.addCouponUserInfo(map);
			assertTrue("保存失败", crs.getCode()==0);
		}
	}
	/**
	 * 
	 * @Description: 修改优惠券状态
     * @author: fengxin
     * @date: 2015年5月4日 下午4:55:19
     * @return void    
	 */
	public void testUpdateCouponInfoState(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("couponEcpId", 1);
		map.put("state", 2);
		CommonResultEntity<String> crs = couponInfoFacade.updateCouponInfoState(map);
		assertTrue("修改失败", crs.getCode()==0);
	}

}
