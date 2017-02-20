/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: gongjiaming
 * @date: 2015年4月16日 下午5:02:14
 */
package com.gomeo2o.service.account.dao;

import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.RebateDetail;

/**
 * @Description:账户返利明细dao
 * @author:gongjiaming
 * @date: 2015年4月16日
 */
public interface RebateDetailDao extends BaseDao<RebateDetail> {

	/**
	 * @Description: 账户返利明细列表查询
	 * @author: gongjiaming
	 * @date: 2015年4月16日
	 * @param pageParam
	 * @param map
	 * @return PageBean
	 */
	public PageBean qryRebateDetailList(PageParam pageParam,Map<String,Object> map);
	/**
	 * @Description 根据参数查询对象
	 * @author fengxin
	 * @date 2015年12月3日 上午10:15:06
	 * @param map
	 * @return RebateDetail
	 */
	public RebateDetail queryRebateDetailByParamer(Map<String,Object> map);
	/**
	 * 
	 * @Description: 修改返利明细状态
     * @author: fengxin
     * @date: 2015年5月4日 下午5:06:04
     * @param map
     * @return void    
	 */
	public void updateRebateDetailState(Map<String,Object> map);
	/**
	 * 
	 * @Description: 增加返利流水
     * @author: fengxin
     * @date: 2015年5月5日 下午8:28:15
     * @param reqParam
     * @return void
	 */
	public int addRebateDetail(Map<String,Object> reqParam);
}
