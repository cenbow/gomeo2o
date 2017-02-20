package cn.com.mx.count.bean;

import lombok.Data;

/**
 * @Description 商品收藏实体 
 * @author zhaochenyu
 * @date 2016年1月12日 上午11:43:45
 */
public class ProductCollectCountBean {
	
	private Long productId;
	
	private Long count;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
