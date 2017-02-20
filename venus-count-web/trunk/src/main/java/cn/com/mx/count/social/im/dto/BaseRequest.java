package cn.com.mx.count.social.im.dto;

/**
 * 
 * @Description: im请求基类 
 * @author: xuguoqi
 * @date: 2016年1月18日 下午3:54:24
 */
public class BaseRequest {

	private String requestId;//请求的requestId

	private String appServerName; //请求的应用服务器名称

	public String getAppServerName() {
		return appServerName;
	}

	public void setAppServerName(String appServerName) {
		this.appServerName = appServerName;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
