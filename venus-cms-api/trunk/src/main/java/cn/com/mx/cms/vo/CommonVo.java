package cn.com.mx.cms.vo;

import java.io.Serializable;

/**
 * 
 * @Description 普通推荐 
 * @author zhangxianpeng
 * @date 2015年11月30日 下午6:23:44
 */
public class CommonVo implements Serializable {
	
	private static final long serialVersionUID = -6572226122624941167L;
	// 类型：店铺、商品
	private int type;
	//店铺id
    private long shopId;
    //运营上传的图片
    private String imageUrl = "";
    //商品id
    private long productId;
    
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
}
