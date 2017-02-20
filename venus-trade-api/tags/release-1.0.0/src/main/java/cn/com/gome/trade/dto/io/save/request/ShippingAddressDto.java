/**   
 * @Title: ShippingAddressDto.java 
 * @Package com.gomeo2o.facade.order.vo 
 * @Description: TODO
 * @author: liupeiqi 
 * @date 2015年3月27日 上午10:50:18 
 * @version V1.0   
 */

package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;

/**
 * @ClassName: ShippingAddressDto
 * @Description: TODO
 * @author liupeiqi
 * @date 2015年3月27日 上午10:50:18
 * 
 */
public class ShippingAddressDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nationalId; // 国家代码 可空N

	private String provinceId; // 省份代码 可空N

	private String cityId; // 城市代码 可空N

	private String districtId; // 三级区域代码

	private String town; // 四级区域代码

	private String consignee; // 收货人姓名 可空N

	private String address; // 收货人地址 可空N

	private String email; // 收货人信箱 可空Y

	private String mobilePhone; // 收货人手机号 可空N

	private String phone; // 收货人电话 可空Y

	private String zipCode; // 邮政编码 可空Y

	/**
	 * @return nationalId
	 */

	public String getNationalId() {
		return nationalId;
	}

	/**
	 * @param nationalId
	 *            the nationalId to set
	 */
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	/**
	 * @return provinceId
	 */

	public String getProvinceId() {
		return provinceId;
	}

	/**
	 * @param provinceId
	 *            the provinceId to set
	 */
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @return cityId
	 */

	public String getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return districtId
	 */

	public String getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId
	 *            the districtId to set
	 */
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return consignee
	 */

	public String getConsignee() {
		return consignee;
	}

	/**
	 * @param consignee
	 *            the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	/**
	 * @return address
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return mobilePhone
	 */

	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone
	 *            the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return phone
	 */

	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return zipCode
	 */

	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the town
	 */
	public String getTown() {
		return town;
	}

	/**
	 * @param town
	 *            the town to set
	 */
	public void setTown(String town) {
		this.town = town;
	}

}
