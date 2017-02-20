/**
 * gomeo2o.com Copyright (c) 2015-2025 All Rights Reserved.
 * 
 * @Description TODO
 * @author mojianli
 * @date 2016年1月12日 下午5:54:35
 */
package cn.com.mx.count.im.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.mx.count.im.bean.User;
import cn.com.mx.count.im.constant.ImRedisConstants;
import cn.com.mx.count.template.BaseSqlTemplate;
import cn.com.mx.count.template.CacheCount;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 分页同步好友数到redis 
 * @author mojianli
 * @date 2016年1月12日 下午5:54:35
 */
@Slf4j
public class ImFriendTemplate {

    /**
     * 
     * @Description 全量同步 
     * @author mojianli
     * @date 2016年1月13日 下午6:42:07
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String syncImFriendNum() {

        String result = "";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("status", 1);
        paramMap.put("type", 1);

        Map<String, Object> imFriendCountParam = new HashMap<String, Object>();
        imFriendCountParam.put("is_delete", 0);
        imFriendCountParam.put("user_role", 1);
        imFriendCountParam.put("vuser_role", 1);

        try {
            // 查询有效的买家用户数目
            long totalUser = BaseSqlTemplate.getCount("ecp_users", paramMap);

            result += "用户数：共" + totalUser + "条";
            for (long i = 1; i < totalUser; i += 10) {

                // 分页查询用户信息
                List<User> users = BaseSqlTemplate.pagingObjects("ecp_users", Integer.parseInt(String.valueOf(i)), 10,
                        paramMap, User.class);

                for (User user : users) {
                    long userId = user.getId();

                    imFriendCountParam.put("vuser_id", userId);

                    //获取当前用户的好友数，并同步到redis中
                    long imFriendNum = BaseSqlTemplate.getCount("im_friendlist", imFriendCountParam);

                    String imFriendKey = ImRedisConstants.getImFriendKey(String.valueOf(userId));
                    try {
                        CacheCount.set(imFriendKey, imFriendNum);
                    } catch (Exception e) {
                        log.error("同步好友数到redis失败！userId={}", userId, e);
                    }
                }
            }
        } catch (Exception e) {
            log.error("同步好友数到redis失败！sql查询结果失败！", e);
        }

        return result;
    }
    
    /**
     * 
     * @Description 同步或者只查看单个用户的好友数 
     * @author mojianli
     * @date 2016年1月13日 下午7:09:09
     * @param seeFlag
     * @param userId
     * @return
     */
    public static long syncImFriendNumSingle(int seeFlag,String userId){
        
        String imFriendKey = ImRedisConstants.getImFriendKey(String.valueOf(userId));
        
        // 先同步redis数目，再返回结果，否则直接返回结果
        if (0 == seeFlag && null != userId) {
            Map<String, Object> imFriendCountParam = new HashMap<String, Object>();
            imFriendCountParam.put("is_delete", 0);
            imFriendCountParam.put("user_role", 1);
            imFriendCountParam.put("vuser_role", 1);
            
            imFriendCountParam.put("user_id", userId);
            //获取当前用户的好友数，并同步到redis中
            long imFriendNum = BaseSqlTemplate.getCount("im_friendlist", imFriendCountParam);
            try {
                CacheCount.set(imFriendKey, imFriendNum);
            } catch (Exception e) {
                log.error("同步好友数到redis失败！userId={}", userId, e);
            }
        }
        return CacheCount.get(imFriendKey);
    }
}
