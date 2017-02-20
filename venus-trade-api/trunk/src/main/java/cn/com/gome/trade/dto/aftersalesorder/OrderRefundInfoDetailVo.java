package cn.com.gome.trade.dto.aftersalesorder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * @Description: 管理-订单-退款单详情 
 * @author: hanminglei
 * @date: 2015-5-29 下午2:42:38
 */
public class OrderRefundInfoDetailVo implements Serializable{
//卖家版
	//订单和子订单号
	private long orderId;  //订单号
	private long orderItemId;  //子订单号
	private Integer orderType; //订单类型  1 普通订单  4 国美订单
	private Integer productTotalCount; // 售后单商品总量
	
	//退款订单Top展示
	private long afterSaleId;			//售后单号
	private String afterSaleType;		//售后方式
	private String afterSaleTypeName;//售后方式  中文翻译
	private Integer afterSaleStatus;		//售后单状态
	private String afterSaleStatusName;//售后单状态  中文翻译
	//商品信息
	private List<OrderProductVo> productList = new ArrayList<OrderProductVo>();		//商品list
	//退款金额
	private String returnMoney;			//退款金额
	private String returnGomeMoney;		//退还国美币金额
	
	
	//private int productTotalCount;		//商品总数量
	
	//退款信息
	private Integer payType;				//支付方式
	private String payTypeName;//支付方式  中文翻译
	private String refundReturnType;	//退款返回方式
	//private String buyerNickName;	//买家昵称
	private String buyerId;//买家ID
	private String buyerMobile;		//买家联系方式
	private String refundType; 		//退款类型
	
	private String applyTime;		//申请时间
	private String agreeRefundAtTime;		//卖家操作退款的时间
	private String overTime;		//退款完成时间
	
//买家版	
	//收货人信息
	private String receiverName;	    //收货人姓名
	private String receiverMobile;	//收货人电话
	private String receiverAddress;	//收货人地址
	
	private String shopName;        //店铺名称
	private long   sellerId;  //卖家ID
	private long  shopId;     //店铺ID
	//退换货买家发货方式
	private String buyerSendGoodsMehtod; //买家发货方式
	private String buyerSendGoodsAddress;//买家发货地址
	//配送信息
	private int deliveryTimeType;//送货时间类型
	private String deliveryTimeTypeDesc;//送货时间类型 1 只工作日送货     2  只双休、假日送货  3 工作日、双休日与假日均可送货
	private boolean deliveryConfirm;//送货前是否确认
	private String deliveryMemo;//送货备注 
	private boolean hasLogistics; //是否走物流
	//发票信息
	private int invoiceType;//发票类型
	private String invoiceTypeDesc;//发票类型 1 普通发票  2 增值发票
	private String invoiceTitle;//发票抬头
	private String invoiceTitleDesc;//发票抬头  1 个人 2 公司
	private String invoiceContent;//发票内容
	//付款金额信息
	private String shipFee;		//运费 
	private String maxRefundShipFee;		//运费 
	private String platFormRedPacketDiscount; 	//通用红包优惠抵扣
	private String shopRedPacketDiscount; 	//店铺红包优惠抵扣
	private String oncePurchaseDiscount; //下单立减金额
	private String gomeMoneyDiscount; 	//国美币优惠抵扣
	private String payMoney;	//实付款（含运费）
	private String originFee;   //订单原价
	private String shopDiscount;  //店铺直降价格
	
	//订单时间
	private String orderTime;	//下单时间
	private String payTime;		//付款时间 
//	private Date applyTime;	//申请时间 
	
	
	private String returnReason;	//退货原因
	private String returnExplain;	//退货说明
	public String getPayTypeName() {
		return payTypeName;
	}
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
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

	public String getReturnMoney() {
		return returnMoney;
	}
	public void setReturnMoney(String returnMoney) {
		this.returnMoney = returnMoney;
	}
	public String getReturnGomeMoney() {
		return returnGomeMoney;
	}
	public void setReturnGomeMoney(String returnGomeMoney) {
		this.returnGomeMoney = returnGomeMoney;
	}

