package cn.com.gome.trade.dto.io.state.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午5:45:07
 */
public class FindOrderStatusHistorieDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 履历ID
	 */
	private String id;

	/**
	 * 履历类型
	 */
	private String type;

	/**
	 * 订单状态代码
	 */
	private String statusCode;

	/**
	 * 履历日期
	 */
	private String statusDate;

	/**
	 * 配送状态代码
	 */
	private String gomeState;

	/**
	 * 履历描述
	 */
	private String description;
	
	/**
	 * 分部公司
	 */
	private String salesCompany;

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

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
	 * @return the statusDate
	 */
	public String getStatusDate() {
		return statusDate;
	}

	/**
	 * @param statusDate
	 *            the statusDate to set
	 */
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	/**
	 * @return the gomeState
	 */
	public String getGomeState() {
		return gomeState;
	}

	/**
	 * @param gomeState
	 *            the gomeState to set
	 */
	public void setGomeState(String gomeState) {
		this.gomeState = gomeState;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalesCompany() {
		return salesCompany;
	}

	public void setSalesCompany(String salesCompany) {
		this.salesCompany = salesCompany;
	}

}
