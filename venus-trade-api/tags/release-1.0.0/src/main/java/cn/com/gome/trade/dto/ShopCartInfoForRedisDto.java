/**
 * 
 */
package cn.com.gome.trade.dto;

import java.io.Serializable;


public class ShopCartInfoForRedisDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1960947424109423702L;
	
	private Long skuId;
	private String kId;
	private String shopId;
	private Integer proNum;
	private String addTime;
	
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
	@Override
	public String toString() {
		return "ShopCartInfoForRedisDto [skuId=" + skuId + ", kId=" + kId
				+ ", shopId=" + shopId + ", proNum=" + proNum + ", addTime="
				+ addTime + "]";
	}
}
