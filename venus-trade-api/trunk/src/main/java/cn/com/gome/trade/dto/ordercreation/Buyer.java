package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

@Data
public class Buyer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5102410950294787662L;
	private Long id;
	private String name;
	private String mobile;
	private String outerUserId;
}
