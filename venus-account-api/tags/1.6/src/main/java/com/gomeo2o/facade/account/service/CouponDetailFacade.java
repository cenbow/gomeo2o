/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午1:33:28
 */
package com.gomeo2o.facade.account.service;

import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;

/**
 * @Description: 优惠券明细
 * @author: fengxin
 * @date: 2015年4月30日 下午1:33:28
 */
public interface CouponDetailFacade {
	/**
	 * 
	 * @Description: 修改优惠券明细状态
     * @author: fengxin
     * @date: 2015年4月30日 下午1:36:58
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCouponDetailState(Map<String,Object> reqParam);
	/**
	 * 
	 * @Description: 增加优惠券明细
     * @author: fengxin
     * @date: 2015年4月30日 下午2:18:25
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addCouponDetail(Map<String,Object> reqParam);
	/**
	 * 
	 * @Description: 优惠券明细（带条件分页）
     * @author: fengxin
     * @date: 2015年4月30日 下午4:12:38
     * @param reqParam
     * @return CommonResultEntity<PageBean> 
	 */
	public CommonResultEntity<PageBean> queryCouponDetailByParamer (Map<String,Object> reqParam,PageParam pageParam);
}
