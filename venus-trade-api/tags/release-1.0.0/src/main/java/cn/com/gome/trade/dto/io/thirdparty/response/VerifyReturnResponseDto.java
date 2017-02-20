/**
 * @类名: VerifyReturnResponseDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午10:37:43
 */
package cn.com.gome.trade.dto.io.thirdparty.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午10:37:43
 */
public class VerifyReturnResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 配送单号
	 */
	private String shippingGroupId;

	/**
	 * SKUNO
	 */
	private String skuNo;

	/**
	 * 回库方式
	 */
	private String collectingMethod;

	/**
	 * 邮件地址
	 */
	private String mailAddress;

	/**
	 * 成功失败标示
	 */
	private String resultFlag;

	/**
	 * 是否可退换标示
	 */
	private String requestTestSuccess;

	/**
	 * 返回消息
	 */
	private String msg;

	/**
	 * @return the shippingGroupId
	 */
	public String getShippingGroupId() {
		return shippingGroupId;
	}

	/**
	 * @param shippingGroupId
	 *            the shippingGroupId to set
	 */
	public void setShippingGroupId(String shippingGroupId) {
		this.shippingGroupId = shippingGroupId;
	}

	/**
	 * @return the skuNo
	 */
	public String getSkuNo() {
		return skuNo;
	}

	/**
	 * @param skuNo
	 *            the skuNo to set
	 */
	public void setSkuNo(String skuNo) {
		this.skuNo = skuNo;
	}

	/**
	 * @return the collectingMethod
	 */
	public String getCollectingMethod() {
		return collectingMethod;
	}

	/**
	 * @param collectingMethod
	 *            the collectingMethod to set
	 */
	public void setCollectingMethod(String collectingMethod) {
		this.collectingMethod = collectingMethod;
	}

	/**
	 * @return the mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * @param mailAddress
	 *            the mailAddress to set
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * @return the resultFlag
	 */
	public String getResultFlag() {
		return resultFlag;
	}

	/**
	 * @param resultFlag
	 *            the resultFlag to set
	 */
	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	/**
	 * @return the requestTestSuccess
	 */
	public String getRequestTestSuccess() {
		return requestTestSuccess;
	}

	/**
	 * @param requestTestSuccess
	 *            the requestTestSuccess to set
	 */
	public void setRequestTestSuccess(String requestTestSuccess) {
		this.requestTestSuccess = requestTestSuccess;
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
