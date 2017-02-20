package com.gomeo2o.service.account.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.ScoreConfig;
import com.gomeo2o.facade.account.entity.ScoreInfo;
import com.gomeo2o.service.account.dao.ScoreInfoDao;
/**
 * 
 * @Description: 积分信息dao实现
 * @author: fengxin
 * @date: 2015年3月20日 下午5:02:04
 */
@Repository("scoreInfoDao")
public class ScoreInfoDaoImpl extends BaseDaoImpl<ScoreInfo> implements ScoreInfoDao {
	/**
	 * 
	 * @Description: 积分数据汇总信息查询
     * @author: fengxin
     * @date: 2015年3月25日 下午4:11:15
     * @param scoreInfo
     * @return Map<String,Integer>    
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Integer> queryScoreInfoTotal(ScoreInfo scoreInfo){
		List<Object> list = this.getSessionTemplate().selectList("com.gomeo2o.service.account.dao.impl.ScoreInfoDaoImpl.queryScoreInfoTotal", scoreInfo);
		if(list.size()>0){
			return (Map<String, Integer>) list.get(0);
		}
		return null;
	}
	/**
	 * 
	 * @Description: 根据条件查询ScoreInfo对象列表
     * @author: fengxin
     * @date: 2015年3月26日 下午1:47:24
     * @param scoreInfo
     * @return List<ScoreInfo>    
	 */
	public List<ScoreInfo> queryScoreInfo(ScoreInfo scoreInfo){
		return  getSessionTemplate().selectList("com.gomeo2o.service.score.dao.impl.ScoreInfoDaoImpl.queryScoreInfo", scoreInfo);
	}
	/**
	 * 
	 * @Description: 定时清零积分  
     * @author: fengxin
     * @date: 2015年4月2日 下午5:04:55
     * @return void    
	 */
	public void updateResetScoreInfo(ScoreConfig scoreConfig){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("resetValue", scoreConfig.getResetValue());
		this.getSessionTemplate().update("com.gomeo2o.service.score.dao.impl.ScoreInfoDaoImpl.updateCount", map);
	}
	

}
