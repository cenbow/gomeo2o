package cn.com.gome.trade.dto.io.save.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 生成订单返回json dto
 * @author: liutaiming
 * @date: 2015年5月8日 下午7:44:17
 */
public class OrderSaveResponseDto implements Serializable{

	private static final long serialVersionUID = 2418714307795953221L;

	private String siteId; // 站点ID

	private String externalSiteOrderId; // 额外订单ID

	private List<PaymentGroups> paymentGroups = new ArrayList<PaymentGroups>(); // 支付信息

	private List<ShippingGroups> shippingGroups = new ArrayList<ShippingGroups>(); // 物流信息

	private String invoiceId; // 发票ID

	private String resultFlag; // 返回结果标志 //Y成功 N失败

	private String msg;

	private String orderId; // 订单编号

	private String state; // 订单状态

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getExternalSiteOrderId() {
		return externalSiteOrderId;
	}

	public void setExternalSiteOrderId(String externalSiteOrderId) {
		this.externalSiteOrderId = externalSiteOrderId;
	}

	public List<PaymentGroups> getPaymentGroups() {
		return paymentGroups;
	}

	public void setPaymentGroups(List<PaymentGroups> paymentGroups) {
		this.paymentGroups = paymentGroups;
	}

	public List<ShippingGroups> getShippingGroups() {
		return shippingGroups;
	}

	public void setShippingGroups(List<ShippingGroups> shippingGroups) {
		this.shippingGroups = shippingGroups;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
