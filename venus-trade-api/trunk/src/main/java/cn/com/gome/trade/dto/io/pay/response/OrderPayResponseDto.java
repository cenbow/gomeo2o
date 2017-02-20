package cn.com.gome.trade.dto.io.pay.response;

import java.io.Serializable;

/**
 * @Description: 支付返回json dto 
 * @author: liutaiming
 * @date: 2015年5月8日 下午7:43:15
 */
public class OrderPayResponseDto implements Serializable {
	

	private static final long serialVersionUID = -5526539912647236097L;

	private String result; //成功失败标示 Y：成功；N：失败
	
	private String msg; //返回信息

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
