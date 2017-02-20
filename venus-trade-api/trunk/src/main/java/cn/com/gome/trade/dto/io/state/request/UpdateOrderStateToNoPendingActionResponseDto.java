/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: libin-ds9
 * @date: 2015年5月22日 下午3:14:03
 */
package cn.com.gome.trade.dto.io.state.request;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @author: libin-ds9
 * @date: 2015年5月22日 下午3:14:03
 */
public class UpdateOrderStateToNoPendingActionResponseDto implements Serializable {

	private static final long serialVersionUID = -2693482220646784609L;

	private List<ShippingGroupDto> shippingGroups;

	private String state;

	private String stateAsString;

	private String result;

	private String msg;

	/**
	 * @return the shippingGroups
	 */
	public List<ShippingGroupDto> getShippingGroups() {
		return shippingGroups;
	}

	/**
	 * @param shippingGroups
	 *            the shippingGroups to set
	 */
	public void setShippingGroups(List<ShippingGroupDto> shippingGroups) {
		this.shippingGroups = shippingGroups;
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
