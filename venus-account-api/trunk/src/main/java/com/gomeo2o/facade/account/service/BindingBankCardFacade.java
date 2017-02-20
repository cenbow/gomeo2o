/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午8:08:49
 */
package com.gomeo2o.facade.account.service;

import java.util.List;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.BindingBankCard;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-14 下午8:08:49
 */
public interface BindingBankCardFacade {
	/**
	 * @Description: 绑定银行卡
     * @author: zhaojinglei
     * @date: 2015-5-14 下午8:09:35
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> addBindingBankCard(Map<String,Object> map);
	/**
	 * @Description: 获取用户银行卡信息
     * @author: zhaojinglei
     * @date: 2015-5-15 下午3:09:49
     * @param map
     * @return CommonResultEntity<List<BindingBankCard>>    
	 */
	public CommonResultEntity<List<BindingBankCard>> queryBindingBankCardByParameters(Map<String,Object> map);
	/**
	 * 
	 * @Description: 判定银行卡是否已绑定
     * @author: zhaojinglei
     * @date: 2015-5-16 下午3:34:05
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> judgeBindingBankCardExist(Map<String,Object> map);
	
	/**
	 * 
	 * @Description: 根据用户层绑定的银行卡来获取用户开户行姓名和身份证号码
     * @author: fengxin
     * @date: 2015年6月11日 下午8:03:18
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<BindingBankCard> queryBankAccountName(Map<String, Object> map);
	/**
	 * @Description 修改银行卡信息
	 * @author fengxin
	 * @date 2015年11月26日 上午11:58:05
	 * @param map
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> updateBindingBankCard(Map<String, Object> map);
	
	
}
