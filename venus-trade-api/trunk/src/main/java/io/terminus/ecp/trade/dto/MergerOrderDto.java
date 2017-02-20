package io.terminus.ecp.trade.dto;



import java.io.Serializable;
import java.util.List;

import lombok.Data;

/***
 * 总订单级别
 * @author zhanglinlin
 *
 */
@Data
public class MergerOrderDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2471761487373749403L;
	
	
	private Long mergerId;
	
	private Integer mergerFee;
	
	private List<OrderDto> orders;
	
}
