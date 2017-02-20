/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午1:32:54
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.service.CouponInfoFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.CouponInfoBiz;

/**
 * @Description: 优惠券明细
 * @author: fengxin
 * @date: 2015年4月30日 下午1:32:54
 */
@Service("couponInfoFacade")
public class CouponInfoServiceImpl implements CouponInfoFacade{
	
	@Autowired
	private CouponInfoBiz couponInfoBiz;

	/**
	 * 
	 * @Description: 修改优惠券状态
     * @author: fengxin
     * @date: 2015年4月30日 下午1:36:58
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCouponInfoState(Map<String, Object> reqParam) {
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		this.couponInfoBiz.updateCouponInfoState(reqParam);
		return crs;
	}
	/**
	 * 
	 * @Description: 增加优惠券用户绑定信息
     * @author: fengxin
     * @date: 2015年4月30日 下午2:00:22
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addCouponUserInfo(Map<String,Object> reqParam){
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		this.couponInfoBiz.addCouponInfo(reqParam);
		return rcs;
	}
	/**
	 * 
	 * @Description: 查询红包列表
     * @author: fengxin
     * @date: 2015年5月8日 下午8:15:23
     * @param pageParam
     * @param paramMap
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryCouponInfoByParamer(PageParam pageParam,Map<String,Object> paramMap){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(this.couponInfoBiz.queryCouponInfoByParamer(pageParam, paramMap));
		return crs;
	}
	/**
	 * 
	 * @Description: 定时任务 用来修改已经过期的红包
     * @author: fengxin
     * @date: 2015年7月17日 下午4:23:32
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCouponInfoStateByTime(){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		this.couponInfoBiz.updateCouponInfoStateByTime();
		return crs;
	}

}
