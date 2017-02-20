/**
 * @类名: SubmitReturnOrderRequestitemInfoDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午11:01:55
 */
package cn.com.gome.trade.dto.io.returnreq.request;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午11:01:55
 */
public class SubmitReturnOrderRequestitemInfoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * SKUNO
	 */
	private String skuNo;

	/**
	 * 是否带发票
	 */
	private String invoiceNo;

	/**
	 * 产品外观
	 */
	private String appearance;

	/**
	 * 包装情况
	 */
	private String packing;

	/**
	 * 问题描述
	 */
	private String reasonDesc;

	/**
	 * @return the skuNo
	 */
	public String getSkuNo() {
		return skuNo;
	}

	/**
	 * @param skuNo
	 *            the skuNo to set
	 */
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}

	/**
	 * @return the invoiceNo
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * @param invoiceNo
	 *            the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * @return the appearance
	 */
	public String getAppearance() {
		return appearance;
	}

	/**
	 * @param appearance
	 *            the appearance to set
	 */
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	/**
	 * @return the packing
	 */
	public String getPacking() {
		return packing;
	}

	/**
	 * @param packing
	 *            the packing to set
	 */
	public void setPacking(String packing) {
		this.packing = packing;
	}

	/**
	 * @return the reasonDesc
	 */
	public String getReasonDesc() {
		return reasonDesc;
	}

	/**
	 * @param reasonDesc
	 *            the reasonDesc to set
	 */
	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

}
