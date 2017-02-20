/**
 * @类名: RefunddebitinfosDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午10:03:45
 */
package cn.com.gome.trade.dto.io.shipping.request;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午10:03:45
 */
public class RefunddebitinfosDto implements Serializable{

	private static final long serialVersionUID = -6502250015097726267L;

	/**
	 * 扣款金额
	 */
	private Double debitamount;

	/**
	 * 原因ID
	 */
	private String reasonid;

	/**
	 * 支付号
	 */
	private String paymentgroupid;

	/**
	 * @return the debitamount
	 */
	public Double getDebitamount() {
		return debitamount;
	}

	/**
	 * @param debitamount
	 *            the debitamount to set
	 */
	public void setDebitamount(Double debitamount) {
		this.debitamount = debitamount;
	}

	/**
	 * @return the reasonid
	 */
	public String getReasonid() {
		return reasonid;
	}

	/**
	 * @param reasonid
	 *            the reasonid to set
	 */
	public void setReasonid(String reasonid) {
		this.reasonid = reasonid;
	}

	/**
	 * @return the paymentgroupid
	 */
	public String getPaymentgroupid() {
		return paymentgroupid;
	}

	/**
	 * @param paymentgroupid
	 *            the paymentgroupid to set
	 */
	public void setPaymentgroupid(String paymentgroupid) {
		this.paymentgroupid = paymentgroupid;
	}

}
