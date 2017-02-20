package cn.com.gome.trade.dto.io.rebate.request;

import java.io.Serializable;

/**
 * @Description: TODO 
 * @author: liutaiming
 * @date: 2015年5月26日 下午5:09:10
 */
public class TradeToRebateGoodsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String merchantId;//商家id

	private String kId;//唯一标识

	private String spuId;//spuId

	private String itemId;//商品ID

	private String skuId;//单品ID

	private String categoryFirstId;//类目1

	private String categorySecondId;//类目2

	private String categoryThirdId;//类目3

	private String categoryFourthId;//类目4

	private Long price;//精确到分

	private String retailId; //微店店主账号id
	
	private String microID; //微店ID
	
	private Integer buyNum; //购买数量
	
//    private String buyName; //购买人 
    
    private String skuName; //商品名称
    
    private String orderItemId; //子订单编号

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getkId() {
		return kId;
	}

	public void setkId(String kId) {
		this.kId = kId;
	}

	public String getRetailId() {
		return retailId;
	}

	public void setRetailId(String retailId) {
		this.retailId = retailId;
	}

	public String getSpuId() {
		return spuId;
	}

	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getCategoryFirstId() {
		return categoryFirstId;
	}

	public void setCategoryFirstId(String categoryFirstId) {
		this.categoryFirstId = categoryFirstId;
	}

	public String getCategorySecondId() {
		return categorySecondId;
	}

	public void setCategorySecondId(String categorySecondId) {
		this.categorySecondId = categorySecondId;
	}

	public String getCategoryThirdId() {
		return categoryThirdId;
	}

	public void setCategoryThirdId(String categoryThirdId) {
		this.categoryThirdId = categoryThirdId;
	}

	public String getCategoryFourthId() {
		return categoryFourthId;
	}

	public void setCategoryFourthId(String categoryFourthId) {
		this.categoryFourthId = categoryFourthId;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getMicroID() {
		return microID;
	}

	public void setMicroID(String microID) {
		this.microID = microID;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

//	public String getBuyName() {
//		return buyName;
//	}

//	public void setBuyName(String buyName) {
//		this.buyName = buyName;
//	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	
}
