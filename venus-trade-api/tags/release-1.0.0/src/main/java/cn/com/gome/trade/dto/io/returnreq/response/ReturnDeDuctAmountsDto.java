package cn.com.gome.trade.dto.io.returnreq.response;

import java.io.Serializable;

public class ReturnDeDuctAmountsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String deDuctAmountDesc;
	
	private Integer deDuctAmount;

	public String getDeDuctAmountDesc() {
		return deDuctAmountDesc;
	}

	public void setDeDuctAmountDesc(String deDuctAmountDesc) {
		this.deDuctAmountDesc = deDuctAmountDesc;
	}

	public Integer getDeDuctAmount() {
		return deDuctAmount;
	}

	public void setDeDuctAmount(Integer deDuctAmount) {
		this.deDuctAmount = deDuctAmount;
	}
	
	
}
