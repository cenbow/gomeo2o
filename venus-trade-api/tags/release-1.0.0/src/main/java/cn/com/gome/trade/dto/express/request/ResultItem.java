package cn.com.gome.trade.dto.express.request;

import java.io.Serializable;

public class ResultItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String time;//时间
	String context;//内容
	String ftime;//格式化时间

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

}
