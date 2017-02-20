/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:12:41
 */
package com.gomeo2o.service.account.dao;

import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.CouponInfo;

/**
 * @Description: 优惠券Dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:12:41
 */
public interface CouponInfoDao extends BaseDao<CouponInfo> {
	/**
	 * 
	 * @Description: 根据参数查询用户持有的平台券和商铺券的数量
     * @author: fengxin
     * @date: 2015年4月30日 上午11:12:19
     * @param couponInfo
     * @return Map<String,Object>    
	 */
	public Map<String,Object> queryCouponTotalByParamer(CouponInfo couponInfo);
	/**
	 * 
	 * @Description: 增加优惠券用户绑定信息
     * @author: fengxin
     * @date: 2015年5月4日 下午4:32:01
     * @param reqMap
     * @return void    
	 */
	public void addCouponInfo (Map<String,Object> reqMap);
	/**
	 * 
	 * @Description: 修改优惠券状态
     * @author: fengxin
     * @date: 2015年5月4日 下午4:50:56
     * @param reqMap
     * @return void    
	 */
	public void updateCouponInfoState(Map<String,Object> reqMap);
	/**
	 * 
	 * @Description: 定时任务 用来修改过期红包状态
     * @author: fengxin
     * @date: 2015年7月17日 下午4:18:37
     * @return void    
	 */
	public void updateCouponInfoStateByTime();

}
