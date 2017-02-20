package cn.com.gome.trade.dto.io.split.request;

import java.io.Serializable;

public class ShippingPriceInfoBySplitDto implements Serializable {

	private static final long serialVersionUID = -3525232261866309436L;

	private String amount; // 支付金额

	private String currencyCode = "CNY"; // 支付货币代码

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
