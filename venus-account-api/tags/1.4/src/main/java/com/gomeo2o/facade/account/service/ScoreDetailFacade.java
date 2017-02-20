/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午2:25:36
 */
package com.gomeo2o.facade.account.service;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreDetail;

/**
 * @Description: 积分明细
 * @author: fengxin
 * @date: 2015年4月30日 下午2:25:36
 */
public interface ScoreDetailFacade {
	
	/**
	 * 
	 * @Description: 修改积分明细状态
     * @author: fengxin
     * @date: 2015年4月30日 下午2:31:18
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateScoreDetail(Map<String,Object> reqParam);
	/**
	 * 
	 * @Description: 增加积分明细流水
     * @author: fengxin
     * @date: 2015年4月30日 下午2:40:22
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addScoreDetail(Map<String,Object> reqParam);
	
	/**
	 * 
	 * @Description: 积分明细查询带分页 带条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:36:19
     * @param reqParam
     * @param pageParam
     * @return CommonResultEntity<List<ScoreDetail>>    
	 */
	public CommonResultEntity<List<ScoreDetail>> queryScoreDetailByParamer(Map<String,Object> reqParam,PageParam pageParam);
	/**
	 * 
	 * @Description: 积分获取明细列表
     * @author: fengxin
     * @date: 2015年3月25日 下午6:11:46
     * @param pageParam
     * @param scoreDetail
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryScoreDetalList(PageParam pageParam,ScoreDetail scoreDetail);
	/**
	 * 
	 * @Description: 根据积分埋点创建积分流水
     * @author: fengxin
     * @date: 2015年5月29日 下午2:18:39
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> createScoreDetailByPoint(Map<String,Object> reqParam);
	/**
	 * @Description 获取不同状态积分总值
	 * @author fengxin
	 * @date 2015年12月1日 下午6:37:38
	 * @param map
	 * @return CommonResultEntity<Long>
	 */
	public CommonResultEntity<Long> queryScoreTotal(Map<String,Object> map);

}
