package cn.com.gome.trade.dto.io.shipping.request;

import java.io.Serializable;

public class OrderShippingHistoriesRequestDto implements Serializable{

	private static final long serialVersionUID = -8915852095918282461L;

	private String shippingGroupId; //配送单号 可空N
	
	private String siteId;  //站点id 可空Y

	public String getShippingGroupId() {
		return shippingGroupId;
	}

	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

}
