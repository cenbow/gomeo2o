/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午2:58:42
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AdvanceDetail;
import com.gomeo2o.facade.account.service.AdvanceDetailFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.AdvanceDetailBiz;
import com.gomeo2o.service.account.biz.VirtualTotalInfoBiz;
import com.gomeo2o.utils.Constants;

/**
 * @Description: 提现流水
 * @author: fengxin
 * @date: 2015年4月30日 下午2:58:42
 */
@Service("advanceDetailFacade")
public class AdvanceDetailServiceImpl implements AdvanceDetailFacade {
	
	@Autowired
	private AdvanceDetailBiz advanceDetailBiz;
	
	@Autowired
	private VirtualTotalInfoBiz virtualTotalInfoBiz;
	/**
	 * 
	 * @Description: 提现操作后  修改提现流水状态
     * @author: fengxin
     * @date: 2015年4月30日 下午3:01:17
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateAdvanceDetail(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(map);
		this.advanceDetailBiz.updateAdvanceDetail(map);
		return crs;
	}
	/**
	 * 
	 * @Description: 增加提现流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:02:36
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addAdvanceDetail(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateMapService.validate(map);
		map.put("limitType", 1);
		virtualTotalInfoBiz.checkUserVirtualLimit(map);
		map.put("detailNo", Constants.getAdvanceDetailNo());
		this.advanceDetailBiz.addAdvanceDetail(map);
		return crs;
	}
	/**
	 * 
	 * @Description: 查询提现流水 分页 条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:43:20
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryAdvanceDetailByParamer(Map<String,Object> reqParam,PageParam pageParam){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(this.advanceDetailBiz.queryAdvanceDetailByParamer(reqParam, pageParam));
		return crs;
	}
	/**
	 * 
	 * @Description: 根据ID查询提现流水
     * @author: fengxin
     * @date: 2015年5月9日 下午3:22:11
     * @param id
     * @return CommonResultEntity<AdvanceDetail>    
	 */
	public CommonResultEntity<AdvanceDetail> queryAdvanceDetailById(long id){
		CommonResultEntity<AdvanceDetail> crs = new CommonResultEntity<AdvanceDetail>();
		crs.setBusinessObj(this.advanceDetailBiz.queryAdvanceDetailById(id));
		return crs;
	}
	/**
	 * 
	 * @Description: 发送提现流水数据到SAP
     * @author: fengxin
     * @date: 2015年5月26日 上午11:38:55
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> sendSOAPWithAdvanceDetail(){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		this.advanceDetailBiz.sendSOAPWithAdvanceDetail(null);
		return crs;
	}
	/**
	 * 
	 * @Description: 根据SAP返回的结果 ，修改流水凭证号 
     * @author: fengxin
     * @date: 2015年6月3日 下午4:08:28
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateAdvanceDetailVoucher(Map<String,Object> reqParam){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		reqParam.put("payoffTime", new Date());
		this.advanceDetailBiz.updateAdvanceDetailVoucher(reqParam);
		return crs;
	}
	

}
