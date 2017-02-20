package cn.com.gome.trade.dto.io.save.response;

import java.io.Serializable;

public class PaymentGroups implements Serializable{

	private static final long serialVersionUID = 2164264578039570207L;

	private String paymentGroupId; //支付组ID
	
	private String type; //支付类型
	
	private String state; //支付状态

	public String getPaymentGroupId() {
		return paymentGroupId;
	}

	public void setPaymentGroupId(String paymentGroupId) {
		this.paymentGroupId = paymentGroupId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
