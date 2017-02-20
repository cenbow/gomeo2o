package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

@Data
public class Seller implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5277948859940356527L;
	private Long id;
	private String name;
}
