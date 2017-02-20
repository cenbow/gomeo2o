/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午8:13:16
 */
package com.gomeo2o.service.account.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.facade.account.entity.BindingBankCard;
import com.gomeo2o.facade.account.entity.SupportBank;
import com.gomeo2o.facade.account.exception.BindingBankCardException;
import com.gomeo2o.service.account.dao.BindingBankCardDao;
import com.gomeo2o.service.account.dao.SupportBankDao;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午8:13:16
 */
@Service("bindingBankCardBiz")
public class BindingBankCardBiz {
	@Autowired
	private BindingBankCardDao bindingBankCardDao;
	@Autowired
	private SupportBankDao supportBankDao;
	/**
	 * @Description: 绑定银行卡
     * @author: zhaojinglei
     * @date: 2015-5-14 下午8:17:25
     * @param map
     * @return void    
	 */
	@Transactional
	public void addBindingBankCard(Map<String,Object> map){
		//查询用户已经绑定的银行卡
		Map<String,Object> user_map = new HashMap<String,Object>();
		user_map.put("isDelete", 0);
		user_map.put("userId", map.get("userId").toString());
		List<BindingBankCard> alcardList = this.bindingBankCardDao.listBy(user_map);
		if(alcardList.size()>0){
			map.put("userName", alcardList.get(0).getUserName());
			map.put("certificate", alcardList.get(0).getCertificate());
		}
		//查询此银行卡是否被绑定
		List<BindingBankCard> cardList = this.bindingBankCardDao.listBy(map);
		if(cardList.size()>0){
			throw BindingBankCardException.ADD_ALREADY_EXCEP;
		}
		int flag = bindingBankCardDao.addBindingBankCard(map);
		if(flag==0){
			throw BindingBankCardException.ADD_DATA_EXCEP;
		}
	}
	
	public List<BindingBankCard> queryBindingBankCardList(Map<String,Object> map){
	    List<BindingBankCard> cardList = this.bindingBankCardDao.listBy(map);
	    //获取银行卡的银行信息
		for (BindingBankCard bindingBankCard : cardList) {
			Map<String,Object> supportMap = new HashMap<String,Object>();
			supportMap.put("id", bindingBankCard.getSupportBankId());
			List<SupportBank> supportBankList = this.supportBankDao.listBy(supportMap);
			//判断是否有银行卡信息
			if(supportBankList != null && supportBankList.size() > 0){
				SupportBank supportBank = supportBankList.get(0);
				bindingBankCard.setBankName(supportBank.getBankName());
				bindingBankCard.setBankLogo(supportBank.getBankLogo());
				bindingBankCard.setCardType(supportBank.getCardType());
				bindingBankCard.setBankCode(supportBank.getBankNo());
			}
		}
		
		return cardList;
	}
	/**
	 * @Description:查询银行卡信息 
     * @author: zhaojinglei
     * @date: 2015-5-16 下午4:22:47
     * @param map
     * @return List<BindingBankCard>    
	 */
	public List<BindingBankCard> queryBindingBankCard(Map<String,Object> map){
	    List<BindingBankCard> cardList = this.bindingBankCardDao.listBy(map);
		return cardList;
	}
	/**
	 * @Description 修改银行卡信息
	 * @author fengxin
	 * @date 2015年11月26日 上午11:29:40
	 * @param map
	 */
	public void updateBindingBankCard(Map<String,Object> map){
		int flag = bindingBankCardDao.updateBindingBankCard(map);
		if(flag==0){
			throw BindingBankCardException.UPDATE_BINGING_BANKCARD_ERROR;
		}
	}
}
