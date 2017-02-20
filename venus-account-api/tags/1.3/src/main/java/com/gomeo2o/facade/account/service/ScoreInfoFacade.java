package com.gomeo2o.facade.account.service;

import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.ScoreInfo;

/**
 * 
 * @Description: 积分信心facade 
 * @author: fengxin
 * @date: 2015年3月20日 下午4:40:09
 */
public interface ScoreInfoFacade {
	/**
	 * 
	 * @Description: 积分数据汇总信息查询
     * @author: fengxin
     * @date: 2015年3月25日 下午4:11:15
     * @param scoreInfo
     * @param scoreDetail
     * @return CommonResultEntity<Map<String,Integer>>
	 */
	public CommonResultEntity<Map<String,Integer>> queryScoreInfoTotal(ScoreInfo scoreInfo);
	/**
	 * 
	 * @Description: 根据积分明细 修改积分信息
     * @author: fengxin
     * @date: 2015年3月26日 上午11:57:14
     * @return void    
	 */
	public CommonResultEntity<String> updateRecordScoreInfo();
}
