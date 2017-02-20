package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShoppingCartShopDto implements Serializable {
	private static final long serialVersionUID = -2915228315272310771L;
	
	private Long id;			// 店铺id
	private String name;		// 店铺名称
	private Integer type;		// 店铺类型1:xpop,2:o2m,3:在线自营,4:在线联营,42:海外购自营,43:海外购联营
	private Integer limitation;	// 店铺限额

}
