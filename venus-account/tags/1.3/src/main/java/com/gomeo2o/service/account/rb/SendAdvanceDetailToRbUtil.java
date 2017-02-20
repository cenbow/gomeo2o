/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年8月12日 下午2:18:48
 */
package com.gomeo2o.service.account.rb;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.alibaba.dubbo.common.json.JSON;
import com.gomeo2o.utils.PropertiesUtil;

import lombok.extern.slf4j.Slf4j;


/**
 * @Description: 通过webservice发送提现流水到RB系统
 * @author: fengxin
 * @date: 2015年8月12日 下午2:18:48
 */
@Slf4j
public class SendAdvanceDetailToRbUtil {
	/**
	 * 
	 * @Description: TODO 
     * @author: fengxin
     * @date: 2015年8月12日 下午2:21:14
     * @param map
     * @return boolean    
	 */
	public static boolean sendAdvanceDetailToRb(Map<String,Object> map,String rbUrl){
		try {
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
			factory.setServiceClass(AcceptBalanceTask.class);
			factory.setAddress(rbUrl);
			AcceptBalanceTask client = (AcceptBalanceTask) factory.create();
			RefundBalanceTask refundBalanceTask = new RefundBalanceTask();
			refundBalanceTask.setAccountNo(map.get("cashCardnumber").toString());//卡号
			refundBalanceTask.setAccountName(map.get("advanceName").toString());//开户人姓名
			refundBalanceTask.setAmount(new BigDecimal(map.get("advanceValue").toString()).divide(new BigDecimal(100)).doubleValue());//金额
			refundBalanceTask.setBankName(map.get("bankName").toString());//可以为空
			refundBalanceTask.setRefundNo(map.get("detailNo").toString());//发送方业务编号  10之内
			refundBalanceTask.setBankCode(map.get("bankCode").toString());
			refundBalanceTask.setBuid(8840);
			RefundTaskReply r = client.acceptBalanceTask(refundBalanceTask);
			/*RefundTaskReply r = tat.acceptBalanceTask(refundBalanceTask);*/
			log.info("com.gomeo2o.service.account.rb.sendAdvanceDetailToRb,method return:{},method paramer:{}",JSON.json(r),JSON.json(refundBalanceTask));
			if(r.getReasonCode().equals("00")&&r.getState().equals("S")){
				return true;
			}
		} catch (Exception e) {
			log.error("com.gomeo2o.service.account.rb.sendAdvanceDetailToRb,method is error{},address", e,rbUrl);
		} 
		return false;
	}
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(AcceptBalanceTask.class);
		factory.setAddress(PropertiesUtil.getProProperties("rbUrl", null));
		AcceptBalanceTask client = (AcceptBalanceTask) factory.create();
		RefundBalanceTask refundBalanceTask = new RefundBalanceTask();
		
		refundBalanceTask.setAccountNo("62146800003041942");//卡号
		refundBalanceTask.setAccountName("fengxin1");//开户人姓名
		refundBalanceTask.setAmount(12.0);//金额
		refundBalanceTask.setBankName("中国银行");//可以为空
		refundBalanceTask.setRefundNo("101203120123123");//发送方业务编号  10之内
		refundBalanceTask.setBankCode("301");
		refundBalanceTask.setBuid(8840);
		RefundTaskReply r = client.acceptBalanceTask(refundBalanceTask);
		System.out.println(r.getReasonCode());
		/* 00=保存提现回信息成功 
		 * 01=保存提现信息信息失败，出异常了 
		 * 02=银行账号不能为空 
		 * 03=开户人不能为空
		 * 04=提现单号不能为空
		 * 05=销售渠道代码不能为空 
		 * 06=提现金
		 * 07=提现银行
		 */
	}

}
