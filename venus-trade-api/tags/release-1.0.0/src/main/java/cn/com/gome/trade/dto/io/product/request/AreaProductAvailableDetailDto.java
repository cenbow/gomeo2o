/**
 * @类名: AreaProductAvailableDetailDto.java
 * @作者： libin-ds9
 * @创建时间 2015年5月13日 下午6:05:42
 */
package cn.com.gome.trade.dto.io.product.request;

import java.io.Serializable;

/**
 * @描述:
 * @作者 libin-ds9
 * @创建时间 2015年5月13日 下午6:05:42
 */
public class AreaProductAvailableDetailDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 商品类型
	 */
	private String category; //商品类型 对应SAP的第三级商品类型

	/**
	 * 商品库区可卖属性
	 */
	private String itemFlag = "N";  //商品库区可卖属性  ‘N’ – Normal Item (一般商品)

	/**
	 * 商品编码
	 */
	private String partNum; //商品编码

	/**
	 * 数量
	 */
	private Integer qty = 1;  //数量

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the itemFlag
	 */
	public String getItemFlag() {
		return itemFlag;
	}

	/**
	 * @param itemFlag
	 *            the itemFlag to set
	 */
	public void setItemFlag(String itemFlag) {
		this.itemFlag = itemFlag;
	}

	/**
	 * @return the partNum
	 */
	public String getPartNum() {
		return partNum;
	}

	/**
	 * @param partNum
	 *            the partNum to set
	 */
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	/**
	 * @return the qty
	 */
	public Integer getQty() {
		return qty;
	}

	/**
	 * @param qty
	 *            the qty to set
	 */
	public void setQty(Integer qty) {
		this.qty = qty;
	}

}
