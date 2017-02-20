package cn.com.gome.trade.dto.io.shipping.response;

import java.io.Serializable;

public class OrderShippingStateResponseDto implements Serializable{

	private static final long serialVersionUID = 6206773115700868769L;

	private String shippingGroupId; //配送单号
	
	private String state;  //状态;  例如：REMOVED、FAILED 、NO_PENDING_ACTION、PENDING_SHIPMENT
	
	private String flag;  //成功失败标示 Y：成功 N：失败
	
	private String msg;

	public String getShippingGroupId() {
		return shippingGroupId;
	}

	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
