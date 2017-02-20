package cn.com.gome.trade.dto.io.pay.request;

import java.io.Serializable;

/**
 * @Description: 在线银联支付请求json dto 
 * @author: liutaiming
 * @date: 2015年5月8日 下午7:42:33
 */
public class OrderUnionPayRequestDto implements Serializable{

	private static final long serialVersionUID = -8147929789188130203L;

	private String orderId;  //国美订单号  可空N 
	
	private String payAmount; //支付金额  可空N 
	
	private String platform; //支付平台  可空N  CHINAPAY 为在线_银联，D2Pay 为第三方支付
	
	private String accountCode; //支付平台代码  可空Y  10 为在线_银联，在线_银联支付时必填
	
	private String type; //支付类型  可空Y normal 一般,deposit 定金,balance 尾款
	
	private String transactionId; //交易流水号  可空Y   在线_银联支付时必填
	
	private String transDate; //交易时间    可空Y   在线_银联支付时必填

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	
}
