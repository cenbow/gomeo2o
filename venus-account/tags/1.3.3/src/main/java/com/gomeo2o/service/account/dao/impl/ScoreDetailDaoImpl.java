/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月17日 上午10:20:56
 */
package com.gomeo2o.service.account.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreDetail;
import com.gomeo2o.service.account.dao.ScoreDetailDao;

/**
 * @Description: 账户积分明细Dao实现
 * @author: fengxin
 * @date: 2015年4月17日 上午10:20:56
 */
@Repository("scoreDetailDao")
public class ScoreDetailDaoImpl extends BaseDaoImpl<ScoreDetail> implements ScoreDetailDao {
	/**
	 * 
	 * @Description:积分获取明细列表
     * @author: fengxin
     * @date: 2015年3月25日 下午6:39:01
     * @param pageParam
     * @param scoreDetail
     * @return PageBean    
	 */
	public PageBean queryScoreDetalList(PageParam pageParam,ScoreDetail scoreDetail){
		Map<String,Object> map = new HashMap<String,Object>();
		if(null!=scoreDetail){
			if(scoreDetail.getUserId()!=null&&!"".equals(scoreDetail.getUserId())){
				map.put("userId", scoreDetail.getUserId());
			}
			if(scoreDetail.getSiStartDealTime()!=null&&!"".equals(scoreDetail.getSiStartDealTime())){
				map.put("siStartDealTime", scoreDetail.getSiStartDealTime());
			}
			if(scoreDetail.getSiEndDealTime()!=null&&!"".equals(scoreDetail.getSiEndDealTime())){
				map.put("siEndDealTime", scoreDetail.getSiEndDealTime());
			}
			if(scoreDetail.getDealType()!=null&&!"".equals(scoreDetail.getDealType())){
				map.put("dealType", scoreDetail.getDealType());
			}
		}
		return this.listPage(pageParam, map);
	}
	/**
	 * 
	 * @Description: 查询符合入账规则的积分明细信息
     * @author: fengxin
     * @param map
     * @date: 2015年3月26日 上午11:50:21
     * @return List<ScoreDetail>    
	 */
	public List<ScoreDetail> queryUpdateScoreDetail(Map<String,Object> map){
		return this.getSessionTemplate().selectList("com.gomeo2o.service.account.dao.impl.ScoreDetailDaoImpl.selectUpdateScpreDetail", map);
	}
	/**
	 * 
	 * @Description: 查询符合入账规则的积分明细信息总条数
     * @author: fengxin
     * @date: 2015年4月1日 上午10:13:23
     * @return Long    
	 */
	public long queryUpdateScoreDetailCount(){
		return this.getSessionTemplate().selectOne("com.gomeo2o.service.account.dao.impl.ScoreDetailDaoImpl.selectUpdateScpreDetailCount");
	}
	/**
	 * 
	 * @Description: 增加积分明细
     * @author: fengxin
     * @date: 2015年5月14日 下午1:42:58
     * @param map
     * @return void    
	 */
	public void addScoreDetail(Map<String,Object> map){
		this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.ScoreDetailDaoImpl.addScoreDetail", map);
	}
	/**
	 * @Description 获取不同状态积分总值
	 * @author fengxin
	 * @date 2015年12月1日 下午6:37:38
	 * @param map
	 * @return
	 */
	public Long queryScoreTotal(Map<String,Object> map){
		return this.getSessionTemplate().selectOne("com.gomeo2o.service.account.dao.impl.ScoreDetailDaoImpl.queryScoreTotal", map);
	}

	

}
