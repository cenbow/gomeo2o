package cn.com.gome.trade.dto.io.returnreq.response;

import java.io.Serializable;

public class ReturnReasonDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String returnRef;
	
	private String shippingGroupId;
	
	private String commerceItemId;
	
	private String description;

	public String getReturnRef() {
		return returnRef;
	}

	public void setReturnRef(String returnRef) {
		this.returnRef = returnRef;
	}

	public String getShippingGroupId() {
		return shippingGroupId;
	}

	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
	}

	public String getCommerceItemId() {
		return commerceItemId;
	}

	public void setCommerceItemId(String commerceItemId) {
		this.commerceItemId = commerceItemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
