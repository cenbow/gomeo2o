package cn.com.gome.trade.dto.io.shipping.response;

import java.io.Serializable;
import java.util.List;

public class OrderShippingHistoriesResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String shippingGroupId; // 配送单号

	private String siteId; // 站点ID

	private String status; // 状态

	private String details; // 描述信息

	private String name; // 商品名称

	private String parGroup;

	private String result;

	private String msg;

	private List<OrderShippingHistoriesCommerceItemDto> commerceItems; // 普通商品信息

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<OrderShippingHistoriesCommerceItemDto> getCommerceItems() {
		return commerceItems;
	}

	public void setCommerceItems(
			List<OrderShippingHistoriesCommerceItemDto> commerceItems) {
		this.commerceItems = commerceItems;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParGroup() {
		return parGroup;
	}

	public void setParGroup(String parGroup) {
		this.parGroup = parGroup;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
