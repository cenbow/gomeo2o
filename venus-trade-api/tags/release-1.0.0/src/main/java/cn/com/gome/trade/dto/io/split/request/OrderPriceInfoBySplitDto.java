package cn.com.gome.trade.dto.io.split.request;

import java.io.Serializable;

public class OrderPriceInfoBySplitDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String amount; // 支付金额

	private String rawSubtotal; // 订单的原始价格

	private String currencyCode = "CNY"; // 支付货币代码

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRawSubtotal() {
		return rawSubtotal;
	}

	public void setRawSubtotal(String rawSubtotal) {
		this.rawSubtotal = rawSubtotal;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
