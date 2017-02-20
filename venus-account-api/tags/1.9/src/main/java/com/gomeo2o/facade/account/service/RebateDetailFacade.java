/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 上午11:45:15
 */
package com.gomeo2o.facade.account.service;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.RebateDetail;

/**
 * @Description: 返利明细
 * @author: fengxin
 * @date: 2015年4月30日 上午11:45:15
 */
public interface RebateDetailFacade {
	/**
	 * 
	 * @Description: 根据条件 分页查询返利明细
     * @author: fengxin
     * @date: 2015年4月30日 上午11:47:37
     * @param pageParam
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryRebateDetailByParamer(Map<String,Object> reqParam,PageParam pageParam);
	/**
	 * 
	 * @Description: 修改返利状态
     * @author: fengxin
     * @date: 2015年4月30日 下午12:19:17
     * @return void    
	 */
	public CommonResultEntity<String> updateRebateDetailState(Map<String,Object> reqParam);
	/**
	 * 
	 * @Description: 增加返利流水
     * @author: fengxin
     * @date: 2015年5月5日 下午8:28:15
     * @param reqList
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addRebateDetail(List<Map<String,Object>> reqList);
	
	/**
	 * 
	 * @Description: 根据id查询数据
     * @author: fengxin
     * @date: 2015年5月8日 下午5:25:06
     * @param id
     * @return CommonResultEntity<RebateDetail>    
	 */
	public CommonResultEntity<RebateDetail> queryRebateDetailById(long id);

}
