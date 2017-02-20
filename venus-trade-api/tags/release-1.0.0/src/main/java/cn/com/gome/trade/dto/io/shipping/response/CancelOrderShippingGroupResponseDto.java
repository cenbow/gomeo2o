/**
 * @类名: CancelOrderShippingGroupResponseDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午9:58:45
 */
package cn.com.gome.trade.dto.io.shipping.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午9:58:45
 */
public class CancelOrderShippingGroupResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 返回结果
	 * 
	 * Y：成功；N：失败
	 */
	private String result;

	/**
	 * 返回信息
	 * 
	 * 描述信息
	 */
	private String msg;

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
