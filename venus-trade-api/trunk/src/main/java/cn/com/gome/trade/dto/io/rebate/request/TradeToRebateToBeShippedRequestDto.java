package cn.com.gome.trade.dto.io.rebate.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 推返利待发货 
 * @author: liutaiming
 * @date: 2015年5月19日 下午5:48:55
 */
public class TradeToRebateToBeShippedRequestDto implements Serializable{

	private static final long serialVersionUID = 3930051853785440861L;

	private String orderId; //订单号
	
	private String userId; //购买人id
	
	private Date buyDate; //购买时间 Date
	
	private Integer status;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
