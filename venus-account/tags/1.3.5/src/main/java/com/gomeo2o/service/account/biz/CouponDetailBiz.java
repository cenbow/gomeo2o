/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午1:34:54
 */
package com.gomeo2o.service.account.biz;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.CouponDetail;
import com.gomeo2o.service.account.dao.CouponDetailDao;

/**
 * @Description: 优惠券明细
 * @author: fengxin
 * @date: 2015年4月30日 下午1:34:54
 */
@Service("couponDetailBiz")
public class CouponDetailBiz {
	
	@Autowired
	private CouponDetailDao couponDetailDao;
	/**
	 * 
	 * @Description: 修改又优惠券状态
     * @author: fengxin
     * @date: 2015年4月30日 下午1:42:34
     * @param couponDetail
     * @return void    
	 */
	@Transactional
	public void updateCouponDetailState(Map<String,Object> reqParam){
		this.couponDetailDao.updateCouponDetailState(reqParam);
	}
	/**
	 * 
	 * @Description: 增加优惠券明细
     * @author: fengxin
     * @date: 2015年4月30日 下午2:10:54
     * @param reqParam
     * @return void    
	 */
	@Transactional
	public void addCouponDetail(Map<String,Object> reqParam){
		this.couponDetailDao.addCouponDetail(reqParam);
	}
	/**
	 * 
	 * @Description: 增加优惠券明细
     * @author: fengxin
     * @date: 2015年9月17日 下午5:03:41
     * @param couponDetail
	 */
	@Transactional
	public void addCouponDetail(CouponDetail couponDetail){
		this.couponDetailDao.insert(couponDetail);
	}
	/**
	 * 
	 * @Description: 优惠券明细（带条件）分页
     * @author: fengxin
     * @date: 2015年4月30日 下午4:18:04
     * @param reqParam
     * @param pageParam
     * @return List<CouponDetail>    
	 */
	public PageBean queryCouponDetailByParamer(Map<String,Object> reqParam,PageParam pageParam){
		return  couponDetailDao.listPage(pageParam, reqParam);
	}
}
