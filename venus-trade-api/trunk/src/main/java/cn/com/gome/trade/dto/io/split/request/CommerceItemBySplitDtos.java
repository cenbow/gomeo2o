package cn.com.gome.trade.dto.io.split.request;

import java.io.Serializable;

public class CommerceItemBySplitDtos implements Serializable{

	private static final long serialVersionUID = 7764030650910861180L;

	private String productId; // 商品ID

	private String skuNo; // 商品SKU

	private String quantity; // 商品数量

	private String type; // 正常品类型

	private ItemPriceInfoBySplitDto itemPriceInfoDto = new ItemPriceInfoBySplitDto(); // 商品价格DTO

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSkuNo() {
		return skuNo;
	}

	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ItemPriceInfoBySplitDto getItemPriceInfoDto() {
		return itemPriceInfoDto;
	}

	public void setItemPriceInfoDto(ItemPriceInfoBySplitDto itemPriceInfoDto) {
		this.itemPriceInfoDto = itemPriceInfoDto;
	}

}
