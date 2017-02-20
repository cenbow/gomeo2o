package cn.com.mx.count.item.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.item.bean.Item;
import cn.com.mx.count.item.constant.ItemConstant;
import cn.com.mx.count.template.BaseSqlTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.template.SimpleSqlTemplate;
import cn.com.mx.count.template.SimpleSqlTemplate.SqlCallback;

import com.alibaba.druid.util.StringUtils;

/**
 * @Description: TODO
 * @author: shanjie
 * @date: 2016年1月13日 下午5:22:56
 */
@Slf4j
public class ItemTemplate {

	/**
	 * @Description: 统计入口
	 * @author: shanjie
	 * @date: 2016年1月14日 上午11:21:31
	 * @param itemId
	 * @param seeType
	 * @return
	 */
	public static String itemSaleCountHandler(Integer itemId, Integer type) {
		try {
			Map<String, Object> map;
			/*
			 * type:0执行全量统计 type:1执行单个商品统计 type:2执行单个商品查询
			 */
			if (type == ItemConstant.ItemSaleCountEnum.FULL.getType()) {
				return itemSaleFullCountHandler();
			}
			if (type == ItemConstant.ItemSaleCountEnum.SINGLECOUNT.getType()) {
				map = new HashMap<String, Object>();
				//不过滤商品状态
//				map.put("status", 1);
				map.put("id", itemId);
				int itemResult = getItemSaleQuantityForSingle(itemId, map);
				if(itemResult < 0) {
					return "商品id不存在。";
				} else {
					return "商品id：" + itemId + 
							", redis计数状态：" + setItemSaleQuantity(Long.valueOf(itemId), itemResult)
							+ ", redis计数结果：" + CacheCount.get(ItemConstant.ITEM_ITEMSALECOUNT_KEY + itemId);
				}
			} else if (type == ItemConstant.ItemSaleCountEnum.SINGLESELECT
					.getType() && itemId != 0) {
				map = new HashMap<String, Object>();
				//不过滤商品状态
//				map.put("status", 1);
				map.put("id", itemId);
				int itemResult = getItemSaleQuantityForSingle(itemId, map);
				if(itemResult < 0) {
					return "商品id不存在。redis商品销量为:" + CacheCount.get(ItemConstant.ITEM_ITEMSALECOUNT_KEY + itemId);
				} else {
					return "商品编码：" + itemId
							+ "的redis商品销量为:" + CacheCount.get(ItemConstant.ITEM_ITEMSALECOUNT_KEY + itemId) + 
							", 数据库商品销量为:" + itemResult;
				}
			} else {
				return "type的输入条件不符合规范，请重新输入。";
			}
		} catch(Exception e) {
			log.error("商品销量统计异常。", e);
			return "商品销量统计异常。" + e.getMessage();
		}
	}

	/**
	 * @Description: 销量全量统计入口
	 * @author: shanjie
	 * @date: 2016年1月14日 上午11:19:30
	 * @return
	 */
	private static String itemSaleFullCountHandler() {
		int successCount = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		//不过滤商品状态
//		map.put("status", 1);

		long count = BaseSqlTemplate
				.getCount(ItemConstant.TABLE_ECP_ITEMS, map);
		for (int i = 1; i <= (count / ItemConstant.ITEM_PAGINGSIZE + 1); i++) {
			List<Item> items = pagingItems(i, ItemConstant.ITEM_PAGINGSIZE, map);
			for (Item item : items) {
				// 商品销量统计处理
				try {
					if (!StringUtils.isEmpty(setItemSaleQuantity(item.getId(),
							item.getSaleQuantity()))) {
						successCount++;
					}
				} catch (Exception e) {
					log.error("itemsalecount incrBy got an error. itemId: {}",
							item.getId(), e);
				}
			}
		}

		return "商品销量统计（全量）共处理" + successCount + "条数据。";
	}

	/**
	 * @Description: 商品分页
	 * @author: shanjie
	 * @date: 2016年1月13日 下午5:22:40
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public static List<Item> pagingItems(final Integer pageNo,
			final Integer pageSize, final Map<String, Object> map) {

		SimpleSqlTemplate sst = new SimpleSqlTemplate();
		List<Item> items = sst.execute(new SqlCallback<List<Item>>() {
			@Override
			public List<Item> done(Connection conn) {
				try {
					return (List<Item>) BaseSqlTemplate.pagingObjects(
							ItemConstant.TABLE_ECP_ITEMS, pageNo, pageSize,
							map, Item.class);
				} catch (Exception e) {
					log.error("pagingObjects error. ", e);
					return new ArrayList<Item>();
				}
			}
		});

		return items;
	}

	/**
	 * @Description: TODO
	 * @author: shanjie
	 * @date: 2016年1月14日 上午11:18:00
	 * @param itemId
	 * @param saleQuantity
	 * @return
	 */
	private static String setItemSaleQuantity(final Long itemId,
			final Integer saleQuantity) {

		SimpleSqlTemplate sst = new SimpleSqlTemplate();
		return sst.execute(new SqlCallback<String>() {
			@Override
			public String done(Connection conn) {
				try {
					return CacheCount.set(ItemConstant.ITEM_ITEMSALECOUNT_KEY
							+ itemId, saleQuantity);
				} catch (Exception e) {
					log.error("itemSaleQuantity got an error. itemID:{}",
							itemId, e);
					return "";
				}
			}
		});
	}

	/**
	 * @Description: 查询单个商品销量
	 * @author: shanjie
	 * @date: 2016年1月14日 下午2:39:24
	 * @param itemId
	 * @return
	 */
	private static Integer getItemSaleQuantityForSingle(final Integer itemId, final Map<String, Object> map) {
		SimpleSqlTemplate sst = new SimpleSqlTemplate();
		return sst.execute(new SqlCallback<Integer>() {
			@Override
			public Integer done(Connection conn) {
				PreparedStatement pstm = null;
				ResultSet rs = null;
				Integer saleQuantity = 0;
				try {
					String sql = "select sale_quantity from " +
					BaseSqlTemplate.getConditionSql(ItemConstant.TABLE_ECP_ITEMS, null, null, map);
					pstm = conn.prepareStatement(sql);
					rs = pstm.executeQuery();
					if (rs.next()) {
						saleQuantity = (Integer) rs.getInt("sale_quantity");
					} else {
						saleQuantity = -1;
					}
				} catch (Exception e) {
					log.error("查询出错！", e);
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (Exception e) {
							log.error("关闭ResultSet出错", e);
						}
					}
					if (pstm != null) {
						try {
							pstm.close();
						} catch (Exception e) {
							log.error("关闭PreparedStatement出错", e);
						}
					}
				}
				return saleQuantity;
			}
		});
	}
}
