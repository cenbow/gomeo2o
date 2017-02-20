package cn.com.gome.trade.dto.io.split.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShippingGroupDtos implements Serializable {

	private static final long serialVersionUID = 6736236596408431159L;

	private List<CommerceItemDtos> commerceItemDtos = new ArrayList<CommerceItemDtos>();  //商品信息
	
	private ShippingPriceInfoDto shippingPriceInfoDto = new ShippingPriceInfoDto();  //配送价格信息 运费

	public List<CommerceItemDtos> getCommerceItemDtos() {
		return commerceItemDtos;
	}

	public void setCommerceItemDtos(List<CommerceItemDtos> commerceItemDtos) {
		this.commerceItemDtos = commerceItemDtos;
	}

	public ShippingPriceInfoDto getShippingPriceInfoDto() {
		return shippingPriceInfoDto;
	}

	public void setShippingPriceInfoDto(
			ShippingPriceInfoDto shippingPriceInfoDto) {
		this.shippingPriceInfoDto = shippingPriceInfoDto;
	}
	
	
	
}
