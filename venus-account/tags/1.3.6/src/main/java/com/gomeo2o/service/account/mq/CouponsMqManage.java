/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年6月23日 下午5:33:24
 */
package com.gomeo2o.service.account.mq;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gomeo2o.facade.account.entity.CouponDetail;
import com.gomeo2o.facade.account.entity.CouponInfo;
import com.gomeo2o.service.account.biz.CouponDetailBiz;
import com.gomeo2o.service.account.biz.CouponInfoBiz;
import com.gomeo2o.utils.Constants;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年6月23日 下午5:33:24
 */
@Slf4j
@Component
public class CouponsMqManage {
	
	@Autowired
	private CouponDetailBiz couponDetailBiz;
	
	@Autowired
	private CouponInfoBiz couponInfoBiz;
	
	/**
	 * 
	 * @Description:领取红包业务操作
     * @author: fengxin
     * @date: 2015年6月23日 下午6:23:18
     * @param couponInfo
     * @return void    
	 */
	public void collectCoupons(CouponInfo couponInfo){
		log.info("MQ receive receive Coupons，begin operation {}", couponInfo);
		if(couponInfo!=null&&!"".equals(couponInfo)){
			try {
				Map<String, Object> map = new HashMap<String,Object>();
				map.put("userId", couponInfo.getUserId());
				map.put("couponType", couponInfo.getCouponType());
				map.put("couponEcpId", couponInfo.getCouponEcpId());
				map.put("couponValue", couponInfo.getCouponValue());
				map.put("sendTime", couponInfo.getSendTime());
				map.put("endTime", couponInfo.getEndTime());
				map.put("state", couponInfo.getState());
				map.put("remark", couponInfo.getRemark());
				map.put("resource", couponInfo.getResource());
				map.put("shopId", couponInfo.getShopId());
				map.put("baseMoney", couponInfo.getBaseMoney());
				log.debug("MQ receive receive Coupons，operation paramer {}",map.toString());
				couponInfoBiz.addCouponInfo(map);
			} catch (Exception e) {
				log.error("MQ receive receive Coupons，operation error {}", e);
			}
		}else{
			log.error("MQ receive receive Coupons，Coupons is null {}",couponInfo);
		}
	}
	/**
	 * 
	 * @Description: 使用红包业务操作
     * @author: fengxin
     * @date: 2015年6月23日 下午6:23:24
     * @param couponDetail
     * @return void    
	 */
	public  void useCoupons(CouponDetail couponDetail){
		log.info("MQ receive use Coupons，begin operation{}", couponDetail);
		if(couponDetail!=null&&!"".equals(couponDetail)){
			try {
				/*Map<String, Object> map = new HashMap<String,Object>();
				map.put("couponEcpId", couponDetail.getCouponEcpId());
				map.put("userId", couponDetail.getUserId());
				map.put("orderNo", couponDetail.getOrderNo());
				map.put("dealTime", couponDetail.getDealTime());
				map.put("recordTime", couponDetail.getRecordTime());
				map.put("state", 1);
				map.put("remark", couponDetail.getRemark());
				map.put("sendTime", couponDetail.getSendTime());
				map.put("couponType", couponDetail.getCouponType());
				map.put("recordValue", couponDetail.getRecordValue());
				map.put("detailNo", Constants.getCouponDetailNo());*/
				couponDetail.setDetailNo(Constants.getCouponDetailNo());
				couponDetailBiz.addCouponDetail(couponDetail);
				Map<String, Object> umap = new HashMap<String,Object>();
				umap.put("detailId", couponDetail.getDetailNo());
				umap.put("couponEcpId", couponDetail.getCouponEcpId());
				umap.put("userId", couponDetail.getUserId());
				umap.put("state", 3);
				log.debug("MQ receive use Coupons，operation paramer{}",umap.toString());
				couponInfoBiz.updateCouponInfoState(umap);
			} catch (Exception e) {
				log.error("MQ receive use Coupons，operation error {}", e);
			}
		}else{
			log.error("MQ receive use Coupons，Coupons is null {}",couponDetail);
		}
	}
	/**
	 * @return the couponDetailBiz
	 */
	public CouponDetailBiz getCouponDetailBiz() {
		return couponDetailBiz;
	}
	/**
	 * @param couponDetailBiz the couponDetailBiz to set
	 */
	public void setCouponDetailBiz(CouponDetailBiz couponDetailBiz) {
		this.couponDetailBiz = couponDetailBiz;
	}
	/**
	 * @return the couponInfoBiz
	 */
	public CouponInfoBiz getCouponInfoBiz() {
		return couponInfoBiz;
	}
	/**
	 * @param couponInfoBiz the couponInfoBiz to set
	 */
	public void setCouponInfoBiz(CouponInfoBiz couponInfoBiz) {
		this.couponInfoBiz = couponInfoBiz;
	}

}
