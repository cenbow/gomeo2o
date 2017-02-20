/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午2:59:05
 */
package com.gomeo2o.service.account.biz;

import io.terminus.ecp.config.service.ConfigReadService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.kevinsawicki.http.HttpRequest;
import com.gomeo2o.common.page.PageBean;
import com.gomeo2o.common.page.PageParam;
import com.gomeo2o.facade.account.entity.AdvanceDetail;
import com.gomeo2o.facade.account.exception.AccountException;
import com.gomeo2o.service.account.dao.AccountInfoDao;
import com.gomeo2o.service.account.dao.AdvanceDetailDao;
import com.gomeo2o.service.account.dao.RebateDetailDao;
import com.gomeo2o.service.account.rb.SendAdvanceDetailToRbUtil;
import com.gomeo2o.service.account.rb.SendAdvanceDetailToSAPUtil;
import com.gomeo2o.utils.Constants;
import com.gomeo2o.utils.PropertiesUtil;

/**
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年4月30日 下午2:59:05
 */
@Slf4j
@Service("advanceDetailBiz")
public class AdvanceDetailBiz {
	
	@Autowired
	private AdvanceDetailDao advanceDetailDao;
	
	@Autowired
	private AccountInfoDao accountInfoDao;
	
	@Autowired
	private RebateDetailDao rebateDetailDao;
	
	@Autowired
	private ConfigReadService configReadService;
	
	/**
	 * 
	 * @Description: 修改提现流水状态
     * @author: fengxin
     * @date: 2015年4月30日 下午3:01:17
     * @param map
     * @return void    
     * @throws
	 */
	@Transactional
	public void updateAdvanceDetail(Map<String,Object> map){
		AdvanceDetail advanceDetail = advanceDetailDao.selectAdvanceDetailByParamer(map);
		//校验提现流水是否已经被处理为成功或者失败状态  如果已经处理则不再做处理！
		if(!Constants.ADVANCE_SUCCESS.equals(advanceDetail.getState().toString())&&!Constants.ADCANCE_ERROR.equals(advanceDetail.getState().toString())){
			if(advanceDetail!=null){
				int flag = 0 ,ad_flag=0;//提现账户金额扣除、提现流水状态
				boolean sap_flag = true;
				Map<String,Object> reqParam =  new HashMap<String,Object>();
				reqParam.put("accountType", Constants.REBATE_TYPE);
				reqParam.put("userId", advanceDetail.getUserId());
				reqParam.put("recordValue", advanceDetail.getAdvanceValue());
				//提现状态为成功
				if(Constants.ADVANCE_SUCCESS.equals(map.get("state").toString())){
					//扣减金额
					flag = accountInfoDao.editAccountInfo(reqParam);
				//提现状态为失败
				}else if(Constants.ADCANCE_ERROR.equals(map.get("state").toString())){
					//取消冻结金额
					flag = accountInfoDao.reSetfroozeAccountInfo(reqParam);
				}
				//账户扣减失败
				if(flag==0){
					throw AccountException.ADVANCE_ACCOUT_ERROR;
				//账户扣减成功  修改提现流水状态
				}else{
					map.put("recordValue", advanceDetail.getAdvanceValue());
					ad_flag = advanceDetailDao.updateAdvanceDetail(map);
					if(ad_flag==0){
						throw AccountException.ADVANCE_STATE_ERROR;
					}
					if(Constants.ADVANCE_SUCCESS.equals(map.get("state").toString())){
						//提现成功后推送SAP
						String soapUrl = "";
						try {
							soapUrl =configReadService.getByKey("account.sap.pi.url").getResult().getValue();
							sap_flag = SendAdvanceDetailToSAPUtil.sendSOAPWithAdvanceDetail(advanceDetailDao.selectAdvanceDetailByParamer(map),soapUrl);
						} catch (Exception e) {
							log.error("提现流水：{},推送SAP异常！{},地址为：{}",advanceDetail.getDetailNo(),e,soapUrl);
						}
						if(!sap_flag){
							log.error("提现流水：{},推送SAP失败！地址为：",advanceDetail.getDetailNo(),soapUrl);
						}
					}
					
				}
			}else{
				throw AccountException.BUDGET_NOLL_ERROE;
			}
		}
	}
	/**
	 * 
	 * @Description: 增加提现流水
     * @author: fengxin
     * @date: 2015年4月30日 下午3:02:36
     * @param map
     * @return void    
     * @throws
	 */
	@Transactional
	public void addAdvanceDetail(Map<String,Object> map){
		Map<String,Object> accMap  = new HashMap<String,Object>();
		accMap.put("recordValue", map.get("advanceValue"));
		accMap.put("userId", map.get("userId"));
		accMap.put("accountType", 3);
		//调用账户冻结需要提现的金额
		int accFlag = accountInfoDao.froozeAccountInfo(accMap);
		if(accFlag>0){
			//增加提现流水
			map.remove("recordValue");
			int flag = advanceDetailDao.addAdvanceDetail(map);
			if(flag>0){
				String rbUrl = configReadService.getByKey("account.rb.url").getResult().getValue();
				//发送数据到RB
				boolean state = SendAdvanceDetailToRbUtil.sendAdvanceDetailToRb(map,rbUrl);
				if(!state){
					throw AccountException.ADVANCE_RB_ERROR;
				}
			}else{
				throw AccountException.ADVANCE_DETAIL_ERROR;
			}
		}else{
			throw AccountException.EXCEED_BALANCE;
		}
	}
	/**
	 * 
	 * @Description: 查询提现流水 分页 条件
     * @author: fengxin
     * @date: 2015年4月30日 下午4:43:20
     * @param reqParam
     * @param pageParam
     * @return List<AdvanceDetail>    
	 */
	public PageBean queryAdvanceDetailByParamer(Map<String,Object> reqParam,PageParam pageParam){
		return this.advanceDetailDao.listPage(pageParam, reqParam);
	}
	/**
	 * 
	 * @Description: 根据ID查询提现流水
     * @author: fengxin
     * @date: 2015年5月9日 下午3:22:11
     * @param id
     * @return AdvanceDetail    
	 */
	public AdvanceDetail queryAdvanceDetailById(long id){
		return this.advanceDetailDao.getById(id);
	}
	
