package com.gomeo2o;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.ScoreInfo;
import com.gomeo2o.facade.account.service.ScoreInfoFacade;
/**
 * 
 * @Description: 积分信息测试用例
 * @author: fengxin
 * @date: 2015年4月14日 上午9:56:20
 */
public class TestScoreInfo extends BaseTest {
	ScoreInfoFacade scoreInfoFacade = null;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		scoreInfoFacade = (ScoreInfoFacade) context.getBean("scoreInfoFacade");
	}
	
	public void utestQueryScoreInfoTotal() throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dstr="2012-3-21"; 
		ScoreInfo s = new ScoreInfo();
		s.setSiStartDealTime(sdf.parse(dstr));
		s.setSiEndDealTime(new Date());
		CommonResultEntity<Map<String,Integer>> crs = scoreInfoFacade.queryScoreInfoTotal(s);	
		assertTrue("未查询到数据", crs.getBusinessObj().size()>0);
	}
	
	public void testUpdateRecordScoreInfo(){
		scoreInfoFacade.updateRecordScoreInfo();
	}
}
