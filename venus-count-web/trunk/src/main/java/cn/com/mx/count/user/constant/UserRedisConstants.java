package cn.com.mx.count.user.constant;

/**
 * @Description redis计数用key值常量 
 * @author jiale
 * @date 2016年3月5日 下午12:56:36
 */
public class UserRedisConstants {
	
	// 工程名称
    public static final String KEY_PROJECT = "user";
    
    // 相关业务名称：会员基本信息
    public static final String KEY_BUSINESS_BASIC_INFO = "info";

    // 相关业务名称：店铺收藏数
    public static final String KEY_BUSINESS_SHOPCOLLECTCOUNT = "shopcollectcount";
    
    // 相关业务名称：商品收藏数
    public static final String KEY_BUSINESS_PRODUCTCOLLECTCOUNT = "productcollectcount";
    
    // 相关业务名称：话题收藏数
    public static final String KEY_BUSINESS_TOPICCOLLECTCOUNT = "topiccollectcount";
    
    /**
     * @Description 会员基本信息 key 
     * @author jiale
     * @date 2016年3月5日 下午1:29:07
     * @param userId
     * @return
     */
    public static String getUserBasicInfoKey(String userId) {
        return KEY_PROJECT + ":" + KEY_BUSINESS_BASIC_INFO + ":" + userId;
    }
    
    /**
     * @Description 店铺收藏数 key 
     * @author jiale
     * @date 2016年3月5日 下午1:00:56
     * @param userId
     * @return
     */
    public static String getShopcollectcountKey(String userId) {
        return KEY_PROJECT + ":" + KEY_BUSINESS_SHOPCOLLECTCOUNT + ":" + userId;
    }
    
    /**
     * @Description 商品收藏数 key 
     * @author jiale
     * @date 2016年3月5日 下午1:01:53
     * @param userId
     * @return
     */
    public static String getProductcollectcountKey(String userId) {
        return KEY_PROJECT + ":" + KEY_BUSINESS_PRODUCTCOLLECTCOUNT + ":" + userId;
    }
    
    /**
     * @Description 话题收藏数  key
     * @author jiale
     * @date 2016年3月5日 下午1:02:57
     * @param userId
     * @return
     */
    public static String getTopiccollectcountKey(String userId) {
        return KEY_PROJECT + ":" + KEY_BUSINESS_TOPICCOLLECTCOUNT + ":" + userId;
    }

}
