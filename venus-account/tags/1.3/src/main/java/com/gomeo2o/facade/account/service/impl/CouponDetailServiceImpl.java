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
import com.gomeo2o.facade.account.service.CouponDetailFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.CouponDetailBiz;
import com.gomeo2o.utils.Constants;

/**
 * @Description: 优惠券明细
 * @author: fengxin
 * @date: 2015年4月30日 下午1:32:54
 */
@Service("couponDetailFacade")
public class CouponDetailServiceImpl implements CouponDetailFacade{
	
	@Autowired
	private CouponDetailBiz couponDetailBiz;

	/**
	 * 
	 * @Description: 修改优惠券明细状态
     * @author: fengxin
     * @date: 2015年4月30日 下午1:36:58
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCouponDetailState(Map<String, Object> reqParam) {
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		this.couponDetailBiz.updateCouponDetailState(reqParam);
		return crs;
	}
	/**
	 * 
	 * @Description: 增加优惠券明细
     * @author: fengxin
     * @date: 2015年4月30日 下午2:18:25
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addCouponDetail(Map<String,Object> reqParam){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		reqParam.put("detailNo", Constants.getCouponDetailNo());
		this.couponDetailBiz.addCouponDetail(reqParam);
		return crs;
	}
	
	/**
	 * 
	 * @Description: 优惠券明细（带条件分页）
     * @author: fengxin
     * @date: 2015年4月30日 下午4:12:38
     * @param reqParam
     * @return CommonResultEntity<List<CouponDetail>>    
	 */
	public CommonResultEntity<PageBean> queryCouponDetailByParamer (Map<String,Object> reqParam,PageParam pageParam){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(couponDetailBiz.queryCouponDetailByParamer(reqParam, pageParam));
		return crs;
	}

}
