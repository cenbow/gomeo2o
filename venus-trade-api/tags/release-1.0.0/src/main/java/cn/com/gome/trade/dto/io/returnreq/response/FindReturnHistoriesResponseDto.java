/**
 * @类名: FindReturnHistoriesResponseDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月14日 下午3:05:44
 */
package cn.com.gome.trade.dto.io.returnreq.response;

import java.io.Serializable;
import java.util.List;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月14日 下午3:05:44
 */
public class FindReturnHistoriesResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String returnOrderId;

	private String status;

	private List<FindReturnShippingGroupDto> shippingGroups;

	/**
	 * @return the returnOrderId
	 */
	public String getReturnOrderId() {
		return returnOrderId;
	}

	/**
	 * @param returnOrderId
	 *            the returnOrderId to set
	 */
	public void setReturnOrderId(String returnOrderId) {
		this.returnOrderId = returnOrderId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the shippingGroups
	 */
	public List<FindReturnShippingGroupDto> getShippingGroups() {
		return shippingGroups;
	}

	/**
	 * @param shippingGroups
	 *            the shippingGroups to set
	 */
	public void setShippingGroups(
			List<FindReturnShippingGroupDto> shippingGroups) {
		this.shippingGroups = shippingGroups;
	}

}
