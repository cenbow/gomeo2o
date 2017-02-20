package io.terminus.ecp.trade.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MergerOrderItemDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long orderItemsId;
	
	private Integer originPrice;
	
	private Integer price;
	
	private String itemImage;
	
	private String itemName;
	
	private Integer quantity;
	
	private String attribute;
}
