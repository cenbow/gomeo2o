/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:11:31
 */
package com.gomeo2o.service.account.dao;

import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.CouponDetail;

/**
 * @Description: 优惠券明细dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:11:31
 */
public interface CouponDetailDao extends BaseDao<CouponDetail> {
	/**
	 * 
	 * @Description: 增加优惠券流水
     * @author: fengxin
     * @date: 2015年5月4日 下午3:43:56
     * @param reqParam
     * @return void    
	 */
	public void addCouponDetail(Map<String,Object> reqParam);
	/**
	 * 
	 * @Description: 修改又优惠券状态
     * @author: fengxin
     * @date: 2015年4月30日 下午1:42:34
     * @param reqParam
     * @return void    
	 */
	public void updateCouponDetailState(Map<String,Object> reqParam);
	
}
