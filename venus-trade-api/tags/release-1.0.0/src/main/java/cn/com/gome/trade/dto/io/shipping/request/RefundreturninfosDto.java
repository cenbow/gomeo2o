/**
 * @类名: RefundreturninfosDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午10:04:53
 */
package cn.com.gome.trade.dto.io.shipping.request;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午10:04:53
 */
public class RefundreturninfosDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 退款金额
	 */
	private Double amount;

	/**
	 * 支付号
	 */
	private String paymentgroupid;

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
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
