package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;

import lombok.Data;
import cn.com.gome.trade.dto.common.MshopDto;

@Data
public class ShoppingCartItem implements Serializable {
	private static final long serialVersionUID = 3148575950708536491L;
	
	private ShoppingCartSku sku; //sku信息
	private Integer quantity;  //sku数量
	private MshopDto mshop;  //美店
	private String id;     //购物车删除主键
	private String kid;    //返利链条id
	private Boolean hasCoupon; //
	private String sourceCode;//商品来源
}
