/**   
 * @Title: ShippingGroupDtos.java 
 * @Package com.gomeo2o.facade.order.vo 
 * @Description: TODO
 * @author: liupeiqi 
 * @date 2015年3月27日 上午10:27:26 
 * @version V1.0   
 */

package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ShippingGroupDtos
 * @Description: TODO
 * @author liupeiqi
 * @date 2015年3月27日 上午10:27:26
 * 
 */

public class ShippingGroupDtos implements Serializable{

	private static final long serialVersionUID = 709352427641692676L;
	private String shippingMethod = "Gome Express"; // 运送方式 可空N 国美配送（Gome
													// Express）、第三方配送（1：普通快递
													// 2：EMS）

	private String shippingGroupType = "hardgoodShippingGroup"; // 运送类型 可空N
	// hardgoodShippingGroup；softgoodShippingGroup

	private String callConfirmNeeded = "true"; // 是否电话确认 可空N true, false

	private List<CommerceItemDtos> commerceItemDtos = new ArrayList<CommerceItemDtos>(); // 商品信息

	private ShippingPriceInfoDto shippingPriceInfoDto = new ShippingPriceInfoDto(); // 物流价格

	private ShippingAddressDto shippingAddressDto = new ShippingAddressDto(); // 收货人信息

	/**
	 * @return shippingMethod
	 */

	public String getShippingMethod() {
		return shippingMethod;
	}

	/**
	 * @param shippingMethod
	 *            the shippingMethod to set
	 */
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	/**
	 * @return shippingGroupType
	 */

	public String getShippingGroupType() {
		return shippingGroupType;
	}

	/**
	 * @param shippingGroupType
	 *            the shippingGroupType to set
	 */
	public void setShippingGroupType(String shippingGroupType) {
		this.shippingGroupType = shippingGroupType;
	}

	/**
	 * @return commerceItemDtos
	 */

	public List<CommerceItemDtos> getCommerceItemDtos() {
		return commerceItemDtos;
	}

	/**
	 * @param commerceItemDtos
	 *            the commerceItemDtos to set
	 */
	public void setCommerceItemDtos(List<CommerceItemDtos> commerceItemDtos) {
		this.commerceItemDtos = commerceItemDtos;
	}

	/**
	 * @return shippingPriceInfoDto
	 */

	public ShippingPriceInfoDto getShippingPriceInfoDto() {
		return shippingPriceInfoDto;
	}

	/**
	 * @param shippingPriceInfoDto
	 *            the shippingPriceInfoDto to set
	 */
	public void setShippingPriceInfoDto(
			ShippingPriceInfoDto shippingPriceInfoDto) {
		this.shippingPriceInfoDto = shippingPriceInfoDto;
	}

	/**
	 * @return callConfirmNeeded
	 */

	public String getCallConfirmNeeded() {
		return callConfirmNeeded;
	}

	/**
	 * @param callConfirmNeeded
	 *            the callConfirmNeeded to set
	 */
	public void setCallConfirmNeeded(String callConfirmNeeded) {
		this.callConfirmNeeded = callConfirmNeeded;
	}

	/**
	 * @return shippingAddressDto
	 */

	public ShippingAddressDto getShippingAddressDto() {
		return shippingAddressDto;
	}

	/**
	 * @param shippingAddressDto
	 *            the shippingAddressDto to set
	 */
	public void setShippingAddressDto(ShippingAddressDto shippingAddressDto) {
		this.shippingAddressDto = shippingAddressDto;
	}

}
