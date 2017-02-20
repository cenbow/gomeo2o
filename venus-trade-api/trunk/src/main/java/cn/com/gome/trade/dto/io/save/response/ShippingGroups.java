package cn.com.gome.trade.dto.io.save.response;

import java.io.Serializable;

public class ShippingGroups implements Serializable{

	private static final long serialVersionUID = 486498460118267059L;

	private String shippingGroupId;
	
	private String type;
	
	private String state;

	public String getShippingGroupId() {
		return shippingGroupId;
	}

	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
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
