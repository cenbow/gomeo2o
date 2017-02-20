/**
 * @类名: AreaProductAvailableResponseDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月13日 下午6:18:54
 */
package cn.com.gome.trade.dto.io.product.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午6:18:54
 */
public class AreaProductAvailableResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AreaProductAvailableHeaderDto header;

	private AreaProductAvailableBodyDto body;

	/**
	 * @return the header
	 */
	public AreaProductAvailableHeaderDto getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(AreaProductAvailableHeaderDto header) {
		this.header = header;
	}

	/**
	 * @return the body
	 */
	public AreaProductAvailableBodyDto getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(AreaProductAvailableBodyDto body) {
		this.body = body;
	}

}
