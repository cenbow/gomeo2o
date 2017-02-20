package cn.com.gome.trade.dto.express.request;

import java.io.Serializable;

public class ResultItem implements Serializable{


	private static final long serialVersionUID = 4321956127616571968L;
	String time;//鏃堕棿
	String context;//鍐呭
	String ftime;//鏍煎紡鍖栨椂闂�

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
