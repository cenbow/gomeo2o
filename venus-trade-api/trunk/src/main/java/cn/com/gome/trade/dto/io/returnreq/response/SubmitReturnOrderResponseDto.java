/**
 * @类名: SubmitReturnOrderResponseDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月11日 上午10:59:18
 */
package cn.com.gome.trade.dto.io.returnreq.response;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月11日 上午10:59:18
 */
public class SubmitReturnOrderResponseDto implements Serializable{

	private static final long serialVersionUID = 4838110124118388287L;

	/**
	 * 外部站点id
	 */
	private String externalSiteRequestId;

	/**
	 * 返回状态
	 */
	private String resultFlag;

	/**
	 * 返回消息
	 */
	private String msg;

	/**
	 * 成功失败标示
	 */
	private String reasonCode;
	
	/**
	 * 成功失败标示
	 */
	private String requestId;
	

	/**
	 * @return the externalSiteRequestId
	 */
	public String getExternalSiteRequestId() {
		return externalSiteRequestId;
	}

	/**
	 * @param externalSiteRequestId
	 *            the externalSiteRequestId to set
	 */
	public void setExternalSiteRequestId(String externalSiteRequestId) {
		this.externalSiteRequestId = externalSiteRequestId;
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

	/**
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param reasonCode
	 *            the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
