package cn.com.gome.trade.service.shopcart;

import io.terminus.pampas.common.Response;
import cn.com.gome.trade.dto.common.CommonBase;
import cn.com.gome.trade.dto.shoppingcart.ShoppingCartDeleteReq;
import cn.com.gome.trade.dto.shoppingcart.ShoppingCartReq;
import cn.com.gome.trade.dto.shoppingcart.ShoppingCartResp;
import cn.com.gome.trade.dto.shoppingcart.ShoppingCartUpdateReq;

public interface GomeShoppingCartService {
	/**
	 * 获取用户购物车列表
	 * @param base
	 * @param shoppingCartReq
	 * @return
	 */
	Response<ShoppingCartResp> getUserShoppingCartItems(CommonBase base, ShoppingCartReq shoppingCartReq);
	
	/**
	 * 更新购物车商品数量
	 * @param base
	 * @param shoppingCartUpdateReq
	 * @return
	 */
	Response<Boolean> updateUserShoppingCartItem(CommonBase base, ShoppingCartUpdateReq shoppingCartUpdateReq);
	
	/**
	 * 删除购物车商品
	 * @param base
	 * @param shoppingCartDeleteReq
	 * @return
	 */
	Response<Boolean> deleteUserShoppingCartItem(CommonBase base, ShoppingCartDeleteReq shoppingCartDeleteReq);
	
	/**
	 * 获取购物车商品数量
	 * @param base
	 * @return
	 */
	Response<Integer> getShoppingCartItemQuantity(CommonBase base);	
	
}
