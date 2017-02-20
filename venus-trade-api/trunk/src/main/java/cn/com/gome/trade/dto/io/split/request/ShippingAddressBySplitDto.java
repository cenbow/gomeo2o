package cn.com.gome.trade.dto.io.split.request;

import java.io.Serializable;

public class ShippingAddressBySplitDto implements Serializable {

	private static final long serialVersionUID = 2853494800883466874L;
	private String districtId; // 区县id

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

}
