package cn.com.gome.trade.dto.io.split.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShippingGroupBySplitDtos implements Serializable {

	private static final long serialVersionUID = -8003999490004045491L;

	private ShippingPriceInfoBySplitDto shippingPriceInfoDto = new ShippingPriceInfoBySplitDto(); // 配送价格信息

	private List<CommerceItemBySplitDtos> commerceItemDtos = new ArrayList<CommerceItemBySplitDtos>(); // 封装商品信息

	private ShippingAddressBySplitDto shippingAddressDto = new ShippingAddressBySplitDto(); // 配送地址信息

	public ShippingPriceInfoBySplitDto getShippingPriceInfoDto() {
		return shippingPriceInfoDto;
	}

	public void setShippingPriceInfoDto(
			ShippingPriceInfoBySplitDto shippingPriceInfoDto) {
		this.shippingPriceInfoDto = shippingPriceInfoDto;
	}

	public List<CommerceItemBySplitDtos> getCommerceItemDtos() {
		return commerceItemDtos;
	}

	public void setCommerceItemDtos(
			List<CommerceItemBySplitDtos> commerceItemDtos) {
		this.commerceItemDtos = commerceItemDtos;
	}

	public ShippingAddressBySplitDto getShippingAddressDto() {
		return shippingAddressDto;
	}

	public void setShippingAddressDto(
			ShippingAddressBySplitDto shippingAddressDto) {
		this.shippingAddressDto = shippingAddressDto;
	}

}
