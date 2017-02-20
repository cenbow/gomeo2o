package cn.com.gome.trade.dto.deliveryorder;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrdersResp implements Serializable {
	private static final long serialVersionUID = -4118664957637049958L;
	
	private List<DeliveryOrder> orders;  		//订单列表
	private Long total;            				//总订单数

}
