package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrdersResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7324494894569190515L;
	/**
	 * 订单列表
	 */
	private List<Order> orders;

}
