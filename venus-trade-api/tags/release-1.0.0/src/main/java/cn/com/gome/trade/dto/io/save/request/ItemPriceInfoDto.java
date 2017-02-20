/**   
 * @Title: ItemPriceInfoDto.java 
 * @Package com.gomeo2o.facade.order.vo 
 * @Description: TODO
 * @author: liupeiqi 
 * @date 2015年3月27日 上午11:04:16 
 * @version V1.0   
 */

package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;

/**
 * @ClassName: ItemPriceInfoDto
 * @Description: TODO
 * @author liupeiqi
 * @date 2015年3月27日 上午11:04:16
 * 
 */

public class ItemPriceInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String amount; // 商品价格 可空N

	private String salePrice; // 商品售价 可空N

	private String listPrice; // 商品列表价格 可空N

	private String nonBundleSalePrice; // 无捆绑售价 可空N

	private String rawTotalPrice; // 原始总价 可空N

	private String currencyCode = "CNY"; // 货币代码编号 可空N

	/**
	 * @return amount
	 */

	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return salePrice
	 */

	public String getSalePrice() {
		return salePrice;
	}

	/**
	 * @param salePrice
	 *            the salePrice to set
	 */
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * @return listPrice
	 */

	public String getListPrice() {
		return listPrice;
	}

	/**
	 * @param listPrice
	 *            the listPrice to set
	 */
	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}

	/**
	 * @return nonBundleSalePrice
	 */

	public String getNonBundleSalePrice() {
		return nonBundleSalePrice;
	}

	/**
	 * @param nonBundleSalePrice
	 *            the nonBundleSalePrice to set
	 */
	public void setNonBundleSalePrice(String nonBundleSalePrice) {
		this.nonBundleSalePrice = nonBundleSalePrice;
	}

	/**
	 * @return rawTotalPrice
	 */

	public String getRawTotalPrice() {
		return rawTotalPrice;
	}

	/**
	 * @param rawTotalPrice
	 *            the rawTotalPrice to set
	 */
	public void setRawTotalPrice(String rawTotalPrice) {
		this.rawTotalPrice = rawTotalPrice;
	}

	/**
	 * @return currencyCode
	 */

	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode
	 *            the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
