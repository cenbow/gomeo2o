package cn.com.gome.trade.dto.io.pay.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 第三方支付请求json dto
 * @author: liutaiming
 * @date: 2015年5月8日 下午7:42:01
 */
public class OrderThirdPartyPayRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderId; // 国美订单号 可空N

	private String payAmount; // 支付金额 可空N

	private String platform = "D2Pay"; // 支付平台 可空N CHINAPAY 为在线_银联，D2Pay 为第三方支付
	
	private String transactionId; //交易流水号
	
	private Date transDate; //交易时间

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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
}
