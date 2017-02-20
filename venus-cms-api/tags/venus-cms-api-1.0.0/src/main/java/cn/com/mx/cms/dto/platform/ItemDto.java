package cn.com.mx.cms.dto.platform;

import java.io.Serializable;

import com.gomeo2o.common.entity.CommonResultEntity;

public class ItemDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;// 商品名称
	private Integer price;// 商品价格
	private String mainImage;// 商品图片URL *４
	private Long shopId;// 商铺id
	private String shopName;// 商铺名
	private Integer saleQuantity;// 销量数
	private Long collectNum;// 收藏数

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getSaleQuantity() {
		return saleQuantity;
	}

	public void setSaleQuantity(Integer saleQuantity) {
		this.saleQuantity = saleQuantity;
	}

	public Long getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(Long num) {
		this.collectNum = num;
	}

}
