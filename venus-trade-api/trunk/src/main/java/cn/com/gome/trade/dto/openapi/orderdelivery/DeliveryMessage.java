package cn.com.gome.trade.dto.openapi.orderdelivery;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeliveryMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8853986178779410959L;

	private String message;
	private Long time;
}
