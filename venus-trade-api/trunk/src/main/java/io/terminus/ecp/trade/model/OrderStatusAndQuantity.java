package io.terminus.ecp.trade.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderStatusAndQuantity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8476014692344219060L;
	/**
	 * 订单对应的状态
	 */
	private Integer status;
	
	/**
	 * 订单状态对应的数量
	 */
	private Integer quantity;

}
