package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShoppingCartUpdateReq implements Serializable {
	private static final long serialVersionUID = -4659533307701557666L;
	private Long mshopId;			// 美店id
	private String kid;				// 返利链条id
	private Long skuId;				// skuId
	private Integer quantity;		// 修改数量
	private String sourceCode;		// 来源码
	private Integer type;			// 类型1:增加,2:修改
	private Long addressId;			// 地址id  三级地址

}
