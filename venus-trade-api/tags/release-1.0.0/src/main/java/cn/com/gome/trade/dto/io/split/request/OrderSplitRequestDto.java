package cn.com.gome.trade.dto.io.split.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderSplitRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String uuid; // 识别码

	private String siteId = "xinyewuSite"; // 站点id

	private String channel = "normalOrder"; // 渠道

	private String profileId; // 用户id

	private String state = ""; // 状态

	private String memo = ""; // 备注

	private String externalSiteOrderId; // 外部站点订单编号 额外站点ID

	private String submittedDate; // 提交订单时间

	private OrderPriceInfoBySplitDto orderPriceInfoDto = new OrderPriceInfoBySplitDto(); // 订单价格信息

	private List<ShippingGroupBySplitDtos> shippingGroupDtos = new ArrayList<ShippingGroupBySplitDtos>(); // 配送价格信息

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getExternalSiteOrderId() {
		return externalSiteOrderId;
	}

	public void setExternalSiteOrderId(String externalSiteOrderId) {
		this.externalSiteOrderId = externalSiteOrderId;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

	public OrderPriceInfoBySplitDto getOrderPriceInfoDto() {
		return orderPriceInfoDto;
	}

	public void setOrderPriceInfoDto(OrderPriceInfoBySplitDto orderPriceInfoDto) {
		this.orderPriceInfoDto = orderPriceInfoDto;
	}

	public List<ShippingGroupBySplitDtos> getShippingGroupDtos() {
		return shippingGroupDtos;
	}

	public void setShippingGroupDtos(
			List<ShippingGroupBySplitDtos> shippingGroupDtos) {
		this.shippingGroupDtos = shippingGroupDtos;
	}

}
