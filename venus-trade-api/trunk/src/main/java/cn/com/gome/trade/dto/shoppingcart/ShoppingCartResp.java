package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ShoppingCartResp implements Serializable {
	private static final long serialVersionUID = -4091628932657224998L;
	
	private Long addressId;
	private List<ShoppingCartItem> shopingCartItems = new ArrayList<ShoppingCartItem>();
}
