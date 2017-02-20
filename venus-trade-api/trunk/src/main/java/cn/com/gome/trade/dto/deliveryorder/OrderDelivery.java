package cn.com.gome.trade.dto.deliveryorder;

import java.util.List;

import lombok.Data;

@Data
public class OrderDelivery {
	private Long id;
	private Integer status;
	private String statusDesc;
	private List<DeliveryOrderItem> orderItems;

}
