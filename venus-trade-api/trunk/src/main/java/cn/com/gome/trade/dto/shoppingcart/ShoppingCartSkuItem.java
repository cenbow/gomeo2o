package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShoppingCartSkuItem implements Serializable {
	private static final long serialVersionUID = 342458430900756155L;

	private Long id;
	private String name;
	private ShoppingCartShopDto shop;
}
