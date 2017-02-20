/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午7:32:19
 */
package com.gomeo2o.service.account.dao;

import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.facade.account.entity.BindingBankCard;



/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午7:32:19
 */
public interface BindingBankCardDao  extends BaseDao<BindingBankCard>{
	/**
	 * @Description: 绑定银行卡 
     * @author: zhaojinglei
     * @date: 2015-5-14 下午7:36:21
     * @param reqParam
     * @return int    
	 */
	public int addBindingBankCard(Map<String, Object> reqParam);
	/**
	 * @Description 修改银行卡信息 
	 * @author fengxin
	 * @date 2015年11月26日 上午11:31:04
	 * @param reqParam
	 * @return int
	 */
	public int updateBindingBankCard(Map<String, Object> reqParam);
}
