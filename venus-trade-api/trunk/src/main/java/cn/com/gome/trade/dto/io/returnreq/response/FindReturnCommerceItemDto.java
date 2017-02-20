/**
 * @类名: FindReturnCommerceItemsDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月14日 下午3:21:07
 */
package cn.com.gome.trade.dto.io.returnreq.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月14日 下午3:21:07
 */
public class FindReturnCommerceItemDto implements Serializable{


	private static final long serialVersionUID = 9049232195443037566L;

	private String name;

	private String partGroup;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the partGroup
	 */
	public String getPartGroup() {
		return partGroup;
	}

	/**
	 * @param partGroup
	 *            the partGroup to set
	 */
	public void setPartGroup(String partGroup) {
		this.partGroup = partGroup;
	}

}
