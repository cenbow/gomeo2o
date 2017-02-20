package cn.com.gome.trade.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TradeUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6284489416695112235L;
	
	private Long sellerId;
	private Integer userType;

}
