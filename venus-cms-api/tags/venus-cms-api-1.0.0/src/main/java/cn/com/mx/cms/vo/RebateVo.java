package cn.com.mx.cms.vo;

import java.io.Serializable;

/**
 * @Description 超级返
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:30
 */
public class RebateVo implements Serializable {

	private static final long serialVersionUID = 3302022192414177847L;
	//类型:商品,店铺,h5
	private int type;
	
	//类型名称
	private String typeName;
	
	//上传的图片
	private String image = "";
	//店铺id
	private long shopId;
	//商品id
	private long productId;
	//h5页面url
	private String url = "";
	
	//-------------
	private String dataId;
	private String pictureUrl;//展示

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	

}
