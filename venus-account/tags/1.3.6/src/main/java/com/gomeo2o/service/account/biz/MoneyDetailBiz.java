/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: gongjiaming
 * @date: 2015年4月16日 下午4:53:06
 */
package com.gomeo2o.service.account.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.facade.account.entity.MoneyDetail;
import com.gomeo2o.service.account.dao.MoneyDetailDao;
/**
 * @Description:账户现金Biz
 * @author:gongjiaming
 * @date: 2015年4月16日
 */
@Service("moneyDetailBiz")
public class MoneyDetailBiz {

	@Autowired
	private MoneyDetailDao moneyDetailDao;
	/**
	 * @Description:增加账户现金明细
	 * @author: gongjiaming
	 * @date: 2015年4月17日
	 * @param accountMoneyDetail
	 */
	public long addAccountMoneyDetail(MoneyDetail accountMoneyDetail){
		return moneyDetailDao.insert(accountMoneyDetail);
	}
	/**
	 * @Description: 修改账户现金明细状态
	 * @author: gongjiaming
	 * @date: 2015年4月16日
	 * @param accountMoneyDetail
	 */
	public long updateMoneyDetailState(MoneyDetail accountMoneyDetail){
		return moneyDetailDao.update(accountMoneyDetail);
	}
}
