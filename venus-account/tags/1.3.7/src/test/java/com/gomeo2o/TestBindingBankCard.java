package com.gomeo2o;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.BindingBankCard;
import com.gomeo2o.facade.account.service.BindingBankCardFacade;

/**
 * 
 * @Description: 测试绑定银行卡
 * @author: zhaojinglei
 * @date: 2015-5-14 下午8:25:11
 */
public class TestBindingBankCard extends BaseTest {
	
	public static BindingBankCardFacade bindingBankCardFacade = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		bindingBankCardFacade = (BindingBankCardFacade) context
				.getBean("bindingBankCardFacade");
	}
	
	public void utestAddBindingBankCard(){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", 12345678);
			map.put("userName", "冯鑫");
			map.put("supportBankId", 3);
			map.put("cardNo", "6228481552887309119");
			map.put("lastFour", "9119");
			map.put("certificate", "620523199008240016");
			map.put("mobile", "15011225919");
			CommonResultEntity<String> crs = bindingBankCardFacade.addBindingBankCard(map);
			assertTrue("添加成功", crs.getCode()==0);
	}
	public void utestQueryScorePointByParameters(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 1);
		map.put("userId", 12345678);
		CommonResultEntity<List<BindingBankCard>> crs = bindingBankCardFacade.queryBindingBankCardByParameters(map);
		assertTrue("未查询到数据", crs.getBusinessObj().size()>0);
	}
	
	public void utestjudgeBindingBankCardExist(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", 1);
		map.put("cardNo", "0123456789012345678");
		CommonResultEntity<String> crs = bindingBankCardFacade.judgeBindingBankCardExist(map);
		assertTrue("未绑定", crs.getBusinessObj().equals("no"));
	}
	
	public void testQueryBankAccountName(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", 12345678);
		CommonResultEntity<BindingBankCard> crs = bindingBankCardFacade.queryBankAccountName(map);
		assertNotNull("获取失败", crs.getBusinessObj());
		
	}
}
