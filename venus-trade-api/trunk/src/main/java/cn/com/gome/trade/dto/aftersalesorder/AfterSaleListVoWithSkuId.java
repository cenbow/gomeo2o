package cn.com.gome.trade.dto.aftersalesorder;

//import com.gomeo2o.web.frontend.manage.model.order.AfterSaleListVo;

public class AfterSaleListVoWithSkuId {
	private long skuId;
	
	private Long orderId;
	
	private AfterSale afterSale;
	
	private AfterSalesOrder afterSalesOrder;
	private AfterSaleListVo afterSaleListVo;
	
	public long getSkuId() {
		return skuId;
	}
	public void setSkuId(long skuId) {
		this.skuId = skuId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public AfterSale getAfterSale() {
		return afterSale;
	}
	public void setAfterSale(AfterSale afterSale) {
		this.afterSale = afterSale;
	}
	public AfterSalesOrder getAfterSalesOrder() {
		return afterSalesOrder;
	}
	public void setAfterSalesOrder(AfterSalesOrder afterSalesOrder) {
		this.afterSalesOrder = afterSalesOrder;
	}
	public AfterSaleListVo getAfterSaleListVo() {
		return afterSaleListVo;
	}
	public void setAfterSaleListVo(AfterSaleListVo afterSaleListVo) {
		this.afterSaleListVo = afterSaleListVo;
	}
	
	
}
