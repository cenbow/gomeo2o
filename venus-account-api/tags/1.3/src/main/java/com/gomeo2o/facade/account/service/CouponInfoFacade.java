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
 * @Description: 优惠券
 * @author: fengxin
 * @date: 2015年4月30日 下午1:33:28
 */
public interface CouponInfoFacade {
	/**
	 * 
	 * @Description: 修改优惠券状态
     * @author: fengxin
     * @date: 2015年4月30日 下午1:36:58
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCouponInfoState(Map<String,Object> reqParam);
	/**
	 * 
	 * @Description: 增加优惠券用户绑定信息
     * @author: fengxin
     * @date: 2015年4月30日 下午2:00:22
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addCouponUserInfo(Map<String,Object> reqParam);
	/**
	 * 
	 * @Description: 查询红包列表
     * @author: fengxin
     * @date: 2015年5月8日 下午8:15:23
     * @param pageParam
     * @param paramMap
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryCouponInfoByParamer(PageParam pageParam,Map<String,Object> paramMap);
	/**
	 * 
	 * @Description: 定时任务 用来修改已经过期的红包
     * @author: fengxin
     * @date: 2015年7月17日 下午4:23:32
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateCouponInfoStateByTime();
	/**
	 * 
	 * @Description:取消订单，修改红包状态
     * @author: fengxin
     * @date: 2016年1月21日 下午4:23:32
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> resetCouponInfoState(Map<Long,String> map);
}
