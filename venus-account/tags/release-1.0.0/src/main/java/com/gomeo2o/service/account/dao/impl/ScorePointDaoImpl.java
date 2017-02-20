package com.gomeo2o.service.account.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScorePoint;
import com.gomeo2o.service.account.dao.ScorePointDao;
/**
 * 
 * @Description: 积分埋点dao实现
 * @author: fengxin
 * @date: 2015年3月20日 下午5:02:04
 */
@Repository("scorePointDao")
public class ScorePointDaoImpl extends BaseDaoImpl<ScorePoint> implements ScorePointDao {
	/**
	 * 
	 * @Description: 积分埋点管理列表查询带分页
     * @author: fengxin
     * @date: 2015年3月23日 上午11:24:13
     * @param pageParam
     * @param map
     * @return List<ScorePoint>    
	 */
	public PageBean queryScorePointList(PageParam pageParam,Map<String,Object> map){
		return this.listPage(pageParam, map);
	}
}
