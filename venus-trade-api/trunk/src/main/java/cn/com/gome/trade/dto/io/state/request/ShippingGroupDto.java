/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: libin-ds9
 * @date: 2015年5月22日 下午3:15:21
 */
package cn.com.gome.trade.dto.io.state.request;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: libin-ds9
 * @date: 2015年5月22日 下午3:15:21
 */
public class ShippingGroupDto implements Serializable {

	private static final long serialVersionUID = -6126621355683601650L;

	private String id;

	private String state;

	private String stateAsString;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
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

}
