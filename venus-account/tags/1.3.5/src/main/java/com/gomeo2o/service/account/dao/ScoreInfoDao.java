package com.gomeo2o.service.account.dao;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.ScoreConfig;
import com.gomeo2o.facade.account.entity.ScoreInfo;
/**
 * 
 * @Description: 积分信息Dao
 * @author: fengxin
 * @date: 2015年3月20日 下午4:56:47
 */
public interface ScoreInfoDao extends BaseDao<ScoreInfo> {
	/**
	 * 
	 * @Description: 积分数据汇总信息查询
     * @author: fengxin
     * @date: 2015年3月25日 下午4:11:15
     * @param scoreInfo
     * @return Map<String,Integer>    
	 */
	public Map<String,Integer> queryScoreInfoTotal(ScoreInfo scoreInfo);
	/**
	 * 
	 * @Description: 根据条件查询ScoreInfo对象列表
     * @author: fengxin
     * @date: 2015年3月26日 下午1:47:24
     * @param scoreInfo
     * @return List<ScoreInfo>    
	 */
	public List<ScoreInfo> queryScoreInfo(ScoreInfo scoreInfo);
	/**
	 * 
	 * @Description: 定时清零积分  
     * @author: fengxin
     * @date: 2015年4月2日 下午5:04:55
     * @return void    
	 */
	public void updateResetScoreInfo(ScoreConfig scoreConfig);
	
}
