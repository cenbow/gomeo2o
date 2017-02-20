package com.gomeo2o.facade.account.service;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScorePoint;

/**
 * @Description: 积分埋点facade
 * @author: fengxin
 * @date: 2015年3月20日 下午4:40:51
 */
public interface ScorePointFacade {
	/**
	 * @Description: 获取埋点列表
     * @author: fengxin
     * @date: 2015年3月23日 上午11:29:59
     * @param pageParam
     * @param map
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryScorePointList(PageParam pageParam, Map<String,Object> map);
	
	/**
	 * @Description: 新增积分埋点
     * @author: fengxin
     * @date: 2015年3月23日 下午2:27:50
     * @param scorePoint
     * @return CommonResultEntity<String>  
     * @throws Exception   
	 */
	public CommonResultEntity<String> addScorePoint(ScorePoint scorePoint);
	/**
	 * @Description: 积分埋点编辑
     * @author: fengxin
     * @date: 2015年3月23日 下午3:54:37
     * @param scorePoint
     * @return CommonResultEntity<String>  
     * @throws Exception 
	 */
	public CommonResultEntity<String> updateScorePoint(ScorePoint scorePoint);
	/**
	 * @Description: 修改积分埋点状态
     * @author: fengxin
     * @date: 2015年3月23日 下午4:19:59
     * @param scorePoint
     * @return CommonResultEntity<String>   
     * @throws Exception  
	 */
	public CommonResultEntity<String> updateScorePointState(ScorePoint scorePoint) throws Exception;
	/**
	 * 
	 * @Description: 根据条件查询积分埋点list
     * @author: fengxin
     * @date: 2015年3月31日 下午6:33:32
     * @param scorePoint
     * @return CommonResultEntity<List<ScorePoint>>
	 */
	public CommonResultEntity<List<ScorePoint>> queryScorePointByParameters(ScorePoint scorePoint);
}
