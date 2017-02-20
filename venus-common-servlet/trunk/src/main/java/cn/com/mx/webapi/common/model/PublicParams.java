package cn.com.mx.webapi.common.model;

import java.io.Serializable;

public class PublicParams implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8190396198047028562L;
	
	private String token;
	private String accessToken;
	private String device;
	private String app;
	private String net;
	private String accept;
	private String traceId;
	private String jsonp;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getNet() {
		return net;
	}
	public void setNet(String net) {
		this.net = net;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getTraceId() {
		return traceId;
	}
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	public String getJsonp() {
		return jsonp;
	}
	public void setJsonp(String jsonp) {
		this.jsonp = jsonp;
	}
	
	
}
