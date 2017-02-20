/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-15 上午11:45:38
 */
package com.gomeo2o.facade.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.account.entity.SupportBank;
import com.gomeo2o.facade.account.service.SupportBankFacade;
import com.gomeo2o.service.account.biz.SupportBankBiz;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-15 上午11:45:38
 */
@Service("supportBankFacade")
public class SupportBankServiceImpl implements SupportBankFacade{
	@Autowired
	private SupportBankBiz supportBankBiz;
	/**
	 * @Description: 获取支持银行 
     * @author: zhaojinglei
     * @date: 2015-5-15 上午11:47:18
     * @return CommonResultEntity<List<SupportBank>>    
	 */
	public CommonResultEntity<List<SupportBank>> querySupportBankByParameters() {
		CommonResultEntity<List<SupportBank>> crs = new CommonResultEntity<List<SupportBank>>();
		crs.setBusinessObj(supportBankBiz.querySupportBankList());
		return crs;
	}
	
}
