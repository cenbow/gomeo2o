package cn.com.gome.trade.dto.deliveryorder;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrdersReq implements Serializable {
	private static final long serialVersionUID = -4118664957637049958L;
	private Integer orderStatus;
	private Integer hasComment;
	private String integrity;
	private Long mshopId;
	private Long startAt;
	private Long endAt;
	private Long orderId;

}
