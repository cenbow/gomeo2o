/**
 * @类名: CancelOrderShippingGroupRequestseDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午9:59:37
 */
package cn.com.gome.trade.dto.io.shipping.request;

import java.io.Serializable;
import java.util.List;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午9:59:37
 */
public class CancelOrderShippingGroupRequestDto implements Serializable{

	private static final long serialVersionUID = 571309443452233237L;

	/**
	 * 国美订单号
	 */
	private String orderId;

	/**
	 * 配送单号
	 */
	private String shippingGroupId;

	/**
	 * 取消类型
	 */
	private String cancelType;

	/**
	 * 取消描述
	 */
	private String description;

	/**
	 * 取消原因代码
	 */
	private String reasonCode;

	/**
	 * 操作者
	 */
	private String updateUserName;

	/**
	 * 是否需要退款
	 */
	private String isNeedRefund;

	/**
	 * 扣款信息
	 */
	private List<RefunddebitinfosDto> refunddebitinfos;

	/**
	 * 退款信息
	 */
	private List<RefundreturninfosDto> refundreturninfos;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the shippingGroupId
	 */
	public String getShippingGroupId() {
		return shippingGroupId;
	}

	/**
	 * @param shippingGroupId
	 *            the shippingGroupId to set
	 */
	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
	}

	/**
	 * @return the cancelType
	 */
	public String getCancelType() {
		return cancelType;
	}

	/**
	 * @param cancelType
	 *            the cancelType to set
	 */
	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param reasonCode
	 *            the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return the updateUserName
	 */
	public String getUpdateUserName() {
		return updateUserName;
	}

	/**
	 * @param updateUserName
	 *            the updateUserName to set
	 */
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	/**
	 * @return the isNeedRefund
	 */
	public String getIsNeedRefund() {
		return isNeedRefund;
	}

	/**
	 * @param isNeedRefund
	 *            the isNeedRefund to set
	 */
	public void setIsNeedRefund(String isNeedRefund) {
		this.isNeedRefund = isNeedRefund;
	}

	/**
	 * @return the refunddebitinfos
	 */
	public List<RefunddebitinfosDto> getRefunddebitinfos() {
		return refunddebitinfos;
	}

	/**
	 * @param refunddebitinfos
	 *            the refunddebitinfos to set
	 */
	public void setRefunddebitinfos(List<RefunddebitinfosDto> refunddebitinfos) {
		this.refunddebitinfos = refunddebitinfos;
	}

	/**
	 * @return the refundreturninfos
	 */
	public List<RefundreturninfosDto> getRefundreturninfos() {
		return refundreturninfos;
	}

	/**
	 * @param refundreturninfos
	 *            the refundreturninfos to set
	 */
	public void setRefundreturninfos(
			List<RefundreturninfosDto> refundreturninfos) {
		this.refundreturninfos = refundreturninfos;
	}

}
