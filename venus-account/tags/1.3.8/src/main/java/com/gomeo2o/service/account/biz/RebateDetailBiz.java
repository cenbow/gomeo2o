/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: gongjiaming
 * @date: 2015年4月16日 下午4:53:06
 */
package com.gomeo2o.service.account.biz;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.RebateDetail;
import com.gomeo2o.service.account.dao.RebateDetailDao;

/**
 * @Description:账户管理Biz
 * @author:gongjiaming
 * @date: 2015年4月16日
 */
@Service("rebateDetailBiz")
public class RebateDetailBiz {
	@Autowired
	private RebateDetailDao rebateDetailDao;
	/**
	 * @Description: 账户返利明细列表查询
	 * @author: gongjiaming
	 * @date: 2015年4月16日
	 * @param pageParam
	 * @param accountRebateDetail
	 * @return PageBean
	 */
	public PageBean qryAccountRebateDetail(PageParam pageParam,Map<String,Object> map){
		return rebateDetailDao.qryRebateDetailList(pageParam,map);
	}
	/**
	 * @Description: 增加账户返利明细
	 * @author: gongjiaming
	 * @date: 2015年4月16日
	 * @param accountRebateDetail
	 * @return long
	 */
	@Transactional
	public long addAccountRebateDetail(RebateDetail accountRebateDetail){
		return rebateDetailDao.insert(accountRebateDetail);
	}
	/**
	 * @Description: 修改账户返利明细状态
	 * @author: gongjiaming
	 * @date: 2015年4月16日
	 * @param map
	 * @return void
	 */
	@Transactional
	public void updateRebateDetailState(Map<String,Object> map){
		rebateDetailDao.updateRebateDetailState(map);
	}
	/**
	 * 
	 * @Description: 增加返利流水
     * @author: fengxin
     * @date: 2015年5月5日 下午8:28:15
     * @param reqParam
     * @return void
	 */
	@Transactional
	public void addRebateDetail(Map<String,Object> reqParam){
		rebateDetailDao.addRebateDetail(reqParam);
	}
	/**
	 * 
	 * @Description: 根据id查询数据
     * @author: fengxin
     * @date: 2015年5月8日 下午5:25:06
     * @param id
     * @return RebateDetail    
	 */
	public RebateDetail queryRebateDetailById(long id){
		return rebateDetailDao.getById(id);
	}
}
