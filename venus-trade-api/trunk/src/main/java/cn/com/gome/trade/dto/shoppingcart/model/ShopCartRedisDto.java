/**
 * Copyright (c) 2016 美信网络技术有限公司
 */
package cn.com.gome.trade.dto.shoppingcart.model;

import java.io.Serializable;
import java.util.List;

public class ShopCartRedisDto implements Serializable {
	private static final long serialVersionUID = -1960947424109423702L;
	private Long addressId;							// 地址id 三级地址
	private List<ShopCartItemRedisDto> cartItems;	// 购物车商品行	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public List<ShopCartItemRedisDto> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<ShopCartItemRedisDto> cartItems) {
		this.cartItems = cartItems;
	}
	
}
