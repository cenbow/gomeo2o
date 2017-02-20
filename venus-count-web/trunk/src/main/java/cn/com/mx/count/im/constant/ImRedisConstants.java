/**
 * gomeo2o.com Copyright (c) 2015-2025 All Rights Reserved.
 * 
 * @Description TODO
 * @author mojianli
 * @date 2016年1月12日 上午11:44:07
 */
package cn.com.mx.count.im.constant;

/**
 * @Description redis计数用key值常量
 * @author mojianli
 * @date 2016年1月12日 上午11:44:07
 */
public final class ImRedisConstants {

    // 工程名称
    public static final String KEY_PROJECT = "im";

    // 相关业务名称：关注
    public static final String KEY_BUSINESS_IMFRIEND = "imfriend";
    // 用户ID
    public static final String KEY_USERID = "userid";
    // 好友数
    public static final String KEY_IMFRIENDNUM = "imfriendnum";
    // 粉丝数
    public static final String KEY_IMFANSNUM = "imfansnum";

    /**
     * @Description 好友数key
     * @author mojianli
     * @date 2016年1月13日 上午10:31:37
     * @param groupId
     * @return
     */
    public static String getImFriendKey(String userId) {
        return KEY_PROJECT + ":" + KEY_BUSINESS_IMFRIEND + ":" + userId + ":" + KEY_IMFRIENDNUM;
    }

    /**
     * @Description 粉丝数key
     * @author mojianli
     * @date 2016年1月13日 上午10:31:37
     * @param groupId
     * @return
     */
    public static String getImFansKey(String userId) {
        return KEY_PROJECT + ":" + KEY_BUSINESS_IMFRIEND + ":" + userId + ":" + KEY_IMFANSNUM;
    }

}
