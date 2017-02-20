/**
 * @类名: FindReturnMilestoneDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月14日 下午3:22:29
 */
package cn.com.gome.trade.dto.io.returnreq.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月14日 下午3:22:29
 */
public class FindReturnMilestoneDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statusCode;

	private String statusTime;

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusTime
	 */
	public String getStatusTime() {
		return statusTime;
	}

	/**
	 * @param statusTime
	 *            the statusTime to set
	 */
	public void setStatusTime(String statusTime) {
		this.statusTime = statusTime;
	}

}
