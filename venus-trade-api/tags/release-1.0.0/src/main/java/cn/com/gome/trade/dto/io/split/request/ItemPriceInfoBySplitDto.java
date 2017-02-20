package cn.com.gome.trade.dto.io.split.request;

import java.io.Serializable;

public class ItemPriceInfoBySplitDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String amount; // 商品项总金额

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
