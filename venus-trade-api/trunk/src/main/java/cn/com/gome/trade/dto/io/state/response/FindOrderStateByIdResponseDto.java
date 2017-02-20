/**
 * @类名: FindOrderStateByIdResponseDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月13日 下午5:33:23
 */
package cn.com.gome.trade.dto.io.state.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午5:33:23
 */
public class FindOrderStateByIdResponseDto implements Serializable {

	private static final long serialVersionUID = 1252904263770564205L;

	/**
	 * 订单ID
	 */
	private String orderId;

	/**
	 * 状态
	 */
	private String state;

	/**
	 * 状态信息
	 */
	private String stateAsString;

	private String result;

	private String msg;

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
