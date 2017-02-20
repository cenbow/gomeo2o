package cn.com.mx.count.shop.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.bean.ProductCollectCountBean;
import cn.com.mx.count.factory.MysqlConnectionFactory;
import cn.com.mx.count.item.bean.Item;
import cn.com.mx.count.template.BaseSqlTemplate;
import cn.com.mx.count.template.CacheCount;

import java.sql.Connection;

/**
 * @Description 商品收藏统计 模板
 * @author zhaochenyu
 * @date 2016年1月15日 上午11:28:11
 */
@Slf4j
public class ProductCollectCountTemplate {
	
	private static final String SHOP = "shop";
	
	private static final String PRODUCT_COLLECTCOUNT = "productcollectcount" ;
	
	private static final String TABLE_MEMBER_GOODS_FAVORITE = "member_goods_favorite";
	
	private static final String STATUS = "status";
	
	private static final String PRODUCT_ID = "product_id";
	
	private static final String IS_SINGLE = "1";
	
	private static final String IS_NOT_SINGLE = "0";
	
	/**
	 * @Description 全量统计和查询的判断 
	 * @author zhaochenyu
	 * @date 2016年1月13日 下午3:42:59
	 */
	public static String setOrGetPorductCollectToRedis(String type,
			String isSingle, Long productId) {
		String returnValue;
		if (IS_NOT_SINGLE.equals(isSingle)) {
			// 全量统计
			setProductCollectCountToRedis();
			long count = getDistinctProductCollectCount();
			returnValue = "全量统计，统计的商品条数为: " + count;
		} else {
			//单个
			if ("1".equals(type)) {
				// 单个统计
				setSingleProductCollectCountToRedis(productId,isSingle);
				returnValue = "单个统计成功";
			} else if ("2".equals(type)) {
				// 如果是查询,只能是单个查询
				Long count = getSingleProductCollectCountToRedis(productId);
				returnValue = "商品id: " + productId + " 统计数: " + count;
			} else {
				returnValue = "请输入正确的type值";
			}
		}
		return returnValue;
	}
	
	/**
	 * @Description 把全部商品收藏数设置到redis中 
	 * @author zhaochenyu
	 * @date 2016年1月13日 下午3:42:59
	 */
	public static void setProductCollectCountToRedis() {
		//得到member_goods_favorite 表的总页数
		int itemCount = (int) BaseSqlTemplate.getCount(TABLE_MEMBER_GOODS_FAVORITE, new HashMap<String, Object>()) / 10 + 1;
		for (int i = 1; i <= itemCount; i++) {
			//分页查询member_goods_favorite表，得到每页的count
			String sql = "select "+ PRODUCT_ID + ",count(1) count from (select * from " + TABLE_MEMBER_GOODS_FAVORITE +" limit "+ (i-1)*10 + ",10) A group by product_id";
			List<ProductCollectCountBean> proCollectList = BaseSqlTemplate.pagingObjectsBySql(sql,ProductCollectCountBean.class);
			for (ProductCollectCountBean proCollectBean : proCollectList) {
					//每页的count在redis中做累加
					setProductCollectCountToRedis(proCollectBean,IS_NOT_SINGLE);
				} 
			}
		}
	
	/**
	 * @Description 把单个商品收藏数设置到redis中 
	 * @author zhaochenyu
	 * @date 2016年1月13日 下午3:42:59
	 */
	public static void setSingleProductCollectCountToRedis(Long productId,String isSingle) {
		
		Map<String,Object> proMap = new HashMap<String, Object>();
		proMap.put("product_id", productId);
		Long count = BaseSqlTemplate.getCount(TABLE_MEMBER_GOODS_FAVORITE, proMap);
		ProductCollectCountBean productCollectBean = new ProductCollectCountBean();
		productCollectBean.setCount(count);
		productCollectBean.setProductId(productId);
		setProductCollectCountToRedis(productCollectBean,IS_SINGLE);
	}
	
	public static long getSingleProductCollectCountToRedis(Long productId) {
		String key = getKey(productId);
		long count = 0;
		try {
			count = CacheCount.get(key);
		} catch (Exception e) {
			log.error("set productcollectcount to redis error.productId:{}",
					productId);
		}
		return count;
	}
	/**
	 * @Description 把当前商品设置到redis中 
	 * @author zhaochenyu
	 * @date 2016年1月13日 下午3:44:25
	 * @param productCollectCountList
	 */
	public static void setProductCollectCountToRedis(
			ProductCollectCountBean productCollectBean,String isSingle) {

		Long productId = productCollectBean.getProductId();
		Long productCount = productCollectBean.getCount();
		String key = getKey(productId);
		try {
			if(IS_NOT_SINGLE.equals(isSingle)) {
				CacheCount.incrBy(key,productCount);
//				CacheCount.del(key);
			} else {
				CacheCount.set(key, productCount);
			}
				
		} catch (Exception e) {
			log.error("set productcollectcount to redis error.productId:{}",
					productId);
		}
	}
	/**
	 * @Description 获取全量商品条数 
	 * @author zhaochenyu
	 * @date 2016年1月15日 下午2:50:34
	 */
	public static long getDistinctProductCollectCount() {
		String sql = "select count(distinct product_id) count from "+ TABLE_MEMBER_GOODS_FAVORITE;
		Connection conn = MysqlConnectionFactory.getConnection();
		long count = BaseSqlTemplate.getCount(sql, conn);
		return count;
	}
	
	public static String getKey(Long productId) {
		return SHOP + ":" + PRODUCT_COLLECTCOUNT + ":" + productId;
	}
}
