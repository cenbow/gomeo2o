package cn.com.mx.cms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 精品推荐
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class ProductVo implements Serializable {

	private static final long serialVersionUID = 6368871478876396936L;
	//商品id
	private long productId;
	//商品名称
	private String productName = "";
	//商品价格
	private String productPrice = "";
	//返利价格
	private String rebatePrice = "";
	//销量
	private int sellNum = 0;
	//店铺名称
	private String shopName = "";
	//收藏数
	private int collectionNum = 0;
	//被分享次数
	private int shareNum = 0;
	//店铺id
	private long shopId;
	//商品图片列表
	private List<String> image = new ArrayList<String>();

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getRebatePrice() {
		return rebatePrice;
	}

	public void setRebatePrice(String rebatePrice) {
		this.rebatePrice = rebatePrice;
	}

	public int getSellNum() {
		return sellNum;
	}

	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(int collectionNum) {
		this.collectionNum = collectionNum;
	}

	public int getShareNum() {
		return shareNum;
	}

	public void setShareNum(int shareNum) {
		this.shareNum = shareNum;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductVo [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", rebatePrice=" + rebatePrice + ", sellNum=" + sellNum + ", shopName=" + shopName + ", collectionNum=" + collectionNum + ", shareNum=" + shareNum + ", shopId=" + shopId
				+ ", image=" + image + "]";
	}

}
