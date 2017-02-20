/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: 账户管理
 * @author: fengxin
 * @date: 2015年4月16日 下午5:38:59
 */
package com.gomeo2o.service.account.dao;

import java.util.Map;

import com.gomeo2o.common.core.dao.BaseDao;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AccountInfo;

/**
 * @Description: 账户管理Dao
 * @author: fengxin
 * @date: 2015年4月16日 下午5:38:59
 */
public interface AccountInfoDao extends BaseDao<AccountInfo>{
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年4月25日 上午10:08:10
     * @param reqParam
     * @return int    
	 */
	public int updateAccountInfo(Map<String, Object> reqParam);
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年4月25日 上午10:08:10
     * @param reqParam
     * @return int    
	 */
	public int editAccountInfo(Map<String, Object> reqParam);
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年4月25日 上午10:08:10
     * @param reqParam
     * @return int    
	 */
	public int froozeAccountInfo(Map<String, Object> reqParam);
	/**
	 * 
	 * @Description: 撤销账户冻结积分，返利余额，现金余额
     * @author: fengxin
     * @date: 2015年7月1日 下午8:24:59
     * @param reqParam
     * @return int    
	 */
	public int reSetfroozeAccountInfo(Map<String, Object> reqParam);
	/**
	 * 
	 * @Description: 后台用户资产列表查询
     * @author: fengxin
     * @date: 2015年5月6日 下午5:11:48
     * @param pageParam
     * @param map
     * @return PageBean    
	 */
	public PageBean queryVirAssetsListByParamer(PageParam pageParam,Map<String,Object> map);
	/**
	 * 
	 * @Description: 查询账户的收支明细
     * @author: fengxin
     * @date: 2015年5月9日 下午2:14:23
     * @param pageParam
     * @param map
     * @return PageBean    
	 */
	public PageBean queryBalancePayMentsVoByParamer(PageParam pageParam,Map<String,Object> map);
	/**
	 * 
	 * @Description: 为用户添加支付密码
     * @author: fengxin
     * @date: 2015年5月23日 上午11:30:49
     * @param map
     * @return int    
	 */
	public int updateUserPayPassWord(Map<String,Object> map);
	/**
	 * 
	 * @Description: 创建用户
     * @author: fengxin
     * @date: 2015年5月27日 下午2:17:12
     * @param map
     * @return int    
	 */
	public int addAccountInfo(Map<String,Object> map);
	/**
	 * 
	 * @Description:修改 账户支付密码错误次数
     * @author: fengxin
     * @date: 2015年8月26日 下午4:25:42
     * @param map
     * @return int    
	 */
	public int udpateAccountPayPasswordErrorNO(Map<String,Object> map);
	/**
	 * 
	 * @Description: 重置用户支付密码错误次数
     * @author: fengxin
     * @date: 2015年8月26日 下午5:53:49
     * @param map
     * @return int    
	 */
	public int resetAccountPayPasswordErrorNO(Map<String,Object> map);
}
