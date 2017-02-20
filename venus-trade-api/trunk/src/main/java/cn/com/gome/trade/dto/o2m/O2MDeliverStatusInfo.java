package cn.com.gome.trade.dto.o2m;


import java.io.Serializable;

import lombok.Data;

@Data
public class O2MDeliverStatusInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5777711525811580410L;
	private Long subOrderId; //O2M子订单ID，是提交订单成功后返回的O2M子订单ID  int 64
	private String statusTime;// 状态发生时间 yyyy-mm-dd 24h:mm:ss   string 19
	private String carrierName;//承运商名称  string 64
	private String deliveryBillNo; //快递单号 string 64
}
