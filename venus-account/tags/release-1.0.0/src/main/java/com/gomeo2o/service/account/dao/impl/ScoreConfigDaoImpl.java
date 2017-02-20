package com.gomeo2o.service.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.ScoreConfig;
import com.gomeo2o.service.account.dao.ScoreConfigDao;
/**
 * 
 * @Description: 积分配置dao实现
 * @author: fengxin
 * @date: 2015年3月20日 下午5:02:04
 */
@Repository("scoreConfigDao")
public class ScoreConfigDaoImpl extends BaseDaoImpl<ScoreConfig> implements ScoreConfigDao {
	/**
	 * 
	 * @Description: 根据条件查询积分配置信息
     * @author: fengxin
     * @date: 2015年4月2日 下午3:05:50
     * @param scoreConfig
     * @return List<ScoreConfig>    
	 */
	public List<ScoreConfig> queryScoreConfigByParameter(ScoreConfig scoreConfig){
		return this.getSessionTemplate().selectList("com.gomeo2o.service.account.dao.impl.ScoreConfigDaoImpl.queryScoreConfig",scoreConfig);
	}
	
	

}
