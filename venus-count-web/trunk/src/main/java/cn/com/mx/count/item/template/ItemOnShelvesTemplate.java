package cn.com.mx.count.item.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;






import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.item.bean.Shop;
import cn.com.mx.count.item.bean.VshopInfo;
import cn.com.mx.count.item.constant.ItemConstant;
import cn.com.mx.count.template.BaseSqlTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.StringUtil;

@Slf4j
@SuppressWarnings("all")
public class ItemOnShelvesTemplate {
	/**
	 * @Description 店铺下上架商品数全量更新 
	 * @author shangpengfei
	 * @date 2016年1月14日 上午11:38:02
	 * @return
	 */
	public static String itemOnShelvesCount(){
		String result = "";
		Map<String, Object> map = new HashMap<String, Object>();
		long shopCount = 0l;
		//取总店铺数
		try {
			shopCount = BaseSqlTemplate.getCount(ItemConstant.TABLE_VSHOP_INFO, map);
		} catch (Exception e) {
			log.error("get shopCount fail", e);
		}
		result += "总店铺数:" + shopCount + "";
		Long allItemsCount = 0l;
		List<VshopInfo> shops = new ArrayList<VshopInfo>();
		for (int i = 1; i <= shopCount/10 + 1; i++) {
			try {
				shops = BaseSqlTemplate.pagingObjects(ItemConstant.TABLE_VSHOP_INFO, i, 10, map, VshopInfo.class);
			} catch (Exception e) {
				log.error("get shops fail", e);
			}
			if (shops != null && shops.size() > 0) {
				for (VshopInfo shop : shops) {
					if (shop.getVshopType() == 2) {    //xpop商户
						map.put("status", 1);
						map.put("shop_id", shop.getVshopId());
						try {
							long itemCount = BaseSqlTemplate.getCount(ItemConstant.TABLE_ECP_ITEMS, map);
							CacheCount.set(ItemConstant.ITEM_ITEMONSHELVESCOUNT_KEY+shop.getVshopId(), itemCount);
							allItemsCount += itemCount;
						} catch (Exception e) {
							log.error("get itemCount fail, shop_id:{}", shop.getVshopId(), e);
						}
						map.remove("shop_id");
						map.remove("status");
					}
					if (shop.getVshopType() == 1) {     //美店
						map.put("status", 1);
						map.put("is_delete", 0);
						map.put("vshop_id", shop.getVshopId());
						try {
							long vshopitemCount = BaseSqlTemplate.getCount(ItemConstant.TABLE_VSHOP_DISTRIBUTION_ITEM, map);
							CacheCount.set(ItemConstant.ITEM_ITEMONSHELVESCOUNT_KEY+shop.getVshopId(), vshopitemCount);
							allItemsCount += vshopitemCount;
						} catch (Exception e) {
							log.error("get itemCount fail, shop_id:{}", shop.getVshopId(), e);
						}
						map.remove("vshop_id");
						map.remove("is_delete");
						map.remove("status");
					}
				}
			}
		}
		result += "总商品数：" + allItemsCount;
		return result;
	}
	
	
	/**
	 * @Description 单个店铺下上架商品数更新 
	 * @author shangpengfei
	 * @date 2016年1月14日 上午11:38:48
	 * @param shopid
	 * @return
	 */
	public static String itemSingleCount(String shopid, Integer type){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", 1);
		if (shopid != null && StringUtil.isNumeric(shopid)) {
//			Map<String, Object> m = new HashMap<String, Object>();
//			m.put("id", shopid);
//			m.put("status", 1);
//			if (BaseSqlTemplate.getCount(ItemConstant.TABLE_ECP_SHOPS, m) != 1) {
//				return "店铺Id：" + shopid + "，店铺不存在或店铺已被冻结或未处于审核通过状态！";
//			}
			List<VshopInfo> vshopInfos = new ArrayList<VshopInfo>();
			try {
				String sql = "SELECT * FROM vshop_info WHERE vshop_id = "+ shopid;
				vshopInfos =  BaseSqlTemplate.pagingObjectsBySql(sql, VshopInfo.class);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (type == 0) {
				try {
//					String sql = "SELECT * FROM vshop_info WHERE vshop_id = "+ shopid;
//					List<VshopInfo> vshopInfos =  BaseSqlTemplate.pagingObjectsBySql(sql, VshopInfo.class);
					if (vshopInfos.get(0).getVshopType() == 2) {
						map.put("shop_id", shopid);
						CacheCount.set(ItemConstant.ITEM_ITEMONSHELVESCOUNT_KEY+shopid, BaseSqlTemplate.getCount(ItemConstant.TABLE_ECP_ITEMS, map));
					}
					if (vshopInfos.get(0).getVshopType() == 1) {
						map.put("is_delete", 0);
						map.put("vshop_id", shopid);
						CacheCount.set(ItemConstant.ITEM_ITEMONSHELVESCOUNT_KEY+shopid, BaseSqlTemplate.getCount(ItemConstant.TABLE_VSHOP_DISTRIBUTION_ITEM, map));
					}
					return "店铺" + shopid + "下商品数：" + CacheCount.get(ItemConstant.ITEM_ITEMONSHELVESCOUNT_KEY+shopid);
				} catch (Exception e) {
					log.error("店铺内上架商品统计异常，shopid: {}", shopid, e);
					return "店铺内上架商品统计异常" + e.getMessage();
				}
			} else if (type == 1) {
				try {
					if (vshopInfos.get(0).getVshopType() == 2) {
						map.put("shop_id", shopid);
						return "店铺Id：" + shopid + "，Redis上架商品数：" + CacheCount.get(ItemConstant.ITEM_ITEMONSHELVESCOUNT_KEY+shopid) + 
								"，数据库上架商品数：" + BaseSqlTemplate.getCount(ItemConstant.TABLE_ECP_ITEMS, map);
					}
					if (vshopInfos.get(0).getVshopType() == 1) {
						map.put("is_delete", 0);
						map.put("vshop_id", shopid);
						return "店铺Id：" + shopid + "，Redis上架商品数：" + CacheCount.get(ItemConstant.ITEM_ITEMONSHELVESCOUNT_KEY+shopid) + 
								"，数据库上架商品数：" + BaseSqlTemplate.getCount(ItemConstant.TABLE_VSHOP_DISTRIBUTION_ITEM, map);
					}
				} catch (Exception e) {
					log.error("店铺内上架商品查询异常，shopid: {}", shopid, e);
					return "店铺内上架商品查询异常" + e.getMessage();
				}
			} else {
				return "type输入不符合规范，请重新输入！";
			}
		}
		return "shopid输入不符合规范，请重新输入！";
	}
}
