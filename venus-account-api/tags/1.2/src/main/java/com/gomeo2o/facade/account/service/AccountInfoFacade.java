/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: wangyunpeng
 * @date: 2015年3月16日下午2:43:44
 */
package com.gomeo2o.facade.account.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AccountInfo;

/**
 * @Description: 账户管理facade
 * @author: gongjiaming
 * @date: 2015年4月17日
 */
public interface AccountInfoFacade {
	
	
	/**
	 * @Description: 增加账户余额
	 * @author: gongjiaming
	 * @date: 2015年4月17日
	 * @param reqParam
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> addAccountInfo(Map<String,Object> reqParam);
	/**
	 * @Description: 增加账户余额
	 * @author: fengxin
	 * @date: 2015年4月17日
	 * @param reqParam
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> addAccountInfo(List<Map<String,Object>> reqList);
	/**
	 * @Description: 减少账户余额
	 * @author: gongjiaming
	 * @date: 2015年4月17日
	 * @param reqParam
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> editAccountInfo(Map<String,Object> reqParam);
	/**
	 * @Description: 冻结/撤销冻结账户余额
	 * @author: gongjiaming
	 * @date: 2015年4月17日
	 * @param reqParam
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> froozeAccountInfo(Map<String,Object> reqParam);
	/**
	 * 
	 * @Description: 撤销账户冻结积分，返利余额，现金余额
     * @author: fengxin
     * @date: 2015年7月1日 下午8:33:46
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> reSetfroozeAccountInfo(Map<String, Object> reqParam); 
	/**
	 * 
	 * @Description: 用户资产查询
     * @author: fengxin
     * @date: 2015年4月30日 上午10:46:00
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<Map<String,Object>> queryVirAssetsSumByParamer(Map<String, Object> reqParam);
	/**
	 * 
	 * @Description: 后台用户资产列表查询
     * @author: fengxin
     * @date: 2015年5月6日 下午5:11:48
     * @param pageParam
     * @param map
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryVirAssetsListByParamer(Map<String,Object> map);
	/**
	 * 
	 * @Description: 根据参数查询账户信息
     * @author: fengxin
     * @date: 2015年5月8日 下午2:13:22
     * @param map
     * @return CommonResultEntity<AccountInfo>    
	 */
	public CommonResultEntity<AccountInfo> queryAccountInfoByParamer(Map<String,Object> map);
	/**
	 * 
	 * @Description: 查询账户的收支明细
     * @author: fengxin
     * @date: 2015年5月9日 下午2:14:23
     * @param pageParam
     * @param map
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryBalancePayMentsVoByParamer(PageParam pageParam,Map<String,Object> map);
	/**
	 * 
	 * @Description: 为用户修改支付密码
     * @author: fengxin
     * @date: 2015年5月23日 上午11:45:03
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateUserPayPassWord(Map<String,Object> map);
	/**
	 * 
	 * @Description: 获取用户业务操作唯一号
     * @author: fengxin
     * @date: 2015年5月23日 下午5:04:45
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> createUserOperateNO(Map<String, Object> reqParam);
	/**
	 * 
	 * @Description: 创建用户
     * @author: fengxin
     * @date: 2015年5月27日 下午3:15:45
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> createAccountInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description: 校验支付密码
     * @author: fengxin
     * @date: 2015年5月27日 下午7:30:56
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> checkUserPayPassword(Map<String,Object> map);
	/**
	 * 
	 * @Description: 重置用户支付密码错误次数
     * @author: fengxin
     * @date: 2015年8月26日 下午5:53:49
     * @param map
     * @return int    
	 */
	public CommonResultEntity<String> resetAccountPayPasswordErrorNO(Map<String,Object> map);
	
	/**
	 * @Description 获取用户可交易的国美币额度（未超过交易限制）
	 * @author fengxin
	 * @date 2015年11月18日 下午12:10:38
	 * @param map
	 * @return CommonResultEntity<BigDecimal>
	 */
	public CommonResultEntity<BigDecimal> queryUseableVirtualByParamer (Map<String,Object> map);
	/**
	 * @Description 检测用户当前交易国美币是否超过限额
	 * @author fengxin
	 * @date 2015年11月20日 上午10:35:10
	 * @param map
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> checkUserVirtualLimit(Map<String,Object> map);
	/**
	 * @Description 消减用户交易使用的国美币限额
	 * @author fengxin
	 * @date 2015年11月25日 下午4:55:34
	 * @param map
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String>  resetUserVirtualLimit(Map<String,Object> map);
}
