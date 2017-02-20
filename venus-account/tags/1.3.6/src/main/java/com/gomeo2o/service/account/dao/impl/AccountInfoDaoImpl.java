package com.gomeo2o.service.account.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AccountInfo;
import com.gomeo2o.service.account.dao.AccountInfoDao;
import com.gomeo2o.utils.Constants;
/**
 * 
 * @Description: 账户管理dao实现
 * @author: fengxin
 * @date: 2015年4月16日 下午5:41:36
 */
@Repository("accountInfoDao")
public class AccountInfoDaoImpl extends BaseDaoImpl<AccountInfo> implements AccountInfoDao {
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年4月25日 上午10:08:10
     * @param reqParam
     * @return int    
	 */
	public int updateAccountInfo(Map<String, Object> reqParam){
		if(Constants.MONEY_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.updateMoney", reqParam);
		}
		if(Constants.SCORE_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.updateScore", reqParam);
		}
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.updateRebate", reqParam);
		}
		return 0;
	}
	
	
	
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年4月25日 上午10:08:10
     * @param reqParam
     * @return int    
	 */
	public int editAccountInfo(Map<String, Object> reqParam){
		if(Constants.MONEY_TYPE.equals(reqParam.get("accountType").toString())){
			return  this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.editMoney", reqParam);
		}
		if(Constants.SCORE_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.editScore", reqParam);
		}
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.editRebate", reqParam);
		}
		return 0;
	}
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年4月25日 上午10:08:10
     * @param reqParam
     * @return int    
	 */
	public int froozeAccountInfo(Map<String, Object> reqParam){
		if(Constants.MONEY_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.froozeMoney", reqParam);
		}
		if(Constants.SCORE_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.froozeScore", reqParam);
		}
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.froozeRebate", reqParam);
		}
		return 0;
	}
	/**
	 * 
	 * @Description: 撤销账户冻结积分，返利余额，现金余额
     * @author: fengxin
     * @date: 2015年7月1日 下午8:24:59
     * @param reqParam
     * @return int    
	 */
	public int reSetfroozeAccountInfo(Map<String, Object> reqParam){
		/*if(Constants.MONEY_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.reSetfroozeRebate", reqParam);
		}
		if(Constants.SCORE_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.reSetfroozeRebate", reqParam);
		}*/
		if(Constants.REBATE_TYPE.equals(reqParam.get("accountType").toString())){
			return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.reSetfroozeRebate", reqParam);
		}
		return 0;
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
		return this.listPage(pageParam, map);
	}
	/**
	 * 
	 * @Description: 查询账户的收支明细 
     * @author: fengxin
     * @date: 2015年5月9日 下午2:14:23
     * @param pageParam
     * @param map
     * @return PageBean    
	 */
	public PageBean queryBalancePayMentsVoByParamer(PageParam pageParam,Map<String,Object> map){
		map.put("pageFirst", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
		map.put("pageSize", pageParam.getNumPerPage());
		Long count = this.getSessionTemplate().selectOne("com.gomeo2o.service.account.dao.impl.BalancePaymentsVoDaoImpl.listPageCount", map);
		List<?> list = this.getSessionTemplate().selectList("com.gomeo2o.service.account.dao.impl.BalancePaymentsVoDaoImpl.listPage", map);
		return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
		
	}
	/**
	 * 
	 * @Description: 为用户添加支付密码
     * @author: fengxin
     * @date: 2015年5月23日 上午11:30:49
     * @param map
     * @return int    
	 */
	public int updateUserPayPassWord(Map<String,Object> map){
		return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.updateUserPassword", map);
	}
	/**
	 * 
	 * @Description: 创建用户
     * @author: fengxin
     * @date: 2015年5月27日 下午2:17:12
     * @param map
     * @return int    
	 */
	public int addAccountInfo(Map<String,Object> map){
		return this.getSessionTemplate().insert("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.addAccountInfo", map);
	}
	/**
	 * 
	 * @Description:修改 账户支付密码错误次数
     * @author: fengxin
     * @date: 2015年8月26日 下午4:25:42
     * @param map
     * @return int    
	 */
	public int udpateAccountPayPasswordErrorNO(Map<String,Object> map){
		return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.udpateAccountPayPasswordErrorNO", map);
	}
	/**
	 * 
	 * @Description: 重置用户支付密码错误次数
     * @author: fengxin
     * @date: 2015年8月26日 下午5:53:49
     * @param map
     * @return int    
	 */
	public int resetAccountPayPasswordErrorNO(Map<String,Object> map){
		return this.getSessionTemplate().update("com.gomeo2o.service.account.dao.impl.AccountInfoDaoImpl.resetAccountPayPasswordErrorNO", map);
	}
}
