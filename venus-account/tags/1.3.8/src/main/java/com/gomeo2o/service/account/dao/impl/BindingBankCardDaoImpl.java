/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午7:33:23
 */
package com.gomeo2o.service.account.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.BindingBankCard;
import com.gomeo2o.service.account.dao.BindingBankCardDao;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午7:33:23
 */
@Repository("bindingBankCardDao")
public class BindingBankCardDaoImpl extends BaseDaoImpl<BindingBankCard> implements BindingBankCardDao{

	/**
	 * @Description: 绑定银行卡
     * @author: zhaojinglei
     * @date: 2015-5-14 下午7:36:21
     * @param reqParam
     * @return int    
     * @throws
     */
	public int addBindingBankCard(Map<String, Object> reqParam) {
		
		return this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.BindingBankCardDaoImpl.addBindingBankCard", reqParam);
	}
	/**
	 * @Description 修改银行卡信息 
	 * @author fengxin
	 * @date 2015年11月26日 上午11:31:04
	 * @param reqParam
	 * @return int
	 */
	public int updateBindingBankCard(Map<String, Object> reqParam){
		return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.BindingBankCardDaoImpl.updateBindingBankCard", reqParam);
	}
	
}
