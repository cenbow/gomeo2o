/**
 * @类名: FindReturnShippingGroupDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月14日 下午3:19:05
 */
package cn.com.gome.trade.dto.io.returnreq.response;

import java.io.Serializable;
import java.util.List;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月14日 下午3:19:05
 */
public class FindReturnShippingGroupDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<FindReturnOrderStatusHistorieDto> details;

	private List<FindReturnCommerceItemDto> commerceItems;

	private List<FindReturnMilestoneDto> milestones;

	/**
	 * @return the details
	 */
	public List<FindReturnOrderStatusHistorieDto> getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(List<FindReturnOrderStatusHistorieDto> details) {
		this.details = details;
	}

	/**
	 * @return the commerceItems
	 */
	public List<FindReturnCommerceItemDto> getCommerceItems() {
		return commerceItems;
	}

	/**
	 * @param commerceItems
	 *            the commerceItems to set
	 */
	public void setCommerceItems(List<FindReturnCommerceItemDto> commerceItems) {
		this.commerceItems = commerceItems;
	}

	/**
	 * @return the milestones
	 */
	public List<FindReturnMilestoneDto> getMilestones() {
		return milestones;
	}

	/**
	 * @param milestones
	 *            the milestones to set
	 */
	public void setMilestones(List<FindReturnMilestoneDto> milestones) {
		this.milestones = milestones;
	}

}
