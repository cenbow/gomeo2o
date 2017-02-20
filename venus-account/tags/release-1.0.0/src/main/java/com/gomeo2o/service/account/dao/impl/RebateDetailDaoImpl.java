/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: gongjiaming
 * @date: 2015年4月16日 下午5:05:34
 */
package com.gomeo2o.service.account.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.RebateDetail;
import com.gomeo2o.service.account.dao.RebateDetailDao;

/**
 * @Description:账户返利明细dao实现
 * @author:gongjiaming
 * @date: 2015年4月16日
 */
@Repository("rebateDetailDao")
public class RebateDetailDaoImpl extends BaseDaoImpl<RebateDetail> implements RebateDetailDao {

	/**
	 * @Description: 账户返利明细列表查询
	 * @author: gongjiaming
	 * @date: 2015年4月16日 下午5:14:08
	 * @param pageParam
	 * @param accountRebateDetail
	 * @return PageBean
	 */
	@Override
	public PageBean qryRebateDetailList(PageParam pageParam,Map<String,Object> map) {
		return this.listPage(pageParam, map);
	}
	/**
	 * @Description 根据参数查询对象
	 * @author fengxin
	 * @date 2015年12月3日 上午10:15:06
	 * @param map
	 * @return RebateDetail
	 */
	public RebateDetail queryRebateDetailByParamer(Map<String,Object> map){
		return this.getSessionTemplate().selectOne("com.gomeo2o.service.account.dao.impl.RebateDetailDaoImpl.selectRebateOne", map);
	}
	/**
	 * 
	 * @Description: 修改返利明细状态
     * @author: fengxin
     * @date: 2015年5月4日 下午5:06:04
     * @param map
     * @return void    
	 */
	public void updateRebateDetailState(Map<String,Object> map){
		this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.RebateDetailDaoImpl.updateRebateDetailState",map);
	}
	/**
	 * 
	 * @Description: 增加返利流水
     * @author: fengxin
     * @date: 2015年5月5日 下午8:28:15
     * @param reqParam
     * @return void
	 */
	public int addRebateDetail(Map<String,Object> reqParam){
		return this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.RebateDetailDaoImpl.addRebateDetail", reqParam);
	}

}
