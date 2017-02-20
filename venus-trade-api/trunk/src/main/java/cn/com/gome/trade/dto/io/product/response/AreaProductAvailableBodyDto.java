/**
 * @类名: AreaProductAvailableBodyDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月13日 下午6:19:47
 */
package cn.com.gome.trade.dto.io.product.response;

import java.io.Serializable;
import java.util.List;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午6:19:47
 */
public class AreaProductAvailableBodyDto implements Serializable{

	private static final long serialVersionUID = 1563937253755441957L;
	private List<AreaProductAvailableDetailDto> details;

	/**
	 * @return the details
	 */
	public List<AreaProductAvailableDetailDto> getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(List<AreaProductAvailableDetailDto> details) {
		this.details = details;
	}

}
