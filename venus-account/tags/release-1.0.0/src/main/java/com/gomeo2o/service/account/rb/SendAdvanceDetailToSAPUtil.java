/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年8月12日 下午2:18:48
 */
package com.gomeo2o.service.account.rb;

import io.terminus.ecp.config.service.ConfigReadService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.json.JSON;
import com.github.kevinsawicki.http.HttpRequest;
import com.gomeo2o.facade.account.entity.AdvanceDetail;
import com.gomeo2o.utils.PropertiesUtil;

import lombok.extern.slf4j.Slf4j;


/**
 * @Description: 通过Http发送提现成功流水到SAP
 * @author: fengxin
 * @date: 2015年8月12日 下午2:18:48
 */
@Slf4j
public class SendAdvanceDetailToSAPUtil {
	
	@Autowired
	private ConfigReadService configReadService;
	/**
	 * 
	 * @Description: 通过Http发送提现成功流水到SAP
     * @author: fengxin
     * @date: 2015年8月12日 下午2:21:14
     * @param map
     * @return boolean    
	 */
	public static boolean sendSOAPWithAdvanceDetail(AdvanceDetail advanceDetail,String soapUrl){
		try {
			log.info("AdvanceDetail is ：{} ",JSON.json(advanceDetail));
		} catch (IOException e1) {
			log.error("JSON error{}",e1);
		}
		if(advanceDetail!=null){
			StringBuffer strb = new StringBuffer();
			try {
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
				strb.append("<advance_remark>提现成功</advance_remark>");
				strb.append("<state>"+advanceDetail.getState()+"</state>");
				strb.append("<create_time>"+new SimpleDateFormat("yyyyMMdd").format(advanceDetail.getCreateTime())+"</create_time>");
				strb.append("</ITEM>");
				strb.append("</ITEMS></FI008></XML_DATA></ns0:MT_FI_Req>");
				log.info("sap xml is :{},soapUrl is {}",strb.toString(),PropertiesUtil.getProProperties("soapUrl", null));
				int message = HttpRequest.post(soapUrl).send(strb.toString()).code();
				log.info("HttpRequest message is  :{}",message);
			} catch (Exception e) {
				try {
					log.error("AdvanceDetail：{} ,sendSAP error！message ：{}",JSON.json(advanceDetail),e);
				} catch (IOException e1) {
					log.error("JSON error{}",e1);
				}
			}
				log.info("AdvanceDetail sendSAP success！DetailNo is :{}",advanceDetail.getDetailNo());
			
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String url = "http://10.125.31.47:50000/sap/xi/adapter_plain?namespace=http://gome.com/ACC/FI/Outbound&interface=SI_FI_Out_Asy&service=BS_ACC&party=&agency=&scheme=&QOS=EO&sap-user=ACCUSER&sap-password=ACCUSER&sap-client=001&sap-language=EN";
		int code  = HttpRequest.post(url).send("<?xml version='1.0' encoding='UTF-8'?><ns0:MT_FI_Req xmlns:ns0='http://gome.com/ACC/FI/Outbound'><HEADER><INTERFACE_ID>FI008</INTERFACE_ID><MESSAGE_ID>876E46CF7DB94060B8FE083078837D55</MESSAGE_ID><SENDER>ACC</SENDER><RECEIVER>ECC</RECEIVER><DTSEND>20151119064927812</DTSEND></HEADER><XML_DATA><FI008><ITEMS><ITEM><detail_no>B014201511190000072</detail_no><success_time>20151120</success_time><record_value>800.0000</record_value><cash_fee></cash_fee><advance_remark>提现成功</advance_remark><state>4</state><create_time>20151119</create_time></ITEM></ITEMS></FI008></XML_DATA></ns0:MT_FI_Req>").code();
		System.out.println("fsafda");
	}
}
