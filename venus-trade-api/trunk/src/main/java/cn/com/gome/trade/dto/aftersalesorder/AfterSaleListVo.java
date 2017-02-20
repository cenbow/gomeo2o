package cn.com.gome.trade.dto.aftersalesorder;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @Description: 退款/售后  订单列表 
 * @author: hanminglei
 * @date: 2015-5-30 下午4:40:47
 */
public class AfterSaleListVo {
	
	private int orderType; //订单类型   1 普通订单   4 国美订单
	
	private String afterSaleType;	//售后类型
	private String afterSaleTypeName;//售后类型 中文解释
	private long afterSaleId;		//售后单号
	private String Status;			//售后状态
	private String statusName;//售后状态中文解释
	private String refundAmount;		//退款金额/实付金额
	private String orderMoney;		//支付总金额
	private String shipFee;		//运费
	private int totalCount;			//商品总数量
	private String reason;//退货，换货  理由
	private String remark;//退货，换货  说明
	private long orderId; //订单ID
	private boolean hasLogistics;//是否有物流
	private long buyerId; //买家ID
	
	private String vshopCommission="0"; //美店佣金
	private String maxRefundShipFee;		//退运费的最大金额(即为订单的运费金额)
	//优惠组合信息
	private String platFormRedPacketDiscount; 	//通用红包优惠抵扣
	private String shopRedPacketDiscount; 	//店铺红包优惠抵扣
	private String oncePurchaseDiscount; //下单立减金额
	private String gomeMoneyDiscount; 	//国美币优惠抵扣
	private String originFee;   //订单原价
	private String shopDiscount;  //店铺直降价格
 
	private String buyerSendGoodsMehtod;// 买家发货的方式    //上门自取:  {"deliverMethod":"GOME_PICKUP","mailAddress":"上海市闵行区西畴路376号"}
	private String buyerSendGoodsAddress;//买家发货的地址    //第三方物流： {"deliverMethod":"CUSTOMER_SEND_BACK","mailAddress":null}
	private List<OrderProductVo> productList = new ArrayList<OrderProductVo>(); //商品list
	
	public String getAfterSaleType() {
		return afterSaleType;
	}
	public void setAfterSaleType(String afterSaleType) {
		this.afterSaleType = afterSaleType;
	}
	public long getAfterSaleId() {
		return afterSaleId;
	}
	public void setAfterSaleId(long afterSaleId) {
		this.afterSaleId = afterSaleId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<OrderProductVo> getProductList() {
		return productList;
	}
	public void setProductList(List<OrderProductVo> productList) {
		this.productList = productList;
	}
	
	public String getAfterSaleTypeName() {
		return afterSaleTypeName;
	}
	public void setAfterSaleTypeName(String afterSaleTypeName) {
		this.afterSaleTypeName = afterSaleTypeName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getBuyerSendGoodsMehtod() {
		return buyerSendGoodsMehtod;
	}
	public void setBuyerSendGoodsMehtod(String buyerSendGoodsMehtod) {
		this.buyerSendGoodsMehtod = buyerSendGoodsMehtod;
	}
	public String getBuyerSendGoodsAddress() {
		return buyerSendGoodsAddress;
	}
	public void setBuyerSendGoodsAddress(String buyerSendGoodsAddress) {
		this.buyerSendGoodsAddress = buyerSendGoodsAddress;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public String getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(String orderMoney) {
		this.orderMoney = orderMoney;
	}
	public boolean isHasLogistics() {
		return hasLogistics;
	}
	public void setHasLogistics(boolean hasLogistics) {
		this.hasLogistics = hasLogistics;
	}
	public String getShipFee() {
		return shipFee;
	}
	public void setShipFee(String shipFee) {
		this.shipFee = shipFee;
	}
	public long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	public String getVshopCommission() {
		return vshopCommission;
	}
	public void setVshopCommission(String vshopCommission) {
		this.vshopCommission = vshopCommission;
	}
	public String getMaxRefundShipFee() {
		return maxRefundShipFee;
	}
	public void setMaxRefundShipFee(String maxRefundShipFee) {
		this.maxRefundShipFee = maxRefundShipFee;
	}
	public String getPlatFormRedPacketDiscount() {
		return platFormRedPacketDiscount;
	}
	public void setPlatFormRedPacketDiscount(String platFormRedPacketDiscount) {
		this.platFormRedPacketDiscount = platFormRedPacketDiscount;
	}
	public String getShopRedPacketDiscount() {
		return shopRedPacketDiscount;
	}
	public void setShopRedPacketDiscount(String shopRedPacketDiscount) {
		this.shopRedPacketDiscount = shopRedPacketDiscount;
	}
	public String getGomeMoneyDiscount() {
		return gomeMoneyDiscount;
	}
	public void setGomeMoneyDiscount(String gomeMoneyDiscount) {
		this.gomeMoneyDiscount = gomeMoneyDiscount;
	}
	public String getOriginFee() {
		return originFee;
	}
	public void setOriginFee(String originFee) {
		this.originFee = originFee;
	}
	public String getShopDiscount() {
		return shopDiscount;
	}
	public void setShopDiscount(String shopDiscount) {
		this.shopDiscount = shopDiscount;
	}
	public String getOncePurchaseDiscount() {
		return oncePurchaseDiscount;
	}
	public void setOncePurchaseDiscount(String oncePurchaseDiscount) {
		this.oncePurchaseDiscount = oncePurchaseDiscount;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	@Override
	public String toString() {
		return "AfterSaleListVo [orderType=" + orderType + ", afterSaleType="
				+ afterSaleType + ", afterSaleTypeName=" + afterSaleTypeName
				+ ", afterSaleId=" + afterSaleId + ", Status=" + Status
				+ ", statusName=" + statusName + ", totalMoney=" + refundAmount
				+ ", orderMoney=" + orderMoney + ", shipFee=" + shipFee
				+ ", totalCount=" + totalCount + ", reason=" + reason
				+ ", remark=" + remark + ", orderId=" + orderId
				+ ", hasLogistics=" + hasLogistics + ", buyerId=" + buyerId
				+ ", vshopCommission=" + vshopCommission
				+ ", maxRefundShipFee=" + maxRefundShipFee
				+ ", platFormRedPacketDiscount=" + platFormRedPacketDiscount
				+ ", shopRedPacketDiscount=" + shopRedPacketDiscount
				+ ", gomeMoneyDiscount=" + gomeMoneyDiscount + ", originFee="
				+ originFee + ", shopDiscount=" + shopDiscount
				+ ", buyerSendGoodsMehtod=" + buyerSendGoodsMehtod
				+ ", buyerSendGoodsAddress=" + buyerSendGoodsAddress
				+ ", productList=" + productList + "]";
	}
	
	
}
