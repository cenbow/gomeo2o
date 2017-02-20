package io.terminus.ecp.trade.model;

import java.io.Serializable;
import java.util.List;


public class OrderItemSubjoin implements Serializable {
	
	private static final long serialVersionUID = -4624089415212212651L;
	
	/**
	 * SKU的销售属性
	 */
	private String attributeKey1;
	private String attributeName1;
	private String attributeKey2;
	private String attributeName2;
	
	/**
	 * @description : sku销售属性list
	 * @updatet     : 2016-12-21  
	 * */
	private List<ItemAttribute> attributes;
	
	/**
	 * 活动时的商品价格
	 */
	private Integer skuPrice;
	/**
	 * 商品折扣的金额
	 */
	private Integer discount;
	
	
	public String getAttributeKey1() {
		return attributeKey1;
	}
	public void setAttributeKey1(String attributeKey1) {
		this.attributeKey1 = attributeKey1;
	}
	public String getAttributeName1() {
		return attributeName1;
	}
	public void setAttributeName1(String attributeName1) {
		this.attributeName1 = attributeName1;
	}
	public String getAttributeKey2() {
		return attributeKey2;
	}
	public void setAttributeKey2(String attributeKey2) {
		this.attributeKey2 = attributeKey2;
	}
	public String getAttributeName2() {
		return attributeName2;
	}
	public void setAttributeName2(String attributeName2) {
		this.attributeName2 = attributeName2;
	}
	public Integer getSkuPrice() {
		return skuPrice;
	}
	public void setSkuPrice(Integer skuPrice) {
		this.skuPrice = skuPrice;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public List<ItemAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<ItemAttribute> attributes) {
		this.attributes = attributes;
	}

}
