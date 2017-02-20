/**
 * @类名: AreaProductAvailableHeaderDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月13日 下午6:19:32
 */
package cn.com.gome.trade.dto.io.product.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午6:19:32
 */
public class AreaProductAvailableHeaderDto implements Serializable{


	private static final long serialVersionUID = 8294346948616170468L;

	private String responseCode; //状态码

	private String remark;

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode
	 *            the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
