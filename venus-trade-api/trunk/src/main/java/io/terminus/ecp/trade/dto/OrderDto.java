package io.terminus.ecp.trade.dto;


import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8096784422598154618L;
	
	private Long orderId;
	
	private Integer orderFee;
	
	private List<MergerOrderItemDto> items;
}
