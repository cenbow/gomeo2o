package cn.com.gome.trade.dto.io.rebate.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 推返利
 * @author: liutaiming
 * @date: 2015年5月19日 下午3:15:28
 */
public class TradeToRebateRequestDto implements Serializable{

	private static final long serialVersionUID = 2706829288482670601L;

	private String orderId; //订单号
	
	private String userId; //购买人id
	
    private String buyName; //购买人 
	
	private Long orderDate; //购买时间 Date
	
	private Integer status;

	private List<TradeToRebateGoodsDto> goodsList = new ArrayList<TradeToRebateGoodsDto>(); //所有订单商品

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

	public Long getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Long orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<TradeToRebateGoodsDto> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<TradeToRebateGoodsDto> goodsList) {
		this.goodsList = goodsList;
	}

	public String getBuyName() {
		return buyName;
	}

	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}
	
}
