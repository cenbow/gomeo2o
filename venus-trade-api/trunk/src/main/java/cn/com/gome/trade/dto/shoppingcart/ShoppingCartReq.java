package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShoppingCartReq implements Serializable {
	private static final long serialVersionUID = -6686187581808125123L;
	
	private Long addressId;
	
}
