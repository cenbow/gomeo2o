/**
 * @类名: AreaProductAvailableDetailDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月13日 下午6:20:16
 */
package cn.com.gome.trade.dto.io.product.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午6:20:16
 */
public class AreaProductAvailableDetailDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String partNum; //商品编码

	private String itemFlag; //商品库区可卖属性

	private String category; //类别

	private String status; //状态  是否可卖

	private String advanceBookFlag; //预售标识

	private String productState;  //商品状态

	private String skuState; //SKU状态

	private String onSale; //上下架状态

	/**
	 * @return the partNum
	 */
	public String getPartNum() {
		return partNum;
	}

	/**
	 * @param partNum
	 *            the partNum to set
	 */
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	/**
	 * @return the itemFlag
	 */
	public String getItemFlag() {
		return itemFlag;
	}

	/**
	 * @param itemFlag
	 *            the itemFlag to set
	 */
	public void setItemFlag(String itemFlag) {
		this.itemFlag = itemFlag;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the advanceBookFlag
	 */
	public String getAdvanceBookFlag() {
		return advanceBookFlag;
	}

	/**
	 * @param advanceBookFlag
	 *            the advanceBookFlag to set
	 */
	public void setAdvanceBookFlag(String advanceBookFlag) {
		this.advanceBookFlag = advanceBookFlag;
	}

	/**
	 * @return the productState
	 */
	public String getProductState() {
		return productState;
	}

	/**
	 * @param productState
	 *            the productState to set
	 */
	public void setProductState(String productState) {
		this.productState = productState;
	}

	/**
	 * @return the skuState
	 */
	public String getSkuState() {
		return skuState;
	}

	/**
	 * @param skuState
	 *            the skuState to set
	 */
	public void setSkuState(String skuState) {
		this.skuState = skuState;
	}

	/**
	 * @return the onSale
	 */
	public String getOnSale() {
		return onSale;
	}

	/**
	 * @param onSale
	 *            the onSale to set
	 */
	public void setOnSale(String onSale) {
		this.onSale = onSale;
	}

}
