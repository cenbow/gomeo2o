package cn.com.gome.trade.dto.io.split.response;

import java.io.Serializable;

public class CodDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codSupported;  
	
	private String posSupported;  //pos刷卡 
	
	private String cashSupported;  //现金

	public String getCodSupported() {
		return codSupported;
	}

	public void setCodSupported(String codSupported) {
		this.codSupported = codSupported;
	}

	public String getPosSupported() {
		return posSupported;
	}

	public void setPosSupported(String posSupported) {
		this.posSupported = posSupported;
	}

	public String getCashSupported() {
		return cashSupported;
	}

	public void setCashSupported(String cashSupported) {
		this.cashSupported = cashSupported;
	}
	
	
	
}
