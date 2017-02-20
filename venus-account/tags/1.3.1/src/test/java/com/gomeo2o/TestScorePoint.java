package com.gomeo2o;

import java.util.HashMap;
import java.util.List;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScorePoint;
import com.gomeo2o.facade.account.service.ScorePointFacade;
/**
 * 
 * @Description: 积分埋点测试用例
 * @author: fengxin
 * @date: 2015年4月14日 上午9:56:33
 */
public class TestScorePoint extends BaseTest {
	ScorePointFacade scorePointFacade = null;
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		scorePointFacade = (ScorePointFacade) context.getBean("scorePointFacade");
	}


	public void utestQueryScorePointList() {
		CommonResultEntity<PageBean> crs  = scorePointFacade.queryScorePointList(new PageParam(1, 10),new HashMap<String,Object>());
		assertTrue("未查询到数据", crs.getBusinessObj().getTotalCount()>0);
	}
	
	public void utestCreateScorePoint() throws Exception {
		ScorePoint scorePoint = new ScorePoint();
		scorePoint.setName("详情页分享埋点2");
		scorePoint.setCode("001");
		scorePoint.setRuleId((long) 2);
		scorePoint.setIsEnable(1);
		scorePoint.setCreator("冯鑫");
		scorePointFacade.addScorePoint(scorePoint);
		assertNull(scorePoint.getId());
	}
	
	public void utestUpdateScorePoint() throws Exception {
		ScorePoint scorePoint = new ScorePoint();
		scorePoint.setCode("01211");
		scorePoint.setId((long)1);
		scorePoint.setName("详情页分享埋点test");
		scorePoint.setIsEnable(0);
		scorePoint.setRuleId((long) 4);
		scorePoint.setCreator("冯鑫1");
		scorePointFacade.updateScorePoint(scorePoint);
	}
	
	public void testUpdateScorePointState() throws Exception{
		ScorePoint scorePoint = new ScorePoint();
		scorePoint.setId((long)1);
		scorePoint.setIsEnable(1);
		scorePointFacade.updateScorePointState(scorePoint);
	}
	
	public void utestUERS(){
		ScorePoint scorePoint = new ScorePoint();
		scorePoint.setRuleId((long)1);
		scorePoint.setIsEnable(1);
		CommonResultEntity<List<ScorePoint>> crs = scorePointFacade.queryScorePointByParameters(scorePoint);
		assertTrue("未查询到数据", crs.getBusinessObj().size()>0);
	} 
}
