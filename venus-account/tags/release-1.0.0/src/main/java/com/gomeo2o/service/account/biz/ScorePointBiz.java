package com.gomeo2o.service.account.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScorePoint;
import com.gomeo2o.service.account.dao.ScorePointDao;
/**
 * 
 * @Description: 积分埋点Biz
 * @author: fengxin
 * @date: 2015年3月20日 下午4:51:38
 */
@Service("scorePointBiz")
public class ScorePointBiz {
	
	@Autowired
	private ScorePointDao scorePointDao;
	/**
	 * 
	 * @Description: 积分埋点管理列表查询带分页
     * @author: fengxin
     * @date: 2015年3月23日 上午11:28:06
     * @param pageParam
     * @param map
     * @return List<ScorePoint>    
	 */
	public PageBean queryScorePointList(PageParam pageParam,Map<String,Object> map){
		return scorePointDao.queryScorePointList(pageParam,map);
	}
	/**
	 * 
	 * @Description: 新增积分埋点
     * @author: fengxin
     * @date: 2015年3月23日 下午2:26:15
     * @param scorePoint
     * @return void    
	 */
	@Transactional
	public void addScorePoint(ScorePoint scorePoint){
		scorePointDao.insert(scorePoint);
	}
	/**
	 * 
	 * @Description: 积分埋点编辑
     * @author: fengxin
     * @date: 2015年3月23日 下午3:54:37
     * @param scorePoint
     * @return void    
	 */
	@Transactional
	public void updateScorePoint(ScorePoint scorePoint){
		scorePointDao.update(scorePoint);
	}
	/**
	 * 
	 * @Description: 修改积分埋点状态
     * @author: fengxin
     * @date: 2015年3月23日 下午4:19:59
     * @param scorePoint
     * @return void    
	 */
	@Transactional
	public void updateScorePointState(ScorePoint scorePoint){
		scorePointDao.update(scorePoint);
	}
	/**
	 * 
	 * @Description: 根据ID查询积分埋点信息
     * @author: fengxin
     * @date: 2015年3月23日 下午4:22:43
     * @param id
     * @return ScorePoint    
	 */
	public ScorePoint getById (Long id){
		return scorePointDao.getById(id);
	}
	/**
	 * 
	 * @Description: 根据条件查询积分埋点list
     * @author: fengxin
     * @date: 2015年3月31日 下午6:33:32
     * @param scorePoint
     * @return List<ScorePoint>    
	 */
	public List<ScorePoint> queryScorePointByParameters(ScorePoint scorePoint){
		Map<String,Object> map = new HashMap<String,Object>();
		if(scorePoint!=null){
			if(scorePoint.getRuleId()!=null&&!"".equals(scorePoint.getRuleId())){
				map.put("ruleId", scorePoint.getRuleId());
			}
			if(scorePoint.getIsEnable()!=null&&!"".equals(scorePoint.getIsEnable())){
				map.put("isEnable", scorePoint.getIsEnable());
			}
		}
		return this.scorePointDao.listBy(map);
		
	}
}
