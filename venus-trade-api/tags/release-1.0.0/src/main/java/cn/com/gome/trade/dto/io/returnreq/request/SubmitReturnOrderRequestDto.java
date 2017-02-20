/**
 * @类名: SubmitReturnOrderRequestDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午10:59:06
 */
package cn.com.gome.trade.dto.io.returnreq.request;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午10:59:06
 */
public class SubmitReturnOrderRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 站点id
	 */
	private String siteId;

	/**
	 * 外部站点id
	 */
	private String externalSiteRequestId;

	/**
	 * 配送单id
	 */
	private String shippingGroupId;

	/**
	 * 退换货类型
	 */
	private String requestType;

	/**
	 * 回库方式
	 */
	private String collectingMethod;

	/**
	 * 出检测报告
	 */
	private String hasQCReport;

	/**
	 * 商品信息
	 */
	private SubmitReturnOrderRequestitemInfoDto itemInfo;

	/**
	 * 配送地址信息
	 */
	private SubmitReturnOrderRequestShippingAddressDto shippingAddressDto;

	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * @return the externalSiteRequestId
	 */
	public String getExternalSiteRequestId() {
		return externalSiteRequestId;
	}

	/**
	 * @param externalSiteRequestId
	 *            the externalSiteRequestId to set
	 */
	public void setExternalSiteRequestId(String externalSiteRequestId) {
		this.externalSiteRequestId = externalSiteRequestId;
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
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @param requestType
	 *            the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * @return the collectingMethod
	 */
	public String getCollectingMethod() {
		return collectingMethod;
	}

	/**
	 * @param collectingMethod
	 *            the collectingMethod to set
	 */
	public void setCollectingMethod(String collectingMethod) {
		this.collectingMethod = collectingMethod;
	}

	/**
	 * @return the hasQCReport
	 */
	public String getHasQCReport() {
		return hasQCReport;
	}

	/**
	 * @param hasQCReport
	 *            the hasQCReport to set
	 */
	public void setHasQCReport(String hasQCReport) {
		this.hasQCReport = hasQCReport;
	}

	/**
	 * @return the itemInfo
	 */
	public SubmitReturnOrderRequestitemInfoDto getItemInfo() {
		return itemInfo;
	}

	/**
	 * @param itemInfo
	 *            the itemInfo to set
	 */
	public void setItemInfo(SubmitReturnOrderRequestitemInfoDto itemInfo) {
		this.itemInfo = itemInfo;
	}

	/**
	 * @return the shippingAddressDto
	 */
	public SubmitReturnOrderRequestShippingAddressDto getShippingAddressDto() {
		return shippingAddressDto;
	}

	/**
	 * @param shippingAddressDto
	 *            the shippingAddressDto to set
	 */
	public void setShippingAddressDto(
			SubmitReturnOrderRequestShippingAddressDto shippingAddressDto) {
		this.shippingAddressDto = shippingAddressDto;
	}

}
