/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 上午11:48:45
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.RebateDetail;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.facade.account.service.RebateDetailFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.RebateDetailBiz;
import com.gomeo2o.utils.Constants;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 上午11:48:45
 */
@Service("rebateDetailFacade")
public class RebateDetailServiceImpl implements RebateDetailFacade {
	
	@Autowired
	private RebateDetailBiz rebateDetailBiz;

	/**
	 * 
	 * @Description: 根据条件 分页查询返利明细
     * @author: fengxin
     * @date: 2015年4月30日 上午11:47:37
     * @param pageParam
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryRebateDetailByParamer(Map<String,Object> reqParam,PageParam pageParam) {
		CommonResultEntity<PageBean> cre = new CommonResultEntity<PageBean>();
		cre.setBusinessObj(rebateDetailBiz.qryAccountRebateDetail(pageParam, reqParam));
		return cre;
	}
	/**
	 * 
	 * @Description: 修改返利状态
     * @author: fengxin
     * @date: 2015年4月30日 下午12:19:17
     * @param reqParm
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateRebateDetailState(Map<String,Object> reqParam){
		CommonResultEntity<String> cre = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		this.rebateDetailBiz.updateRebateDetailState(reqParam);
		return cre;
	}
	/**
	 * 
	 * @Description: 增加返利流水
     * @author: fengxin
     * @date: 2015年5月5日 下午8:28:15
     * @param reqList
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addRebateDetail(List<Map<String,Object>> reqList){
		CommonResultEntity<String> cre = new CommonResultEntity<String>();
		if(reqList.size()>0){
			Map<String,Object> map = null;
			for (int i = 0; i < reqList.size(); i++) {
				map = reqList.get(i);
				map.put("detailNo", Constants.getRebateDetailNo());
				this.rebateDetailBiz.addRebateDetail(map);
			}
		}else{
			throw AccountException.REQLIST_ERROE;
		}
		return cre;
	}
	/**
	 * 
	 * @Description: 根据id查询数据
     * @author: fengxin
     * @date: 2015年5月8日 下午5:25:06
     * @param id
     * @return CommonResultEntity<RebateDetail>    
	 */
	public CommonResultEntity<RebateDetail> queryRebateDetailById(long id){
		CommonResultEntity<RebateDetail> cre = new CommonResultEntity<RebateDetail>();
		cre.setBusinessObj(rebateDetailBiz.queryRebateDetailById(id));
		return cre;
	}

}