	public String getRefundReturnType() {
		return refundReturnType;
	}
	public void setRefundReturnType(String refundReturnType) {
		this.refundReturnType = refundReturnType;
	}

	public String getBuyerMobile() {
		return buyerMobile;
	}
	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}
	public String getRefundType() {
		return refundType;
	}
	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public String getReturnExplain() {
		return returnExplain;
	}
	public void setReturnExplain(String returnExplain) {
		this.returnExplain = returnExplain;
	}


	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	public String getAfterSaleTypeName() {
		return afterSaleTypeName;
	}
	public void setAfterSaleTypeName(String afterSaleTypeName) {
		this.afterSaleTypeName = afterSaleTypeName;
	}
	public Integer getAfterSaleStatus() {
		return afterSaleStatus;
	}
	public void setAfterSaleStatus(Integer afterSaleStatus) {
		this.afterSaleStatus = afterSaleStatus;
	}
	public String getAfterSaleStatusName() {
		return afterSaleStatusName;
	}
	public void setAfterSaleStatusName(String afterSaleStatusName) {
		this.afterSaleStatusName = afterSaleStatusName;
	}
	public List<OrderProductVo> getProductList() {
		return productList;
	}
	public void setProductList(List<OrderProductVo> productList) {
		this.productList = productList;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public int getDeliveryTimeType() {
		return deliveryTimeType;
	}
	public void setDeliveryTimeType(int deliveryTimeType) {
		this.deliveryTimeType = deliveryTimeType;
	}
	public boolean isDeliveryConfirm() {
		return deliveryConfirm;
	}
	public void setDeliveryConfirm(boolean deliveryConfirm) {
		this.deliveryConfirm = deliveryConfirm;
	}
	public String getDeliveryMemo() {
		return deliveryMemo;
	}
	public void setDeliveryMemo(String deliveryMemo) {
		this.deliveryMemo = deliveryMemo;
	}
	public int getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(int invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getInvoiceContent() {
		return invoiceContent;
	}
	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
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
	public String getShipFee() {
		return shipFee;
	}
	public void setShipFee(String shipFee) {
		this.shipFee = shipFee;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public Integer getPayType() {
		return payType;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
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
	public String getDeliveryTimeTypeDesc() {
		return deliveryTimeTypeDesc;
	}
	public void setDeliveryTimeTypeDesc(String deliveryTimeTypeDesc) {
		this.deliveryTimeTypeDesc = deliveryTimeTypeDesc;
	}
	public String getInvoiceTypeDesc() {
		return invoiceTypeDesc;
	}
	public void setInvoiceTypeDesc(String invoiceTypeDesc) {
		this.invoiceTypeDesc = invoiceTypeDesc;
	}
	public String getInvoiceTitleDesc() {
		return invoiceTitleDesc;
	}
	public void setInvoiceTitleDesc(String invoiceTitleDesc) {
		this.invoiceTitleDesc = invoiceTitleDesc;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getProductTotalCount() {
		return productTotalCount;
	}
	public void setProductTotalCount(Integer productTotalCount) {
		this.productTotalCount = productTotalCount;
	}
	public boolean isHasLogistics() {
		return hasLogistics;
	}
	public void setHasLogistics(boolean hasLogistics) {
		this.hasLogistics = hasLogistics;
	}
	public String getAgreeRefundAtTime() {
		return agreeRefundAtTime;
	}
	public void setAgreeRefundAtTime(String agreeRefundAtTime) {
		this.agreeRefundAtTime = agreeRefundAtTime;
	}
	public String getMaxRefundShipFee() {
		return maxRefundShipFee;
	}
	public void setMaxRefundShipFee(String maxRefundShipFee) {
		this.maxRefundShipFee = maxRefundShipFee;
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
	
}
