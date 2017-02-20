package com.gomeo2o;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.dubbo.common.json.JSON;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.ScoreRule;
import com.gomeo2o.facade.account.service.ScoreRuleFacade;
/**
 * 
 * @Description: 积分规则测试用例
 * @author: fengxin
 * @date: 2015年4月14日 上午9:56:56
 */
public class TestScoreRule extends BaseTest {
	ScoreRuleFacade scoreRuleFacade = null;
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		scoreRuleFacade = (ScoreRuleFacade) context.getBean("scoreRuleFacade");
	}
	
	public void utestQueryScoreRulesList(){
		CommonResultEntity<PageBean> crs = scoreRuleFacade.queryScoreRulesList(new PageParam(1, 10));
		boolean flag = crs.getBusinessObj().getTotalCount()>0;
		assertTrue("未查询都数据", flag);
	}
	
	public void utestQueryScoreRuleByID(){
		ScoreRule scoreRule = new ScoreRule();	
		scoreRule.setId((long)1);
		CommonResultEntity<ScoreRule> crs = scoreRuleFacade.queryScoreRuleByID(scoreRule);
		assertNull("未查询到数据",crs.getBusinessObj().getId());
	}
	
	public void utestUpdateScoreRule() throws Exception{
		ScoreRule upScoreRule = new ScoreRule();
		upScoreRule.setId((long) 1);	
		upScoreRule.setRuleState(2);
		upScoreRule.setRecordTimeStr(3);
		upScoreRule.setRecordValue("120,12,12");
		upScoreRule.setSingleTop(200);
		upScoreRule.setDayTop(100);
		upScoreRule.setTotalTop(1000);
		upScoreRule.setStartTime(new Date());	
		upScoreRule.setEndTime(new Date());
		upScoreRule.setVersion(0);
		upScoreRule.setRuleName("冯鑫测试");
		scoreRuleFacade.updateScoreRule(upScoreRule);
		
		ScoreRule scoreRule = new ScoreRule();
		scoreRule.setId((long) 1);
		String str  = JSON.json(upScoreRule);
		ScoreRule scoreRule1 = (ScoreRule) JSON.parse(str, ScoreRule.class);
		CommonResultEntity<ScoreRule> crs = scoreRuleFacade.queryScoreRuleByID(scoreRule);
		boolean flag = crs.getBusinessObj().getSingleTop()==200;
		assertTrue("更新失败", flag);
	}
	
	public void utestInsertScoreRule() throws Exception{
		ScoreRule sr = new ScoreRule();
		sr.setRuleName("冯鑫测试");
		sr.setRuleState(1);
		sr.setRecordValue("234,234,234");
		sr.setRecordTimeStr(30);
		sr.setDayTop(1000);
		sr.setSingleTop(100);
		sr.setTotalTop(20000);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dstr="2015-5-21"; 
		sr.setStartTime(sdf.parse(dstr));
		sr.setEndTime(sdf.parse(dstr));
		scoreRuleFacade.addScoreRule(sr);
	}
	
	public void utestFindScoreRuleList(){
		CommonResultEntity<List<ScoreRule>> crs = scoreRuleFacade.findScoreRuleList();
		boolean flag = crs.getBusinessObj().size()>0;
		assertTrue("未查询到数据", flag);
	}


	
}
