package cn.com.mx.cms.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 精选店铺
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class ShopVo implements Serializable {

	private static final long serialVersionUID = 8398737338403362554L;
	// 店铺logo
	private String shopLogo = "";
	// 店铺名称
	private String shopName = "";
	// 收藏数
	private int collectionNum = 0;
	// 商品数
	private int productNum = 0;
	// 总销量
	private int sellCount;
	// 店铺id
	private long shopId;
	// ”直降”,”满减”,”团购”，”优惠”,"返利"
	private List<String> label = new ArrayList<String>();
	//是否返利
	private boolean rebateStatus;
	//是否优惠(直降)
	private boolean privilegeStatus;
	
	private String keywords;

	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getSellCount() {
		return sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public List<String> getLabel() {
		return label;
	}

	public void setLabel(List<String> label) {
		this.label = label;
	}

	public int getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(int collectionNum) {
		this.collectionNum = collectionNum;
	}

	public boolean isRebateStatus() {
		return rebateStatus;
	}

	public void setRebateStatus(boolean rebateStatus) {
		this.rebateStatus = rebateStatus;
	}

	public boolean isPrivilegeStatus() {
		return privilegeStatus;
	}

	public void setPrivilegeStatus(boolean privilegeStatus) {
		this.privilegeStatus = privilegeStatus;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
}
