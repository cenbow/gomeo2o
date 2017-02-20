package cn.com.gome.trade.dto.io.shipping.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月9日 下午3:41:35
 */
public class OrderShippingHistoriesCommerceItemDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 商品名称
	 */
	private String name;

	private String partGroup;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartGroup() {
		return partGroup;
	}

	public void setPartGroup(String partGroup) {
		this.partGroup = partGroup;
	}

}
