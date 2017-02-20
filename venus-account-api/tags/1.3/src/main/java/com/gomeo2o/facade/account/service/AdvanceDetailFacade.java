/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午2:57:00
 */
package com.gomeo2o.facade.account.service;

import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AdvanceDetail;

/**
 * @Description: 体现流水
 * @author: fengxin
 * @date: 2015年4月30日 下午2:57:00
 */
public interface AdvanceDetailFacade {
	/**
	 * 
	 * @Description: 修改提现流水状态
     * @author: fengxin
     * @date: 2015年4月30日 下午3:01:17
     * @param map
     * @return void    
     * @throws
	 */
	public CommonResultEntity<String> updateAdvanceDetail(Map<String,Object> map);
	/**
	 * 
	 * @Description: 增加提现流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:02:36
     * @param map
     * @return void    
     * @throws
	 */
	public CommonResultEntity<String> addAdvanceDetail(Map<String,Object> map);
	/**
	 * 
	 * @Description: 查询提现流水 分页 条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:43:20
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryAdvanceDetailByParamer(Map<String,Object> reqParam,PageParam pageParam);
	/**
	 * 
	 * @Description: 根据ID查询提现流水
     * @author: fengxin
     * @date: 2015年5月9日 下午3:22:11
     * @param id
     * @return CommonResultEntity<AdvanceDetail>    
	 */
	public CommonResultEntity<AdvanceDetail> queryAdvanceDetailById(long id);
	/**
	 * 
	 * @Description: 发送提现流水数据到SAP
     * @author: fengxin
     * @date: 2015年5月26日 上午11:38:55
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> sendSOAPWithAdvanceDetail();
	/**
	 * 
	 * @Description: 根据SAP返回的结果 ，修改流水凭证号 
     * @author: fengxin
     * @date: 2015年6月3日 下午4:08:28
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateAdvanceDetailVoucher(Map<String,Object> reqParam);
}
