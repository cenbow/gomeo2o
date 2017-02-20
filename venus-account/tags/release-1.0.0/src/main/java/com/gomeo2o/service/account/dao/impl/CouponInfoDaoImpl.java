/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午9:13:29
 */
package com.gomeo2o.service.account.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.CouponInfo;
import com.gomeo2o.service.account.dao.CouponInfoDao;

/**
 * @Description: 优惠券信息dao
 * @author: fengxin
 * @date: 2015年4月29日 下午9:13:29
 */
@Repository("couponInfoDao")
public class CouponInfoDaoImpl extends BaseDaoImpl<CouponInfo> implements CouponInfoDao {

	/**
	 * 
	 * @Description: 根据参数查询用户持有的平台券和商铺券的数量
     * @author: fengxin
     * @date: 2015年4月30日 上午11:12:19
     * @param map
     * @return Map<String,Integer>    
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> queryCouponTotalByParamer(CouponInfo couponInfo){
		List<Object> list = this.getSessionTemplate().selectList("com.gomeo2o.service.account.dao.impl.CouponInfoDaoImpl.queryCouponTotalByParamer", couponInfo);
		if(list.size()>0){
			return (Map<String, Object>) list.get(0);
		}
		return new HashMap<String, Object>();
	}
	/**
	 * 
	 * @Description: 增加优惠券用户绑定信息
     * @author: fengxin
     * @date: 2015年5月4日 下午4:32:01
     * @param reqMap
     * @return void    
	 */
	public void addCouponInfo (Map<String,Object> reqMap){
		this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.CouponInfoDaoImpl.addCouponInfo", reqMap);
	}
	
	/**
	 * 
	 * @Description: 修改优惠券状态
     * @author: fengxin
     * @date: 2015年5月4日 下午4:50:56
     * @param reqMap
     * @return void    
	 */
	public void updateCouponInfoState(Map<String,Object> reqMap){
		this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.CouponInfoDaoImpl.updateCouponInfoState", reqMap);
	}
	/**
	 * 
	 * @Description: 定时任务 用来修改过期红包状态
     * @author: fengxin
     * @date: 2015年7月17日 下午4:18:37
     * @return void    
	 */
	public void updateCouponInfoStateByTime(){
		this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.CouponInfoDaoImpl.updateCouponInfoStateByTime", null);
	}

}
