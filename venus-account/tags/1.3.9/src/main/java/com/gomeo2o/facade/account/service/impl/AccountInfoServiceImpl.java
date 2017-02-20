package com.gomeo2o.facade.account.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






import com.alibaba.dubbo.common.json.JSON;
import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AccountInfo;
import com.gomeo2o.facade.account.entity.CouponInfo;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.facade.account.service.AccountInfoFacade;
import com.gomeo2o.facade.account.utils.ValidateMapService;
import com.gomeo2o.service.account.biz.AccountInfoBiz;
import com.gomeo2o.service.account.biz.CouponInfoBiz;
import com.gomeo2o.service.account.biz.VirtualTotalInfoBiz;
import com.gomeo2o.utils.Constants;
/**
 * @Description:账户管理接口实现
 * @author:gongjiaming
 * @date: 2015年4月17日
 */
@Slf4j
@Service("accountInfoFacade")
public class AccountInfoServiceImpl implements AccountInfoFacade {
	
	@Autowired
	private AccountInfoBiz accountInfoBiz;
	
	@Autowired
	private CouponInfoBiz couponInfoBiz;
	
	@Autowired
	private VirtualTotalInfoBiz virtualTotalInfoBiz;
	/**
	 * 
	 * @Description: 获取用户业务操作唯一号
     * @author: fengxin
     * @date: 2015年5月23日 下午5:04:45
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> createUserOperateNO(Map<String, Object> reqParam){
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		List<String> mustList =  new ArrayList<String>();
		mustList.add("userId");
		ValidateMapService.validate(reqParam,mustList);
		rcs.setBusinessObj(reqParam.get("userId")+""+new Date().getTime());
		return rcs;
	}
	/**
	 * @Description: 账户增加，充值等
	 * @author: gongjiaming
	 * @date: 2015年4月17日 上午11:07:46
	 * @param reqParam
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> addAccountInfo(Map<String, Object> reqParam) {
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		reqParam.put("detailNo", Constants.getRebateDetailNo());
		accountInfoBiz.addAccountInfo(reqParam);
		return rcs;
	}
	/**
	 * @Description: 账户增加，充值等 批量
	 * @author: gongjiaming
	 * @date: 2015年4月17日 上午11:07:46
	 * @param reqList
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> addAccountInfo(List<Map<String, Object>> reqList) {
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		if(reqList!=null&&reqList.size()>0){
			for (int i = 0; i < reqList.size(); i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				map = reqList.get(i);
				ValidateMapService.validate(map);
				map.put("detailNo", Constants.getRebateDetailNo());
				accountInfoBiz.addAccountInfo(map);
			}
		}else{
			throw AccountException.REQLIST_ERROE;
		}
		return rcs;
	}
	
	/**
	 * @Description: 账户减少，消费等
	 * @author: gongjiaming
	 * @date: 2015年4月17日 上午11:07:46
	 * @param reqParam
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> editAccountInfo(Map<String, Object> reqParam) {
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		if(accountInfoBiz.checkTwiceBuiness(reqParam)){
			reqParam.put("detailNo", Constants.getRebateDetailNo());
			accountInfoBiz.editAccountInfo(reqParam);
		}
		return rcs;
	}

	/**
	 * @Description: 冻结账户余额
	 * @author: gongjiaming
	 * @date: 2015年4月17日 上午11:07:46
	 * @param reqParam
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> froozeAccountInfo(Map<String, Object> reqParam) {
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		if(accountInfoBiz.checkTwiceBuiness(reqParam)){
			reqParam.put("detailNo", Constants.getRebateDetailNo());
			accountInfoBiz.froozeAccountInfo(reqParam);
		}
		return rcs;
	}
	/**
	 * 
	 * @Description: 撤销账户冻结积分，返利余额，现金余额
     * @author: fengxin
     * @date: 2015年7月1日 下午8:33:46
     * @param reqParam
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> reSetfroozeAccountInfo(Map<String, Object> reqParam) {
		CommonResultEntity<String> rcs = new CommonResultEntity<String>();
		ValidateMapService.validate(reqParam);
		if(accountInfoBiz.checkTwiceBuiness(reqParam)){
			reqParam.put("detailNo", Constants.getRebateDetailNo());
			accountInfoBiz.reSetfroozeAccountInfo(reqParam);
		}
		return rcs;
	}
	/**
	 * 
	 * @Description: 用户资产查询
     * @author: fengxin
     * @date: 2015年4月30日 上午10:46:00
     * @param reqParam
     * @return CommonResultEntity<Map<String,Object>>
	 */
	public CommonResultEntity<Map<String,Object>> queryVirAssetsSumByParamer(Map<String, Object> reqParam){
		CommonResultEntity<Map<String,Object>> rcs = new CommonResultEntity<Map<String,Object>>();
		//构造查询参数
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setUserId(Long.valueOf(reqParam.get("userId").toString()));
		CouponInfo couponInfo = new CouponInfo();
		couponInfo.setUserId(Long.valueOf(reqParam.get("userId").toString()));
		//查询账户积分余额和返利余额
		accountInfo = accountInfoBiz.queryAccountInfoByParamer(accountInfo);
		//查询账户平台红包和店铺红包
		Map<String,Object> map = this.couponInfoBiz.queryCouponTotalByParamer(couponInfo);
		//拼接返回参数
		map.put("rebateBa", accountInfo.getRebateBa());
		map.put("scoreBa", accountInfo.getScoreBa());
		rcs.setBusinessObj(map);
		return rcs;
	}
	/**
	 * 
	 * @Description: 后台用户资产列表查询
     * @author: fengxin
     * @date: 2015年5月6日 下午5:11:48
     * @param map
     * @return CommonResultEntity<PageBean>
	 */
	public CommonResultEntity<PageBean> queryVirAssetsListByParamer(Map<String,Object> map){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(this.accountInfoBiz.queryVirAssetsListByParamer((PageParam) map.get("pageParam"), map));
		return crs;
		
	}
	/**
	 * 
	 * @Description: 根据参数查询账户信息
     * @author: fengxin
     * @date: 2015年5月8日 下午2:13:22
     * @param map
     * @return CommonResultEntity<AccountInfo>    
	 */
	public CommonResultEntity<AccountInfo> queryAccountInfoByParamer(Map<String,Object> map){
		CommonResultEntity<AccountInfo> crs = new CommonResultEntity<AccountInfo>();
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setUserId(Long.valueOf(map.get("userId").toString()));
		crs.setBusinessObj(this.accountInfoBiz.queryAccountInfoByParamer(accountInfo));
		return crs;
		
	}
	/**
	 * 
	 * @Description: 查询账户的收支明细(app)
     * @author: fengxin
     * @date: 2015年5月9日 下午2:14:23
     * @param pageParam
     * @param map
     * @return CommonResultEntity<PageBean>    
	 */
	public CommonResultEntity<PageBean> queryBalancePayMentsVoByParamer(PageParam pageParam,Map<String,Object> map){
		CommonResultEntity<PageBean> crs = new CommonResultEntity<PageBean>();
		crs.setBusinessObj(this.accountInfoBiz.queryBalancePayMentsVoByParamer(pageParam, map));
		return crs;
	}
	/**
	 * 
	 * @Description: 为用户修改支付密码
     * @author: fengxin
     * @date: 2015年5月23日 上午11:45:03
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> updateUserPayPassWord(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		List<String> mustList= new ArrayList<String>();
		mustList.add("userId");
		mustList.add("payPassword");
		ValidateMapService.validate(map, mustList);
		this.accountInfoBiz.updateUserPayPassWord(map);
		return crs;
	}
	/**
	 * 
	 * @Description: 创建用户(会员同步)
     * @author: fengxin
     * @date: 2015年5月27日 下午3:15:45
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> createAccountInfo(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		try {
			if(map.get("userId")==null||"".equals(map.get("userId"))){
				throw AccountException.REQLIST_ERROE.newInstance("%s", "传入参数userId为空");
			}
			this.accountInfoBiz.createAccountInfo(map);
		} catch (Exception e) {
			try {
				log.error("账户信息：{}，同步失败{}",JSON.json(map),e);
			} catch (IOException e1) {
				log.error("账户信息同步参数为空{}",e);
			}
		}
		return crs;
	}
	/**
	 * 
	 * @Description: 校验支付密码
     * @author: fengxin
     * @date: 2015年5月27日 下午7:30:56
     * @param map
     * @return CommonResultEntity<String>    
	 */
	public CommonResultEntity<String> checkUserPayPassword(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		List<String> mustList= new ArrayList<String>();
		mustList.add("userId");
		mustList.add("payPassword");
		ValidateMapService.validate(map, mustList);
		if (this.accountInfoBiz.checkUserPayPassword(map)) {
			crs.setBusinessObj("true");
		}else{
			crs.setBusinessObj("false");
		}
		return crs;
	}
	/**
	 * 
	 * @Description: 重置用户支付密码错误次数
     * @author: fengxin
     * @date: 2015年8月26日 下午5:53:49
     * @param map
     * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> resetAccountPayPasswordErrorNO(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		this.accountInfoBiz.resetAccountPayPasswordErrorNO(map);
		return crs;
	}
	/**
	 * @Description 获取用户可交易的国美币额度（未超过交易限制）
	 * @author fengxin
	 * @date 2015年11月18日 下午12:10:38
	 * @param map
	 * @return CommonResultEntity<BigDecimal>
	 */
	public CommonResultEntity<BigDecimal> queryUseableVirtualByParamer (Map<String,Object> map){
		CommonResultEntity<BigDecimal> crs = new CommonResultEntity<BigDecimal>();
		crs.setBusinessObj(this.virtualTotalInfoBiz.queryUseableVirtualByParamer(map));
		return crs;
	}
	/**
	 * @Description 检测用户当前交易国美币是否超过限额
	 * @author fengxin
	 * @date 2015年11月20日 上午10:35:10
	 * @param map
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String> checkUserVirtualLimit(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		virtualTotalInfoBiz.checkUserVirtualLimit(map);
		return crs;
	}
	/**
	 * @Description 消减用户交易使用的国美币限额
	 * @author fengxin
	 * @date 2015年11月25日 下午4:55:34
	 * @param map
	 * @return CommonResultEntity<String>
	 */
	public CommonResultEntity<String>  resetUserVirtualLimit(Map<String,Object> map){
		CommonResultEntity<String> crs = new CommonResultEntity<String>();
		virtualTotalInfoBiz.resetUserVirtualLimit(map);
		return crs;
	}
	
}
