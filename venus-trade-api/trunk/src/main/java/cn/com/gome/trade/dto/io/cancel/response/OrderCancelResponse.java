package cn.com.gome.trade.dto.io.cancel.response;

import java.io.Serializable;

/**
 * @Description: 取消订单返回json dto 
 * @author: liutaiming
 * @date: 2015年5月8日 下午7:41:38
 */
public class OrderCancelResponse implements Serializable {
	

	private static final long serialVersionUID = 6939618866787635495L;

	private String result;
	
	private String msg;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
