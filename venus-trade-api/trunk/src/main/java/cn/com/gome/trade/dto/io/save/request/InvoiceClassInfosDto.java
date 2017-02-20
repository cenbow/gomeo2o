package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;

public class InvoiceClassInfosDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8079601423321296596L;

	private String invoiceclass = "rybh";
	
	private String invoiceconttype = "0";

	public String getInvoiceclass() {
		return invoiceclass;
	}

	public void setInvoiceclass(String invoiceclass) {
		this.invoiceclass = invoiceclass;
	}

	public String getInvoiceconttype() {
		return invoiceconttype;
	}

	public void setInvoiceconttype(String invoiceconttype) {
		this.invoiceconttype = invoiceconttype;
	}
	
}
