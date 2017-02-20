package cn.com.gome.trade.dto.shoppingcart;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class ShoppingCartItemReq implements Serializable {
	private static final long serialVersionUID = 5592740657524815423L;
	
	private Long mshopId;
	private String kid;
	private Long skuId;
	private Integer quantity;
	private String sourceCode;//商品来源
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
