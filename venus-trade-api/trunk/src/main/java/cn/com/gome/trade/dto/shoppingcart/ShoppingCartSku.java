package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import cn.com.gome.trade.dto.common.AttributeDto;

@Data
public class ShoppingCartSku implements Serializable {
	private static final long serialVersionUID = 342458430900756155L;

	private Long id;            			// skuId
	private String image;					// 图片地址
	private List<AttributeDto> attributes; 	// 销售属性
	private Integer price;					// sku价格
	private Integer stock;					// 销量
	private Integer status;					// 商品状态1:上架, -1:下架
	private ShoppingCartSkuItem item;		// item
	private Integer tax;					// 税率，海外购商品
}
