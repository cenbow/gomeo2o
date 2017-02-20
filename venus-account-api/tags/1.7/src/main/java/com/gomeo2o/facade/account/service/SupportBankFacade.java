/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-15 上午11:46:37
 */
package com.gomeo2o.facade.account.service;

import java.util.List;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.SupportBank;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-15 上午11:46:37
 */
public interface SupportBankFacade {
	/**
	 * 
	 * @Description: 获取支持银行 
     * @author: zhaojinglei
     * @date: 2015-5-15 上午11:47:18
     * @return CommonResultEntity<List<SupportBank>>    
	 */
	public CommonResultEntity<List<SupportBank>> querySupportBankByParameters();
}
