package cn.com.mx.count.shop.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.shop.constant.ShopCollectionCons;
import cn.com.mx.count.shop.dao.ShopCollectDao;
import cn.com.mx.count.template.SimpleSqlTemplate;
import cn.com.mx.count.template.SimpleSqlTemplate.SqlCallback;

/**
 * @Description 统计店铺数
 * @author yangjun-ds1
 * @date 2016年1月12日 下午1:09:41
 */

@Slf4j
@SuppressWarnings("all")
public class ShopCollectTemplate extends HttpServlet {

	private static ShopCollectDao shopCollectDao = new ShopCollectDao();

	/**
	 * @Description 获取数据
	 * @author yangjun-ds1
	 * @date 2016年1月12日 下午2:08:24
	 * @return
	 */
	public static String getResultForTemp() {
		SimpleSqlTemplate sst = new SimpleSqlTemplate();
		return sst.execute(new SqlCallback<String>() {
			@Override
			public String done(Connection conn) {
				Set<Long> set = new HashSet<Long>();
				PreparedStatement pstm = null;
				ResultSet rs = null;
				long shop_id = 0;
				long fav_shop_count = 0;
				try {
					String sql = "SELECT shop_id, COUNT(1) fav_shop_count FROM (SELECT * FROM member_shop_favorite WHERE STATUS =1 LIMIT 0, 100) a GROUP BY shop_id";
					pstm = conn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()) {
						shop_id = rs.getLong("shop_id");
						fav_shop_count = rs.getLong("fav_shop_count");
						shopCollectDao.incrBy(ShopCollectionCons.KEYS_SHOPCOLLECT+ shop_id,fav_shop_count);
						set.add(shop_id);
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
				return "被收藏的店铺总数为" + set.size();
			}
		});
	}

	public static long getResultByParam(final int see, final String shopId) {
		SimpleSqlTemplate sst = new SimpleSqlTemplate();
		return sst.execute(new SqlCallback<Long>() {
			@Override
			public Long done(Connection conn) {
				PreparedStatement pstm = null;
				ResultSet rs = null;
				long fav_shop_count = 0;
				try {
					String sql = "SELECT COUNT(1) fav_shop_count FROM member_shop_favorite WHERE STATUS =1 AND shop_id = "+shopId;
					pstm = conn.prepareStatement(sql);
					rs = pstm.executeQuery();
					while (rs.next()) {
						fav_shop_count = rs.getLong("fav_shop_count");
					}
					if(see == 0){
						shopCollectDao.incr(ShopCollectionCons.KEYS_SHOPCOLLECT+ shopId);
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
				return fav_shop_count;
			}
		});
	}
}
