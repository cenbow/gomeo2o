/**
 * @类名: AreaProductAvailableRequestDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月13日 下午6:03:19
 */
package cn.com.gome.trade.dto.io.product.request;

import java.io.Serializable;
import java.util.List;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午6:03:19
 */
public class AreaProductAvailableRequestDto implements Serializable{

	private static final long serialVersionUID = -6197013309424928871L;

	/**
	 * 销售渠道代码
	 */
	private String buid = "8270";  //销售渠道代码 可空N  默认 8270

	/**
	 * 配送区域
	 */
	private String daId;

	private List<AreaProductAvailableDetailDto> details;

	/**
	 * @return the buid
	 */
	public String getBuid() {
		return buid;
	}

	/**
	 * @param buid
	 *            the buid to set
	 */
	public void setBuid(String buid) {
		this.buid = buid;
	}

	/**
	 * @return the daId
	 */
	public String getDaId() {
		return daId;
	}

	/**
	 * @param daId
	 *            the daId to set
	 */
	public void setDaId(String daId) {
		this.daId = daId;
	}

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
