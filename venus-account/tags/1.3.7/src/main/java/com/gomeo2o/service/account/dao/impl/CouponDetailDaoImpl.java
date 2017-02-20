/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:12:02
 */
package com.gomeo2o.service.account.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.CouponDetail;
import com.gomeo2o.service.account.dao.CouponDetailDao;

/**
 * @Description: 优惠券明细dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:12:02
 */
@Repository("couponDetailDao")
public class CouponDetailDaoImpl extends BaseDaoImpl<CouponDetail> implements CouponDetailDao {
	/**
	 * 
	 * @Description: 增加优惠券流水
     * @author: fengxin
     * @date: 2015年5月4日 下午3:43:56
     * @param reqParam
     * @return void    
	 */
	public void addCouponDetail(Map<String,Object> reqParam){
		this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.CouponDetailDaoImpl.addCouponDetail", reqParam);
	}
	/**
	 * 
	 * @Description: 修改又优惠券状态
     * @author: fengxin
     * @date: 2015年4月30日 下午1:42:34
     * @param reqParam
     * @return void    
	 */
	public void updateCouponDetailState(Map<String,Object> reqParam){
		this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.CouponDetailDaoImpl.updateCouponDetailState", reqParam);
	}
}
