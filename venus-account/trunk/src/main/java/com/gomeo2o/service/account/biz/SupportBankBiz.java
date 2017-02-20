/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-15 上午11:39:03
 */
package com.gomeo2o.service.account.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.facade.account.entity.SupportBank;
import com.gomeo2o.service.account.dao.SupportBankDao;

/**
 * @Description: TODO 
 * @author: zhaojinglei
 * @date: 2015-5-15 上午11:39:03
 */
@Service("supportBankBiz")
public class SupportBankBiz {
	
	@Autowired
	private SupportBankDao supportBankDao;
	/**
	 * @Description: 查找支持银行卡 
     * @author: zhaojinglei
     * @date: 2015-5-15 下午2:37:46
     * @return List<SupportBank>    
	 */
	public List<SupportBank> querySupportBankList(){
		Map<String,Object> map = new HashMap<String,Object>();
		return  this.supportBankDao.listBy(map);
	}
}
