/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: gongjiaming
 * @date: 2015年4月16日 下午4:53:06
 */
package com.gomeo2o.service.account.biz;

import io.terminus.ecp.config.service.ConfigReadService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AccountInfo;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.service.account.dao.AccountInfoDao;
import com.gomeo2o.service.account.dao.MoneyDetailDao;
import com.gomeo2o.service.account.dao.RebateDetailDao;
import com.gomeo2o.service.account.dao.ScoreDetailDao;
import com.gomeo2o.utils.Constants;

/**
 * @Description:账户管理Biz
 * @author:gongjiaming
 * @date: 2015年4月16日
 */
@Service("accountInfoBiz")
public class AccountInfoBiz {
	@Autowired
	private AccountInfoDao accountInfoDao;
	@Autowired
	private MoneyDetailDao moneyDetailDao;
	@Autowired
	private ScoreDetailDao scoreDetailDao;
	@Autowired
	private RebateDetailDao rebateDetailDao;

	//private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @Description: 账户增加
	 * @author: gongjiaming
	 * @date: 2015年4月24日
	 * @param reqParam
	 */
	@Transactional
	public void addAccountInfo(Map<String, Object> reqParam) {
		AccountInfo accountInfo = accountInfoDao.getBy(reqParam);
		if(accountInfo==null){
			throw AccountException.USER_NO_FIND;
		}
		//如果是返利交易
		if(reqParam.get("dealType")!=null&&!"".equals(reqParam.get("dealType"))){
			if("1".equals(reqParam.get("dealType").toString())){
				reqParam.put("rebateHy", reqParam.get("recordValue"));
			}
		}
		//修改账户信息
		int flag = accountInfoDao.updateAccountInfo(reqParam);
		if(flag==0&&Long.valueOf(reqParam.get("recordValue").toString())!=0){
			throw AccountException.EXCEED_BALANCE;
		} 
		//根据修改的账户信息来插入相应的流水
		/*if(Constants.MONEY_TYPE.equals(reqParam.get("accountType").toString())){
			moneyDetailDao.insert(getAccountMoneyDetail(reqParam));
		}*/
		if(Constants.SCORE_TYPE.equals(reqParam.get("accountType").toString())){
			scoreDetailDao.addScoreDetail(reqParam);
			return;
		}
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			if(reqParam.get("rebateState")!=null&&!"".equals(reqParam.get("rebateState"))){
				if(Constants.PLATFORM.equals(reqParam.get("rebateState").toString())){
					reqParam.put("platformRebate", reqParam.get("recordValue"));
				}else if(Constants.MERCHANT.equals(reqParam.get("rebateState").toString())){
					reqParam.put("merchantRebate", reqParam.get("recordValue"));
				}
			}
			rebateDetailDao.addRebateDetail(reqParam);
		}
	}
	/**
	 * @Description: 账户减少，消费
	 * @author: gongjiaming
	 * @date: 2015年4月24日
	 * @param reqParam
	 */
	@Transactional
	public void editAccountInfo(Map<String, Object> reqParam) {
		AccountInfo accountInfo = accountInfoDao.getBy(reqParam);
		if(accountInfo==null){
			throw AccountException.USER_NO_FIND;
		}
		int flag = accountInfoDao.editAccountInfo(reqParam);
		if(flag==0&&Long.valueOf(reqParam.get("recordValue").toString())!=0){
			throw AccountException.EXCEED_BALANCE;
		}
		/*if(Constants.MONEY_TYPE.equals(reqParam.get("accountType").toString())){
			moneyDetailDao.insert(getAccountMoneyDetail(reqParam));
		}*/
		if(Constants.SCORE_TYPE.equals(reqParam.get("accountType").toString())){
			scoreDetailDao.addScoreDetail(reqParam);
			return;
		}
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			rebateDetailDao.addRebateDetail(reqParam);
		}
	}
	/**
	 * @Description: 账户冻结
	 * @author: gongjiaming
	 * @date: 2015年4月24日
	 * @param reqParam
	 */
	@Transactional
	public void froozeAccountInfo(Map<String, Object> reqParam) {
		AccountInfo accountInfo = accountInfoDao.getBy(reqParam);
		if(accountInfo==null){
			throw AccountException.USER_NO_FIND;
		}
		int flag = accountInfoDao.froozeAccountInfo(reqParam);
		if(flag==0&&Long.valueOf(reqParam.get("recordValue").toString())!=0){
			throw AccountException.EXCEED_BALANCE;
		}
		/*if(Constants.MONEY_TYPE.equals(reqParam.get("accountType").toString())){
			moneyDetailDao.insert(getAccountMoneyDetail(reqParam));
		}*/
		if(Constants.SCORE_TYPE.equals(reqParam.get("accountType").toString())){
			scoreDetailDao.addScoreDetail(reqParam);
			return;
		}
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			rebateDetailDao.addRebateDetail(reqParam);
		}
	}
	/**
	 * 
	 * @Description: 撤销账户冻结积分，返利余额，现金余额
     * @author: fengxin
     * @date: 2015年7月1日 下午8:30:41
     * @param reqParam
     * @return void    
	 */
	@Transactional
	public void reSetfroozeAccountInfo(Map<String, Object> reqParam){
		AccountInfo accountInfo = accountInfoDao.getBy(reqParam);
		if(accountInfo==null){
			throw AccountException.USER_NO_FIND;
		}
		int flag = accountInfoDao.reSetfroozeAccountInfo(reqParam);
		if(flag==0&&Long.valueOf(reqParam.get("recordValue").toString())!=0){
			throw AccountException.EXCEED_BALANCE;
		}
		/*if(Constants.MONEY_TYPE.equals(reqParam.get("accountType").toString())){
		moneyDetailDao.insert(getAccountMoneyDetail(reqParam));
		}*/
		if(Constants.SCORE_TYPE.equals(reqParam.get("accountType").toString())){
			scoreDetailDao.addScoreDetail(reqParam);
			return;
		}
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			rebateDetailDao.addRebateDetail(reqParam);
		}
	}
	/**
	 * @Description 校验此业务是否已经被执行过。 
	 * @author fengxin
	 * @date 2015年12月3日 上午11:24:11
	 * @param reqParam
	 * @return  true:未被执行可以继续  false 已经被执行 不能在继续执行
	 */
	public boolean checkTwiceBuiness(Map<String, Object> reqParam){
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			if(rebateDetailDao.queryRebateDetailByParamer(reqParam)!=null){
				return false;
			}
		}
		return true;
	}

	/**
	 * @Description: 根据传入参数获取AccountRebateDetail
	 * @author: gongjiaming
	 * @date: 2015年4月23日
	 * @param reqParam
	 */
	/*private RebateDetail getAccountRebateDetail(Map<String, Object> reqParam) {
		RebateDetail accountRebateDetail = new RebateDetail();
		accountRebateDetail.setDetailNo(Constants.getRebateDetailNo());
		accountRebateDetail.setUserId(Long.valueOf(reqParam.get("userId")
				.toString()));
		try {
			accountRebateDetail.setDealTime(format.parse(reqParam.get(
					"dealTime").toString()));
			accountRebateDetail.setRecordTime(format.parse(reqParam.get(
					"recordTime").toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		accountRebateDetail.setRecordValue(new BigDecimal(reqParam.get(
				"recordValue").toString()));
		accountRebateDetail.setDealType(Integer.parseInt(reqParam.get(
				"dealType").toString()));
		accountRebateDetail
				.setDealRemark(reqParam.get("dealRemark").toString());
		accountRebateDetail.setCreator(reqParam.get("creator").toString());
		accountRebateDetail.setDealRemark(reqParam.get("detailRemark")
				.toString());
		accountRebateDetail.setState(1);
		return accountRebateDetail;
	}*/

	/**
	 * @Description: 根据传入参数获取AccountScoreDetail
	 * @author: gongjiaming
	 * @date: 2015年4月23日
	 * @param reqParam
	 * @return
	 */
	/*private ScoreDetail getAccountScoreDetail(Map<String, Object> reqParam) {
		ScoreDetail accountScoreDetail = new ScoreDetail();
		accountScoreDetail.setDetailNo(Constants.getScoreDetailNo());
		accountScoreDetail.setUserId(Long.valueOf(reqParam.get("userId")
				.toString()));
		try {
			accountScoreDetail.setDealTime(format.parse(reqParam
					.get("dealTime").toString()));
			accountScoreDetail.setRecordTime(format.parse(reqParam.get(
					"recordTime").toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		accountScoreDetail.setRecordValue(Integer.parseInt(reqParam
				.get("recordValue").toString()));
		accountScoreDetail.setDealType(Integer.parseInt(reqParam
				.get("dealType").toString()));
		accountScoreDetail.setDealRemark(reqParam.get("dealRemark").toString());
		accountScoreDetail.setCreator(reqParam.get("creator").toString());
		accountScoreDetail.setDealRemark(reqParam.get("detailRemark")
				.toString());
		accountScoreDetail.setState(1);
		return accountScoreDetail;
	}*/

	/**
	 * @Description: 根据传入参数获取AccountMoneyDetail
	 * @author: gongjiaming
	 * @date: 2015年4月23日
	 * @param reqParam
	 * @return 
	 */
	/*private MoneyDetail getAccountMoneyDetail(Map<String, Object> reqParam) {
		MoneyDetail accountMoneyDetail = new MoneyDetail();
		accountMoneyDetail.setDetailNo(Constants.getMoneyDetailNo());
		accountMoneyDetail.setUserId(Long.valueOf(reqParam.get("userId").toString()));
		try {
			accountMoneyDetail.setDealTime(format.parse(reqParam.get("dealTime").toString()));
			accountMoneyDetail.setRecordTime(format.parse(reqParam.get("recordTime").toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		accountMoneyDetail.setRecordValue(new BigDecimal(reqParam.get("recordValue").toString()));
		accountMoneyDetail.setDealType(Integer.parseInt(reqParam.get("dealType").toString()));
		accountMoneyDetail.setDealRemark(reqParam.get("dealRemark").toString());
		accountMoneyDetail.setCreator(reqParam.get("creator").toString());
		accountMoneyDetail.setDetailRemark(reqParam.get("detailRemark").toString());
		accountMoneyDetail.setState(1);
		return accountMoneyDetail;
	}*/
	/**
	 * 
	 * @Description: 根据参数查询账户信息
     * @author: fengxin
     * @date: 2015年4月30日 上午11:04:10
     * @param accountInfo
     * @return AccountInfo    
	 */
	public AccountInfo queryAccountInfoByParamer(AccountInfo accountInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", accountInfo.getUserId());
		AccountInfo account = this.accountInfoDao.getBy(map);
		if(account!=null){
			return account;
		}else{
			throw AccountException.USER_NO_FIND;
		}
	}
	
	/**
	 * 
	 * @Description: 后台用户资产列表查询
     * @author: fengxin
     * @date: 2015年5月6日 下午5:11:48
     * @param pageParam
     * @param map
     * @return PageBean    
	 */
	public PageBean queryVirAssetsListByParamer(PageParam pageParam,Map<String,Object> map){
		return this.accountInfoDao.queryVirAssetsListByParamer(pageParam, map);
	}
	/**
	 * 
	 * @Description: 查询账户的收支明细(app)
     * @author: fengxin
     * @date: 2015年5月9日 下午2:14:23
     * @param pageParam
     * @param map
     * @return PageBean    
	 */
	public PageBean queryBalancePayMentsVoByParamer(PageParam pageParam,Map<String,Object> map){
		return this.accountInfoDao.queryBalancePayMentsVoByParamer(pageParam, map);
	}
	/**
	 * 
	 * @Description: 为用户添加支付密码
     * @author: fengxin
     * @date: 2015年5月23日 上午11:30:49
     * @param map
     * @return void    
	 */
	public void updateUserPayPassWord(Map<String,Object> map){
		int flag = this.accountInfoDao.updateUserPayPassWord(map);
		if(flag==0){
			throw AccountException.USER_PASSWORD_ERROE;
		}
	}
	/**
	 * 
	 * @Description: 创建用户
     * @author: fengxin
     * @date: 2015年5月27日 下午3:15:45
     * @param map
     * @return void    
	 */
	public void createAccountInfo(Map<String,Object> map){
		AccountInfo account = this.accountInfoDao.getBy(map);
		if(account==null){
			int flag = this.accountInfoDao.addAccountInfo(map);
			if(flag==0){
				throw AccountException.USER_CREATE_FIND;
			}
		}
	}
	/**
	 * 
	 * @Description: 校验用户支付密码是否和传来的匹配
     * @author: fengxin
     * @date: 2015年5月27日 下午7:26:52
     * @param map
     * @return boolean    
	 */
	public boolean checkUserPayPassword(Map<String,Object> map){
		AccountInfo account = this.accountInfoDao.getBy(map);
		if(account!=null){
			if(account.getPayErrorNo()>4){
				throw AccountException.ACCOUNT_PAYPASSWORD_OUTNO;
			}
			if(null!=account.getPayPassword()&&!"".equals(account.getPayPassword())){
				if(map.get("payPassword").toString().equals(account.getPayPassword())){
					return true;
				}else{
					map.put("payErrorDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					this.accountInfoDao.udpateAccountPayPasswordErrorNO(map);
					if(account.getPayErrorNo()==4){
						throw AccountException.ACCOUNT_PAYPASSWORD_OUTNO;
					}
				}
			}
		}
		return false;
	}
	/**
	 * 
	 * @Description: 重置用户支付密码错误次数
     * @author: fengxin
     * @date: 2015年8月26日 下午5:53:49
     * @param map
     * @return int    
	 */
	public void resetAccountPayPasswordErrorNO(Map<String,Object> map){
		this.accountInfoDao.resetAccountPayPasswordErrorNO(map);
	}
}
