/**   
 * @Title: OrderPriceInfoDto.java 
 * @Package com.gomeo2o.facade.order.vo 
 * @Description: TODO
 * @author: liupeiqi 
 * @date 2015年3月27日 上午9:36:58 
 * @version V1.0   
 */

package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;

/**
 * @ClassName: OrderPriceInfoDto
 * @Description: TODO
 * @author liupeiqi
 * @date 2015年3月27日 上午9:36:58
 * 
 */

public class OrderPriceInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String amount; // 订单价格 可空N

	private String rawSubtotal; // 货币代码编号 可空N

	private String currencyCode = "CNY";// 订单原价 可空N

	private String shipping; // 总运费

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
	 * @return rawSubtotal
	 */

	public String getRawSubtotal() {
		return rawSubtotal;
	}

	/**
	 * @param rawSubtotal
	 *            the rawSubtotal to set
	 */
	public void setRawSubtotal(String rawSubtotal) {
		this.rawSubtotal = rawSubtotal;
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

	/**
	 * @return the shipping
	 */
	public String getShipping() {
		return shipping;
	}

	/**
	 * @param shipping
	 *            the shipping to set
	 */
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

}
