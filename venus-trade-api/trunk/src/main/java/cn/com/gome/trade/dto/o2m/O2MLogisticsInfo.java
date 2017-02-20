package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;

@Data
public class O2MLogisticsInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3426246875837462901L;
	//状态流水号，不会重复   int 64
	private Long statusSeq;
	//O2M子订单ID，是提交订单成功后返回的O2M主订单ID int 64
	private Long subOrderId;
	//序号 smallint 16
	private Integer inx;
	//状态发生时间 yyyy-mm-dd 24h:mm:ss  String 19
	private String statusTime;
	//物流状态信息  string 255
	private String message;
}
