package cn.com.gome.trade.dto.io.split.response;

import java.io.Serializable;

public class CommerceItemDtos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productId;  //商品id
	 
	private String skuNo;  //商品SKU
	
	private String quantity;  //商品数量
	
	private String type;  //正常品或赠品  正常品（ZSP）或赠品(ZZP)
	
	private String inStock;  //该商品是否有货  该商品是否有货1 缺货,2商品有货

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

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}
	
	
}
