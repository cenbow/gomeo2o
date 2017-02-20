package cn.com.gome.trade.dto.deliveryrejection;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeliveryRejectionWarehousingReq implements Serializable {
	private static final long serialVersionUID = 4026267130551500747L;
	private Long orderId;
	private Long orderDeliveryId;
	private Integer refundShippingCostType;
	private Integer refundShippingCost;

}
