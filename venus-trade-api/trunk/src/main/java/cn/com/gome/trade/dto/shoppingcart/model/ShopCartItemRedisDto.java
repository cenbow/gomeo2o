/**
 * Copyright (c) 2016 美信网络技术有限公司
 */
package cn.com.gome.trade.dto.shoppingcart.model;

import java.io.Serializable;

public class ShopCartItemRedisDto implements Serializable {
	private static final long serialVersionUID = -1960947424109423702L;
	private Long id;      		// 主键id
	private Long skuId;      	// skuId
	private String kId;			// 返利链条id
	private String shopId;		// 美店id
	private Integer proNum;		// 商品数量
	private String addTime;		// 增加日期
	private String sourceCode;	// 商品来源码
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public String getkId() {
		return kId;
	}
	public void setkId(String kId) {
		this.kId = kId;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public Integer getProNum() {
		return proNum;
	}
	public void setProNum(Integer proNum) {
		this.proNum = proNum;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
}
