/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author fengxin
 * @date 2015年11月12日 下午3:43:11
 */
package com.gomeo2o.service.account.biz;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.facade.account.entity.AccountInfo;
import com.gomeo2o.facade.account.entity.VirtualLimitInfo;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.service.account.dao.AccountInfoDao;
import com.gomeo2o.service.account.dao.VirtualLimitInfoDao;
import com.gomeo2o.service.account.dao.redis.VirtualTotalInfoDao;

/**
 * @Description 账户用户国美币限额Biz
 * @author fengxin
 * @date 2015年11月12日 下午3:43:11
 */
@Service("virtualTotalInfoBiz")
public class VirtualTotalInfoBiz {
	/**
	 * 账户用户国美币限额Dao
	 */
	@Autowired
	private VirtualTotalInfoDao virtualTotalInfoDao;
	
	@Autowired
	private AccountInfoDao accountInfoDao;
	/*
	 * 国美币交易限额dao
	 */
	@Autowired
	private VirtualLimitInfoDao virtualLimitInfoDao;
	
	/**
	 * @Description 查询用户当前可用支付、提现限额的国美币值
	 * @author fengxin
	 * @date 2015年11月12日 下午4:06:15
	 * @param map
	 * @return BigDecimal
	 */
	public BigDecimal queryUseableVirtualByParamer(Map<String,Object> map){
		//交易类型 未知当前交易类型
		if(map.get("limitType")==null||"".equals(map.get("limitType"))){
			throw AccountException.UN_KNOW_LIMIT_TYPE;
		}
		String limitType = map.get("limitType").toString();
		String userId = map.get("userId").toString();
		AccountInfo accountInfo = accountInfoDao.getBy(map);
		if(accountInfo==null){
			throw AccountException.USER_NO_FIND;
		}
		//获取当前交易类型限额信息
		VirtualLimitInfo virtualLimitInfo = virtualLimitInfoDao.getBy(map);
		if(virtualLimitInfo==null){
			throw AccountException.LIMIT_TYPE_OBJECT_IS_NULL;
		}
		if(virtualLimitInfo.getDayCount().equals(virtualTotalInfoDao.queryUserDayNoLimit(limitType,userId))){
			return new BigDecimal(0);
		}
		return getUserMinRebateBa(virtualLimitInfo, accountInfo, limitType);
	}
	/**
	 * @Description 计算用户可用的国美币余额
	 * @author fengxin
	 * @date 2015年11月17日 下午6:09:42
	 * @param virtualLimitInfo
	 * @param accountInfo
	 * @param limitType
	 * @return BigDecimal
	 */
	public BigDecimal getUserMinRebateBa(VirtualLimitInfo virtualLimitInfo,AccountInfo accountInfo,String limitType){
		Set<BigDecimal> set  = new TreeSet<BigDecimal>();
		set.add(accountInfo.getRebateBa());
		set.add(new BigDecimal(virtualLimitInfo.getSingleMax()));
		set.add(new BigDecimal(virtualLimitInfo.getDayMax()).subtract(virtualTotalInfoDao.queryUserDayTopLimit(limitType, accountInfo.getUserId().toString())));
		set.add(new BigDecimal(virtualLimitInfo.getMonthMax()).subtract(virtualTotalInfoDao.queryUserMonthTopLimit(limitType, accountInfo.getUserId().toString())));
		if(new BigDecimal(set.toArray()[0].toString()).compareTo(new BigDecimal(virtualLimitInfo.getSingleMin()))>0){
			return new BigDecimal(set.toArray()[0].toString());
		}
		return new BigDecimal(0);
	}
	/**
	 * @Description 消减用户redis国美币额度信息
	 * @author fengxin
	 * @date 2015年11月25日 下午4:35:04
	 * @param map
	 */
	public void resetUserVirtualLimit(Map<String,Object> map){
		//错误错误 未知当前交易类型
		if(map.get("limitType")==null||"".equals(map.get("limitType"))){
			throw AccountException.UN_KNOW_LIMIT_TYPE;
		}
		//错误错误 未知当前交易日期
		if(map.get("limitDate")==null||"".equals(map.get("limitDate"))){
			throw AccountException.UN_KNOW_LIMIT_DATE;
		}
		String limitType = map.get("limitType").toString();
		String userId = map.get("userId").toString();
		if(map.get("limitDate").toString().equals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))){
			virtualTotalInfoDao.updateDayOrMonthTop(limitType, userId, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), new BigDecimal(map.get("recordValue").toString()).multiply(new BigDecimal("-1")));
			//virtualTotalInfoDao.updateUserDayNoLimit(limitType,userId,-1);
		}
		virtualTotalInfoDao.updateDayOrMonthTop(limitType, userId, new SimpleDateFormat("yyyy-MM").format(new Date()), new BigDecimal(map.get("recordValue").toString()).multiply(new BigDecimal("-1")));
		
	}
	/**
	 * @Description 检测用户当前交易是否超出限额
	 * @author fengxin
	 * @date 2015年11月12日 下午3:55:21
	 * @param map
	 * @return void
	 */
	@Transactional
	public void checkUserVirtualLimit(Map<String,Object> map){
		//错误错误 未知当前交易类型
		if(map.get("limitType")==null||"".equals(map.get("limitType"))){
			throw AccountException.UN_KNOW_LIMIT_TYPE;
		}
		String limitType = map.get("limitType").toString();
		String userId = map.get("userId").toString();
		//获取当前交易类型限额信息
		VirtualLimitInfo virtualLimitInfo = virtualLimitInfoDao.getBy(map);
		if(virtualLimitInfo==null){
			throw AccountException.LIMIT_TYPE_OBJECT_IS_NULL;
		}
		//校验当日交易次数
		if(virtualLimitInfo.getDayCount().equals(virtualTotalInfoDao.queryUserDayNoLimit(limitType,userId))){
			throw AccountException.LIMIT_DAY_COUNT_IS_OVER;
		}
		//检验单笔交易限额
		if(new BigDecimal(virtualLimitInfo.getSingleMin()).compareTo(new BigDecimal(map.get("recordValue").toString()))>0
				||new BigDecimal(map.get("recordValue").toString()).compareTo(new BigDecimal(virtualLimitInfo.getSingleMax()))>0){
			throw AccountException.LIMIT_SINGLE_TOP_IS_OVER;
		}
		//校验日交易限额
		if(virtualTotalInfoDao.queryUserDayTopLimit(limitType, userId).add(new BigDecimal(map.get("recordValue").toString())).compareTo(new BigDecimal(virtualLimitInfo.getDayMax()))>0){
			throw AccountException.LIMIT_DAY_TOP_IS_OVER;
		}
		//校验月交易限额
		if(virtualTotalInfoDao.queryUserMonthTopLimit(limitType, userId).add(new BigDecimal(map.get("recordValue").toString())).compareTo(new BigDecimal(virtualLimitInfo.getMonthMax()))>0){
			throw AccountException.LIMIT_MONTH_TOP_IS_OVER;
		}
		virtualTotalInfoDao.updateUserDayNoLimit(limitType,userId,1);
		virtualTotalInfoDao.updateDayOrMonthTop(limitType, userId, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), new BigDecimal(map.get("recordValue").toString()));
		virtualTotalInfoDao.updateDayOrMonthTop(limitType, userId, new SimpleDateFormat("yyyy-MM").format(new Date()), new BigDecimal(map.get("recordValue").toString()));
		//校验日交易限额
		if(virtualTotalInfoDao.queryUserDayTopLimit(limitType, userId).compareTo(new BigDecimal(virtualLimitInfo.getDayMax()))>0){
			virtualTotalInfoDao.updateDayOrMonthTop(limitType, userId, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), new BigDecimal(map.get("recordValue").toString()).multiply(new BigDecimal("-1")));
			throw AccountException.LIMIT_DAY_TOP_IS_OVER;
		}
		//校验月交易限额
		if(virtualTotalInfoDao.queryUserMonthTopLimit(limitType, userId).compareTo(new BigDecimal(virtualLimitInfo.getMonthMax()))>0){
			virtualTotalInfoDao.updateDayOrMonthTop(limitType, userId, new SimpleDateFormat("yyyy-MM").format(new Date()), new BigDecimal(map.get("recordValue").toString()).multiply(new BigDecimal("-1")));
			throw AccountException.LIMIT_MONTH_TOP_IS_OVER;
		}
	}

}
