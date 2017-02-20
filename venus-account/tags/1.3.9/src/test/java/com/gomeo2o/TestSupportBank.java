package com.gomeo2o;

import java.util.List;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.SupportBank;
import com.gomeo2o.facade.account.service.SupportBankFacade;

/**
 * 
 * @Description: 测试支持银行卡
 * @author: zhaojinglei
 * @date: 2015-5-14 下午8:25:11
 */
public class TestSupportBank extends BaseTest {
	
	public static SupportBankFacade supportBankFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		supportBankFacade = (SupportBankFacade) context
				.getBean("supportBankFacade");
	}
	
	public void testQueryScorePointByParameters(){
		
		CommonResultEntity<List<SupportBank>> crs = supportBankFacade.querySupportBankByParameters();
		assertTrue("未查询到数据", crs.getBusinessObj().size()>0);
	}

}
