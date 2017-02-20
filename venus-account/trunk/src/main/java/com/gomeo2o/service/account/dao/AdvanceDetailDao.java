/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月29日 下午8:59:01
 */
package com.gomeo2o.service.account.dao;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.AdvanceDetail;

/**
 * @Description: 提现明细dao
 * @author: fengxin
 * @date: 2015年4月29日 下午8:59:01
 */
public interface AdvanceDetailDao extends BaseDao<AdvanceDetail> {
	/**
	 * 
	 * @Description: 修改提现流水状态
     * @author: fengxin
     * @date: 2015年4月30日 下午3:01:17
     * @param map
     * @return void    
	 */
	public int updateAdvanceDetail(Map<String,Object> map);
	/**
	 * 
	 * @Description: 增加提现流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:02:36
     * @param map
     * @return int    
	 */
	public int addAdvanceDetail(Map<String,Object> map);
	/**
	 * 
	 * @Description: 根据参数查询提现流水
     * @author: fengxin
     * @date: 2015年5月26日 上午11:42:02
     * @param map
     * @return List<AdvanceDetail>    
	 */
	public List<AdvanceDetail> queryAdvanceDetailByParamer(Map<String,Object> map);
	/**
	 * 
	 * @Description: 根据SAP返回的结果 ，修改流水凭证号 
     * @author: fengxin
     * @date: 2015年6月3日 下午4:08:28
     * @param map
     * @return void
	 */
	public void updateAdvanceDetailVoucher(Map<String,Object> map);
	/**
	 * 
	 * @Description: 查询提现对象
     * @author: fengxin
     * @date: 2015年8月13日 下午5:23:49
     * @param map
     * @return AdvanceDetail    
	 */
	public AdvanceDetail selectAdvanceDetailByParamer(Map<String,Object> map);
		
}
