package cn.com.gome.trade.dto.aftersalesorder;

import lombok.Data;

@Data
public class OrderRefundDetail {
	private String refundType; 				//退款类型
	private String agreeRefundTime;			//卖家操作退款的时间
	private String overTime;				//退款完成时间
	private String refundReturnType;	//退款返回方式
	private String agreeRefundAtTime;		//卖家操作退款的时间	
}
