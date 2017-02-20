package com.gomeo2o;

import java.text.ParseException;
import java.util.Date;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreConfig;
import com.gomeo2o.facade.account.service.ScoreConfigFacade;
/**
 * 
 * @Description: 积分规则测试用例
 * @author: fengxin
 * @date: 2015年4月14日 上午9:55:48
 */
public class TestScoreConfig extends BaseTest {
	ScoreConfigFacade scoreConfigFacade = null;
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		scoreConfigFacade = (ScoreConfigFacade) context.getBean("scoreConfigFacade");

	}
	
	public void utestQueryScoreConfigList() throws ParseException{
		CommonResultEntity<PageBean> crs = scoreConfigFacade.queryScoreConfigList(new PageParam(1,10));
		assertTrue("未查询到数据", crs.getBusinessObj().getTotalCount()>0);
	}
	
	public void testAddScoreConfig() throws Exception{
		for (int i = 0; i < 50; i++) {
			ScoreConfig s = new ScoreConfig();
			s.setConfigName("fengxin");
			s.setIsEnable(1);
			s.setIsMail(1);
			s.setIsSms(1);
			s.setIsSystem(1);
			s.setNoticeOne(new Date());
			s.setNoticeTwo(new Date());
			s.setResetValue((double) 30);
			s.setResetRule(1);
			s.setResetTime(new Date());
			scoreConfigFacade.addScoreConfig(s);
			assertNull("保存失败",s.getId());
		}
	}
	public void utestupdateScoreConfig() throws Exception {
		ScoreConfig s = new ScoreConfig();
		s.setId((long) 251);
		s.setIsEnable(0);
		s.setIsMail(0);
		s.setIsSms(0);
		s.setIsSystem(0);
		s.setNoticeOne(new Date());
		s.setNoticeTwo(new Date());
		s.setResetValue((double) 1000);
		s.setResetRule(0);
		s.setResetTime(new Date());
		s.setVersion(0);
		scoreConfigFacade.updateScoreConfig(s);
	}
	
	public void utestQueryScoreConfigInfo(){
		ScoreConfig s = new ScoreConfig();
		s.setId((long) 251);
		scoreConfigFacade.queryScoreConfigInfo(s);
	}
	
	public void utestQueryScoreConfig(){
		scoreConfigFacade.updateResetScore();
	}
}
