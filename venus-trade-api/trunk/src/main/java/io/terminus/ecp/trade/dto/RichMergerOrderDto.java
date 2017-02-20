package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.MergerOrder;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/***
 * 总订单级别
 * @author tangfeng
 */

@Data
public class RichMergerOrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2590234670262294034L;
	
	/**
	 * 总订单
	 */
	private MergerOrder mergerOrder;
	
	/**
	 * 订单
	 */
	private List<RichOrder> richOrder;
	
}
