package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class O2MOrderInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3454080004194402813L;
	private List<Long> orderIds;  //O2M主订单ID，是提交订单成功后返回的O2M主订单ID int 64 
	private List<Long> subOrderIds; //O2M子订单ID，是提交订单成功后返回的O2M子订单ID  int 64 
}
