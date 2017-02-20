/**   
 * @Title: ShippingPriceInfoDto.java 
 * @Package com.gomeo2o.facade.order.vo 
 * @Description: TODO
 * @author: liupeiqi 
 * @date 2015年3月27日 上午10:41:09 
 * @version V1.0   
 */

package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;

/**
 * @ClassName: ShippingPriceInfoDto
 * @Description: TODO
 * @author liupeiqi
 * @date 2015年3月27日 上午10:41:09
 * 
 */

public class ShippingPriceInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String amount; // 运费 可空N

	private String currencyCode = "CNY"; // 货币支付类型 可空N

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
