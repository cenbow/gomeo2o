package com.gomeo2o.facade.account.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScorePoint;
import com.gomeo2o.facade.account.service.ScorePointFacade;
import com.gomeo2o.facade.account.utils.ValidateService;
import com.gomeo2o.service.account.biz.ScorePointBiz;
/**
 * 
 * @Description: 积分埋点Service实现
 * @author: fengxin
 * @date: 2015年3月20日 下午4:43:14
 */
@Service("scorePointFacade")
public class ScorePointFacadeImpl implements ScorePointFacade{
	
	@Autowired
	private ScorePointBiz scorePointBiz;
	/**
	 * 
	 * @Description: 积分埋点管理列表查询带分页
     * @author: fengxin
     * @date: 2015年3月23日 上午11:28:06
     * @param pageParam
     * @param map
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryScorePointList(PageParam pageParam,Map<String,Object> map){
		CommonResultEntity<PageBean> rcs = new CommonResultEntity<PageBean>();
		rcs.setBusinessObj(scorePointBiz.queryScorePointList(pageParam,map));
		return rcs;
	}
	/**
	 * 
	 * @Description: 新增积分埋点
     * @author: fengxin
     * @date: 2015年3月23日 下午2:27:50
     * @param scorePoint
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> addScorePoint(ScorePoint scorePoint){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateService.valid(scorePoint);
		scorePointBiz.addScorePoint(scorePoint);
		return crs;
	}
	/**
	 * 
	 * @Description: 积分埋点编辑
     * @author: fengxin
     * @date: 2015年3月23日 下午3:54:37
     * @param scorePoint
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> updateScorePoint(ScorePoint scorePoint){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ValidateService.valid(scorePoint);
		scorePointBiz.updateScorePoint(scorePoint);
		return crs;
	}
	/**
	 * 
	 * @Description: 修改积分埋点状态
     * @author: fengxin
     * @date: 2015年3月23日 下午4:19:59
     * @param scorePoint
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> updateScorePointState(ScorePoint scorePoint){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		ScorePoint oldSp = scorePointBiz.getById(scorePoint.getId());
		if(oldSp!=null){
			oldSp.setIsEnable(scorePoint.getIsEnable());
			ValidateService.valid(oldSp);
			scorePointBiz.updateScorePoint(oldSp);
		}
		return crs;
	}
	/**
	 * 
	 * @Description: 根据条件查询积分埋点list
     * @author: fengxin
     * @date: 2015年3月31日 下午6:33:32
     * @param scorePoint
     * @return CommonResultEntity<List<ScorePoint>>
	 */
	public CommonResultEntity<List<ScorePoint>> queryScorePointByParameters(ScorePoint scorePoint){
		CommonResultEntity<List<ScorePoint>> crs = new CommonResultEntity<List<ScorePoint>>();
		crs.setBusinessObj(scorePointBiz.queryScorePointByParameters(scorePoint));
		return crs;
	}
}
