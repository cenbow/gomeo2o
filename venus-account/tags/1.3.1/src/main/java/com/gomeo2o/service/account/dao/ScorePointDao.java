package com.gomeo2o.service.account.dao;

import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScorePoint;
/**
 * 
 * @Description: 积分埋点Dao
 * @author: fengxin
 * @date: 2015年3月20日 下午4:56:47
 */
public interface ScorePointDao extends BaseDao<ScorePoint> {
	/**
	 * 
	 * @Description: 积分埋点管理列表查询带分页
     * @author: fengxin
     * @date: 2015年3月23日 上午11:25:35
     * @param pageParam
     * @return PageBean
	 */
	public PageBean queryScorePointList(PageParam pageParam,Map<String,Object> map);
}
