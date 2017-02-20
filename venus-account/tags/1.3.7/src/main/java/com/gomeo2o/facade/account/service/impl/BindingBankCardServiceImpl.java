/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午8:11:08
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.BindingBankCard;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.facade.account.service.BindingBankCardFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.BindingBankCardBiz;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午8:11:08
 */
@Service("bindingBankCardFacade")
public class BindingBankCardServiceImpl implements BindingBankCardFacade{
	
	@Autowired
	private BindingBankCardBiz bindingBankCardBiz;
	/**
	 * @Description: 绑定银行卡
     * @author: zhaojinglei
     * @date: 2015-5-14 下午8:09:35
     * @param map
     * @return CommonResultEntity<String>    
     * @throws
    */
	public CommonResultEntity<String> addBindingBankCard(Map<String, Object> map) {
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
			//必须验证信息begin
			List<String> mustList = new ArrayList<String>();
			mustList.add("userId");
			//mustList.add("userName");
			mustList.add("supportBankId");
			mustList.add("cardNo");
			mustList.add("lastFour");
			//mustList.add("certificate");
			//mustList.add("mobile");
			//必须验证信息end
			ValidateMapService.validate(map,mustList);
			//银行卡未被删除的
			map.put("isDelete", 0);
			bindingBankCardBiz.addBindingBankCard(map);
		return crs;
	}
	/**
	 * @Description: 获取用户银行卡信息
     * @author: zhaojinglei
     * @date: 2015-5-15 下午3:09:49
     * @param map
     * @return CommonResultEntity<List<BindingBankCard>>    
    */
	public CommonResultEntity<List<BindingBankCard>> queryBindingBankCardByParameters(
			Map<String, Object> map) {
		//去掉不需验证信息begin
		Map<String, Object> unVerifyMap = new HashMap<String, Object>();
		unVerifyMap.put("id", "unVerify");
		//去掉不需验证信息end
		//必须验证信息begin
	    List<String> mustList = new ArrayList<String>();
		mustList.add("userId");
		//必须验证信息end
		ValidateMapService.validate(map,unVerifyMap,mustList);
		//查询银行卡未被删除的
		map.put("isDelete", 0);
		CommonResultEntity<List<BindingBankCard>> crs = new CommonResultEntity<List<BindingBankCard>>();
		crs.setBusinessObj(bindingBankCardBiz.queryBindingBankCardList(map));
		return crs;
	}
	
	/**
	 * 
	 * @Description: 判定银行卡是否已绑定
     * @author: zhaojinglei
     * @date: 2015-5-16 下午3:34:05
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> judgeBindingBankCardExist(
			Map<String, Object> map) {
		//必须验证信息begin
		List<String> mustList = new ArrayList<String>();
		mustList.add("userId");
		mustList.add("cardNo");
		//必须验证信息end
		ValidateMapService.validate(map,mustList);
		//查询银行卡未被删除的
		map.put("isDelete", 0);
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		List<BindingBankCard> list = bindingBankCardBiz.queryBindingBankCard(map);
		
		//已绑定
		if(list != null && list.size() >0 ){
			crs.setBusinessObj(BindingBankCard.BANK_CARD_BINDING);
		}else {//未绑定
			crs.setBusinessObj(BindingBankCard.BANK_CARD_NO_BINDING);
		}
		return crs;
	}
	/**
	 * @Description 修改银行卡信息
	 * @author fengxin
	 * @date 2015年11月26日 上午11:58:05
	 * @param map
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> updateBindingBankCard(Map<String, Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		this.bindingBankCardBiz.updateBindingBankCard(map);
		return crs;
	}
	/**
	 * 
	 * @Description: 根据用户层绑定的银行卡来获取用户开户行姓名和身份证号码
     * @author: fengxin
     * @date: 2015年6月11日 下午8:03:18
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<BindingBankCard> queryBankAccountName(Map<String, Object> map){
		CommonResultEntity<BindingBankCard> crs = new CommonResultEntity<BindingBankCard>();
		List<String> mustList = new ArrayList<String>();
		mustList.add("userId");
		ValidateMapService.validate(map,mustList);
		//查询银行卡未被删除的
		map.put("isDelete", 0);
		List<BindingBankCard> list = bindingBankCardBiz.queryBindingBankCardList(map);
		if(list.size()>0){
			crs.setBusinessObj(list.get(0));
		}else{
			throw AccountException.USER_NO_CARD;
		}
		return crs;
	}
}
	