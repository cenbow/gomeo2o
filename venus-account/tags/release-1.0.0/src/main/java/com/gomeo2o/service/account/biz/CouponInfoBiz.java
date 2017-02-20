/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 上午11:07:36
 */
package com.gomeo2o.service.account.biz;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.CouponInfo;
import com.gomeo2o.service.account.dao.CouponInfoDao;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 上午11:07:36
 */
@Service("couponInfoBiz")
public class CouponInfoBiz {
	
	@Autowired
	private CouponInfoDao couponInfoDao;
	/**
	 * 
	 * @Description: 根据条件查询用户各种状态优惠券总数
     * @author: fengxin
     * @date: 2015年4月30日 上午11:11:16
     * @param map
     * @return Map<String,Integer>    
	 */
	public Map<String,Object> queryCouponTotalByParamer(CouponInfo couponInfo){
		return this.couponInfoDao.queryCouponTotalByParamer(couponInfo);
	}
	/**
	 * 
	 * @Description: 修改优惠券状态
     * @author: fengxin
     * @date: 2015年4月30日 下午1:56:19
     * @param reqParam
     * @return void    
	 */
	@Transactional
	public void updateCouponInfoState(Map<String,Object> reqParam){
		this.couponInfoDao.updateCouponInfoState(reqParam);
	}
	/**
	 * 
	 * @Description: 增加优惠券用户绑定信息
     * @author: fengxin
     * @date: 2015年4月30日 下午2:02:33
     * @return void    
	 */
	@Transactional
	public void addCouponInfo (Map<String,Object> reqMap){
		this.couponInfoDao.addCouponInfo(reqMap);
	}
	/**
	 * 
	 * @Description: 查询红包列表
     * @author: fengxin
     * @date: 2015年5月8日 下午8:15:23
     * @param pageParam
     * @param paramMap
     * @return PageBean    
	 */
	public PageBean queryCouponInfoByParamer(PageParam pageParam,Map<String,Object> paramMap){
		return this.couponInfoDao.listPage(pageParam, paramMap);
	}
	
	/**
	 * 
	 * @Description: 定时任务 用来修改过期红包状态
     * @author: fengxin
     * @date: 2015年7月17日 下午4:18:37
     * @return void    
	 */
	public void updateCouponInfoStateByTime(){
		this.couponInfoDao.updateCouponInfoStateByTime();
	}

}
