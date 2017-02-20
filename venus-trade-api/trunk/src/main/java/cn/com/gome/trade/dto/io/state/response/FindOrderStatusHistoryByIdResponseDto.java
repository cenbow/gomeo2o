/**
 * @类名: FindOrderStatusHistoryByIdRequestDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月13日 下午5:40:57
 */
package cn.com.gome.trade.dto.io.state.response;

import java.io.Serializable;
import java.util.List;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午5:40:57
 */
public class FindOrderStatusHistoryByIdResponseDto implements Serializable  {

	private static final long serialVersionUID = -5786815368416023164L;

	/**
	 * 订单ID
	 */
	private String orderId;

	/**
	 * 订单状态
	 */
	private String state;

	/**
	 * 订单状态详情
	 */
	private String stateAsString;

	private List<FindOrderStatusHistorieDto> statusHistories;

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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the stateAsString
	 */
	public String getStateAsString() {
		return stateAsString;
	}

	/**
	 * @param stateAsString
	 *            the stateAsString to set
	 */
	public void setStateAsString(String stateAsString) {
		this.stateAsString = stateAsString;
	}

	/**
	 * @return the statusHistories
	 */
	public List<FindOrderStatusHistorieDto> getStatusHistories() {
		return statusHistories;
	}

	/**
	 * @param statusHistories
	 *            the statusHistories to set
	 */
	public void setStatusHistories(
			List<FindOrderStatusHistorieDto> statusHistories) {
		this.statusHistories = statusHistories;
	}

}
