/**   
 * @Title: PaymentGroupDtos.java 
 * @Package com.gomeo2o.facade.order.vo 
 * @Description: TODO
 * @author: liupeiqi 
 * @date 2015年3月27日 上午11:53:22 
 * @version V1.0   
 */

package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;

/**
 * @ClassName: PaymentGroupDtos
 * @Description: TODO
 * @author liupeiqi
 * @date 2015年3月27日 上午11:53:22
 * 
 */

public class PaymentGroupDtos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type = "DDPaymentGroup"; // 支付类型 可空N
											// 支付类型[onlinePayment,giftCertificate,
	// cashOnDelivery, DDPaymentGroup]

	private String giftCertificateNumber; // 红券编号 可空N

	private String giftCertificateAmount; // 红券金额 可空N

	private String amount; // 支付金额 可空N

	private String currencyCode = "CNY"; // 支付货币代码编号 可空N

	private String submittedDate; // 支付时间 可空N

	private String state = "INITIAL"; // 支付状态

	private String paymentMethod = "DDPaymentGroup"; // 支付方式 可空Y 当支付类型为
													// DDPaymentGroup
	// 时，需填写此字段，在线/积分[onlyOnline, integral]

	private String DDPaymentMethod = "onlyOnline"; // 第三方支付方式 可空Y 当支付类型为
													// DDPaymentGroup
	// 时，需填写此字段，在线/积分[onlyOnline, integral]

	private String paidAmount = "0.00";

	private String accountCode; // 支付方式代码 可空Y 当支付类型为 cashOnDelivery 时，无需填写此字段

	private String payAmount;

	/**
	 * 操作类型
	 */
	private String historyOperateType;

	/**
	 * 明细备注
	 */
	private String detailRemark;

	/**
	 * @return type
	 */

	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return giftCertificateNumber
	 */

	public String getGiftCertificateNumber() {
		return giftCertificateNumber;
	}

	/**
	 * @param giftCertificateNumber
	 *            the giftCertificateNumber to set
	 */
	public void setGiftCertificateNumber(String giftCertificateNumber) {
		this.giftCertificateNumber = giftCertificateNumber;
	}

	/**
	 * @return giftCertificateAmount
	 */

	public String getGiftCertificateAmount() {
		return giftCertificateAmount;
	}

	/**
	 * @param giftCertificateAmount
	 *            the giftCertificateAmount to set
	 */
	public void setGiftCertificateAmount(String giftCertificateAmount) {
		this.giftCertificateAmount = giftCertificateAmount;
	}

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

	/**
	 * @return submittedDate
	 */

	public String getSubmittedDate() {
		return submittedDate;
	}

	/**
	 * @param submittedDate
	 *            the submittedDate to set
	 */
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

	/**
	 * @return state
	 */

	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return paymentMethod
	 */

	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod
	 *            the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return dDPaymentMethod
	 */

	public String getDDPaymentMethod() {
		return DDPaymentMethod;
	}

	/**
	 * @param dDPaymentMethod
	 *            the dDPaymentMethod to set
	 */
	public void setDDPaymentMethod(String dDPaymentMethod) {
		DDPaymentMethod = dDPaymentMethod;
	}

	/**
	 * @return paidAmount
	 */

	public String getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount
	 *            the paidAmount to set
	 */
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * @return accountCode
	 */

	public String getAccountCode() {
		return accountCode;
	}

	/**
	 * @param accountCode
	 *            the accountCode to set
	 */
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	/**
	 * @return payAmount
	 */

	public String getPayAmount() {
		return payAmount;
	}

	/**
	 * @param payAmount
	 *            the payAmount to set
	 */
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * @return the historyOperateType
	 */
	public String getHistoryOperateType() {
		return historyOperateType;
	}

	/**
	 * @param historyOperateType
	 *            the historyOperateType to set
	 */
	public void setHistoryOperateType(String historyOperateType) {
		this.historyOperateType = historyOperateType;
	}

	/**
	 * @return the detailRemark
	 */
	public String getDetailRemark() {
		return detailRemark;
	}

	/**
	 * @param detailRemark
	 *            the detailRemark to set
	 */
	public void setDetailRemark(String detailRemark) {
		this.detailRemark = detailRemark;
	}

}
