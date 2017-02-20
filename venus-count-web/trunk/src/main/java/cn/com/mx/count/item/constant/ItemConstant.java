package cn.com.mx.count.item.constant;

/**
 * @Description: 商品常量 
 * @author: shanjie
 * @date: 2016年1月13日 下午3:53:08
 */
public class ItemConstant {

	/**
	 * 商品表
	 */
	public static final String TABLE_ECP_ITEMS = "ecp_items";
	

	/**
	 * 店铺表
	 */
	public static final String TABLE_ECP_SHOPS = "ecp_shops";
	
	/**
	 * vshop信息表
	 */
	public static final String TABLE_VSHOP_INFO  = "vshop_info";
	
	/**
	 * 分销信息表
	 */
	public static final String TABLE_VSHOP_DISTRIBUTION_ITEM = "vshop_distribution_item";
	
	/**
	 * 商品销量key
	 */
	public static final String ITEM_ITEMSALECOUNT_KEY = "item:itemsalecount:";
	
	
	/**
	 * 店铺内上架商品数
	 */
	public static final String ITEM_ITEMONSHELVESCOUNT_KEY = "shop:shopitemscount:";
	
	/**
	 * 分页条数
	 */
	public static final Integer ITEM_PAGINGSIZE = 100;
	
	
	public static enum ItemSaleCountEnum {
		FULL(0),
		SINGLECOUNT(1),
		SINGLESELECT(2);
		
		private Integer type;
		
		ItemSaleCountEnum(Integer type) {
			this.type = type;
		}
		
		public Integer getType() {
			return this.type;
		}
	}
}