	/**
	 * 
	 * @Description: 发送提现流水数据到SAP
     * @author: fengxin
     * @date: 2015年5月26日 上午11:38:55
     * @return boolean
	 */
	public boolean sendSOAPWithAdvanceDetail(AdvanceDetail advanceDetail){
		log.debug("提现流水推送SAP：{}",advanceDetail.getDetailNo());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("detailNo", advanceDetail.getDetailNo());//查询打款成功的
		advanceDetail = advanceDetailDao.selectAdvanceDetailByParamer(map);
		if(advanceDetail!=null){
			StringBuffer strb = new StringBuffer();
			strb.append("<?xml version='1.0' encoding='UTF-8'?><ns0:MT_FI_Req xmlns:ns0='http://gome.com/ACC/FI/Outbound'><HEADER>");
			strb.append("<INTERFACE_ID>FI008</INTERFACE_ID>");
			strb.append("<MESSAGE_ID>"+UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()+"</MESSAGE_ID>");
			strb.append("<SENDER>ACC</SENDER>");
			strb.append("<RECEIVER>ECC</RECEIVER>");
			strb.append("<DTSEND>"+new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date())+"</DTSEND>");
			strb.append("</HEADER><XML_DATA><FI008><ITEMS>");
			strb.append("<ITEM>");
			strb.append("<detail_no>B01"+advanceDetail.getDetailNo()+"</detail_no>");
			strb.append("<success_time>"+new SimpleDateFormat("yyyyMMdd").format(advanceDetail.getSuccessTime())+"</success_time>");
			strb.append("<record_value>"+advanceDetail.getRecordValue().toString()+"</record_value>");
			strb.append("<cash_fee></cash_fee>");
			strb.append("<advance_remark>"+advanceDetail.getAdvanceRemark()+"</advance_remark>");
			strb.append("<state>"+advanceDetail.getState()+"</state>");
			strb.append("<create_time>"+new SimpleDateFormat("yyyyMMdd").format(advanceDetail.getCreateTime())+"</create_time>");
			strb.append("</ITEM>");
			strb.append("</ITEMS></FI008></XML_DATA></ns0:MT_FI_Req>");
			log.debug("reqXml={}",strb.toString());
			String respXml = HttpRequest.post(PropertiesUtil.getProProperties("soapUrl", null)).send(strb.toString()).body();
			log.debug("提现流水推送SAP：{},报文为:{}",advanceDetail.getDetailNo(),respXml);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @Description: 根据SAP返回的结果 ，修改流水凭证号 
     * @author: fengxin
     * @date: 2015年6月3日 下午4:08:28
     * @param 
     * @return void
	 */
	public void updateAdvanceDetailVoucher(Map<String,Object> reqParam){
		this.advanceDetailDao.updateAdvanceDetailVoucher(reqParam);
	}
}
