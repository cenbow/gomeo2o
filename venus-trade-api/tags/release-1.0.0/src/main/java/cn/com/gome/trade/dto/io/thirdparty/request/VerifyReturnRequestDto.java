/**
 * @类名: VerifyReturnRequestDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午10:37:59
 */
package cn.com.gome.trade.dto.io.thirdparty.request;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午10:37:59
 */
public class VerifyReturnRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 站点ID
	 */
	private String siteId;

	/**
	 * 配送单号
	 */
	private String districtId;

	/**
	 * SKUNO
	 */
	private String skuNo;

	/**
	 * 退换货标示
	 * 
	 * RO：退货；PR：换货
	 */
	private String requestType;

	/**
	 * 配送单号
	 */
	private String shippingGroupId;

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
	 * @return the districtId
	 */
	public String getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId
	 *            the districtId to set
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the skuNo
	 */
	public String getSkuNo() {
		return skuNo;
	}

	/**
	 * @param skuNo
	 *            the skuNo to set
	 */
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
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

}
