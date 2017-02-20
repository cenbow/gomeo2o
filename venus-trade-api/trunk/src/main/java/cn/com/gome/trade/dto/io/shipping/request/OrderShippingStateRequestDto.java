package cn.com.gome.trade.dto.io.shipping.request;

import java.io.Serializable;

public class OrderShippingStateRequestDto implements Serializable{

	private static final long serialVersionUID = 4285093700550855087L;
	private String shippingGroupId;  //配送单号

	public String getShippingGroupId() {
		return shippingGroupId;
	}

	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
	}
	
}
