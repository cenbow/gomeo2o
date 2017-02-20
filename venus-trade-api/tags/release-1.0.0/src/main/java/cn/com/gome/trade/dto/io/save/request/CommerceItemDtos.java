/**   
 * @Title: CommerceItemDtos.java 
 * @Package com.gomeo2o.facade.order.vo 
 * @Description: TODO
 * @author: liupeiqi 
 * @date 2015年3月27日 上午10:49:12 
 * @version V1.0   
 */

package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;

/**
 * @ClassName: CommerceItemDtos
 * @Description: TODO
 * @author liupeiqi
 * @date 2015年3月27日 上午10:49:12
 * 
 */

public class CommerceItemDtos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productId; // 产品ID 可空N

	private String skuId; // SKUID 可空N

	private String quantity; // 单个配送单商品数量 可空N

	private String bulkFlag = "N"; // 超大超重标识 可空N Y或者 NitemPriceInfoDto

	private String type = "commerceItem"; // 商品类型 可空N 正常商品/赠品[commerceItem,
											// freeCommerceItem]

	private ItemPriceInfoDto itemPriceInfoDto = new ItemPriceInfoDto(); // 商品价格列表

	/**
	 * @return productId
	 */

	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return skuId
	 */

	public String getSkuId() {
		return skuId;
	}

	/**
	 * @param skuId
	 *            the skuId to set
	 */
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	/**
	 * @return quantity
	 */

	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return bulkFlag
	 */

	public String getBulkFlag() {
		return bulkFlag;
	}

	/**
	 * @param bulkFlag
	 *            the bulkFlag to set
	 */
	public void setBulkFlag(String bulkFlag) {
		this.bulkFlag = bulkFlag;
	}

	/**
	 * @return type
	 */

	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return itemPriceInfoDto
	 */

	public ItemPriceInfoDto getItemPriceInfoDto() {
		return itemPriceInfoDto;
	}

	/**
	 * @param itemPriceInfoDto
	 *            the itemPriceInfoDto to set
	 */
	public void setItemPriceInfoDto(ItemPriceInfoDto itemPriceInfoDto) {
		this.itemPriceInfoDto = itemPriceInfoDto;
	}
}
