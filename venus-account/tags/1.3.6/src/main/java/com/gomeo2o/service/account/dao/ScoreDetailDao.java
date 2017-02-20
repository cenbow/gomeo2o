/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月17日 上午10:30:27
 */
package com.gomeo2o.service.account.dao;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreDetail;

/**
 * @Description: 账户积分明细Dao
 * @author: fengxin
 * @date: 2015年4月17日 上午10:30:27
 */
public interface ScoreDetailDao extends BaseDao<ScoreDetail> {
	/**
	 * 
	 * @Description: 积分获取明细列表
     * @author: fengxin
     * @date: 2015年3月25日 下午6:11:46
     * @param scoreDetail
     * @param pageParam
     * @return PageBean    
	 */
	public PageBean queryScoreDetalList(PageParam pageParam,ScoreDetail scoreDetail);
	/**
	 * 
	 * @Description: 查询符合入账规则的积分明细信息
     * @author: fengxin
     * @date: 2015年3月26日 上午11:50:21
     * @param map
     * @return List<ScoreDetail>    
	 */
	public List<ScoreDetail> queryUpdateScoreDetail(Map<String,Object> map);
	/**
	 * 
	 * @Description: 查询符合入账规则的积分明细信息总条数
     * @author: fengxin
     * @date: 2015年4月1日 上午10:13:23
     * @return Long    
	 */
	public long queryUpdateScoreDetailCount();
	/**
	 * 
	 * @Description: 增加积分明细
     * @author: fengxin
     * @date: 2015年5月14日 下午1:42:58
     * @param map
     * @return void    
	 */
	public void addScoreDetail(Map<String,Object> map);
	/**
	 * @Description 获取不同状态积分总值
	 * @author fengxin
	 * @date 2015年12月1日 下午6:37:38
	 * @param map
	 * @return
	 */
	public Long queryScoreTotal(Map<String,Object> map);

}
