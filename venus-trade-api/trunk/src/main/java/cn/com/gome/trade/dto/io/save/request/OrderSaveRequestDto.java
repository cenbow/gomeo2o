package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 订单生成请求json dto
 * @author: liutaiming
 * @date: 2015年5月8日 下午7:43:37
 */
public class OrderSaveRequestDto implements Serializable{

	private static final long serialVersionUID = -194521461239546817L;

	private String platform; // 平台

	private String channel = "normalOrder"; // 订单渠道 可空N

	private String description = ""; // 描述 可空N

	private String externalSiteOrderId; // 额外站点ID 可空Y

	private String memo; // 订单备注 可空Y

	private String profileId; // 用户ID 可空N

	private String siteId; // 站点ID 可空Y

	private String state = "PENDING_POST_PROCESS"; // 订单状态 可空N 默认传递
													// PENDING_POST_PROCESS 等待处理

	private String submittedDate;// 提交时间 可空N

	private OrderPriceInfoDto orderPriceInfoDto; // 订单价格信息

	private InvoiceDto invoiceDto; // 发票 可空N

	private List<ShippingGroupDtos> shippingGroupDtos; // 订单配送信息
														// 可空N

	private List<PaymentGroupDtos> paymentGroupDtos; // 订单支付信息
														// 可空N

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalSiteOrderId() {
		return externalSiteOrderId;
	}

	public void setExternalSiteOrderId(String externalSiteOrderId) {
		this.externalSiteOrderId = externalSiteOrderId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

	public OrderPriceInfoDto getOrderPriceInfoDto() {
		return orderPriceInfoDto;
	}

	public void setOrderPriceInfoDto(OrderPriceInfoDto orderPriceInfoDto) {
		this.orderPriceInfoDto = orderPriceInfoDto;
	}

	public InvoiceDto getInvoiceDto() {
		return invoiceDto;
	}

	public void setInvoiceDto(InvoiceDto invoiceDto) {
		this.invoiceDto = invoiceDto;
	}

	public List<ShippingGroupDtos> getShippingGroupDtos() {
		return shippingGroupDtos;
	}

	public void setShippingGroupDtos(List<ShippingGroupDtos> shippingGroupDtos) {
		this.shippingGroupDtos = shippingGroupDtos;
	}

	public List<PaymentGroupDtos> getPaymentGroupDtos() {
		return paymentGroupDtos;
	}

	public void setPaymentGroupDtos(List<PaymentGroupDtos> paymentGroupDtos) {
		this.paymentGroupDtos = paymentGroupDtos;
	}

}
