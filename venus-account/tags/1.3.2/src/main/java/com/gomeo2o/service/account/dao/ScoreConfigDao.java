package com.gomeo2o.service.account.dao;

import java.util.List;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.ScoreConfig;
/**
 * 
 * @Description: 积分配置Dao
 * @author: fengxin
 * @date: 2015年3月20日 下午4:56:47
 */
public interface ScoreConfigDao extends BaseDao<ScoreConfig> {
	
	/**
	 * 
	 * @Description: 根据条件查询积分配置
     * @author: fengxin
     * @date: 2015年4月2日 下午3:05:50
     * @param scoreConfig
     * @return List<ScoreConfig>    
	 */
	public List<ScoreConfig> queryScoreConfigByParameter(ScoreConfig scoreConfig);
}
