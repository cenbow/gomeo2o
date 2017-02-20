/**
 * gomeo2o.com Copyright (c) 2015-2025 All Rights Reserved.
 * 
 * @Description TODO
 * @author kl_chaizhilei
 * @date 2016年1月12日 下午4:37:41
 */
package cn.com.mx.count.sns.post.template;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.factory.MysqlConnectionFactory;
import cn.com.mx.count.template.BaseSqlTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.utils.RedisConstants;

/**
 * @Description sns相关数据初始化工具类
 * @author kl_chaizhilei
 * @date 2016年1月12日 下午4:37:41
 */
@Slf4j
public class SnsLovelifePostNumTemplate {

    /**
     * @Description 初始化帖子评论数和点赞数
     * @author kl_chaizhilei
     * @param pIds
     * @date 2016年1月12日 下午4:39:44
     * @return
     */
    public static String snsLovelifePostAllNumTemplate() {
        String result = "";
        // SimpleSqlTemplate sst = new SimpleSqlTemplate();
        Connection connection = null;
        Map<String, Object> map = new HashMap<String, Object>();
        // type=0:爱生活的帖子 type=1：圈子的帖子
        map.put("type", 0);
        // is_delete=0：未删除
        map.put("is_delete", 0);
        // 1.查询一共多少个帖子
        long totalCount = BaseSqlTemplate.getCount("sns_post", map);
        // 2.分页统计帖子的评论数目
        int perCount = 10;
        try {
            result += "爱生活帖子数：共" + totalCount + "条";
            connection = MysqlConnectionFactory.getConnection();
            int pageCount = (int) (totalCount/perCount +1);
            for (int i = 1; i < pageCount; i++) {
                List<Long> postIds = BaseSqlTemplate.pagingIds("sns_post", "post_id", i, perCount, map);
                // 批量更新帖子的点赞和评论计数
                if (null != postIds && postIds.size() > 0) {
                    // 设置redis计数
                    setRedisNumsMethod(connection, postIds);
                }
            }
        } catch (Exception e) {
            result = "初始化帖子评论数失败,获取连接异常";
            log.error("初始化帖子评论数失败,获取连接异常", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    result = "关闭连接异常";
                    log.error("关闭Connection出错", e);
                }
            }
        }
        return result;
    }

    /**
     * 
     * @Description 设置redis计数值
     * @author liyan
     * @date 2016年1月14日 下午6:21:37
     * @param connection
     * @param postIds
     * @return
     * @throws SQLException
     */
    private static void setRedisNumsMethod(Connection connection, List<Long> postIds) throws SQLException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", 0);
        map.put("is_delete", 0);
        for (Long postId : postIds) {
            map.put("post_id", postId);
            // 初始化redis评论数
            Long commentNum = BaseSqlTemplate.getCount("sns_comment", map);
            CacheCount.set(RedisConstants.lovelifeComment(String.valueOf(postId)), commentNum);
            // 初始化redis点赞数
            // 帖子点赞表中的关联字段是business_id
            map.remove("post_id");
            map.put("business_id", postId);
            Long likeNum = BaseSqlTemplate.getCount("sns_ilike", map);
            CacheCount.set(RedisConstants.lovelifeIlike(String.valueOf(postId)), likeNum);
        }
    }
    /**
     * 
     * @Description 设置单条帖子评论计数
     * @author liyan
     * @date 2016年1月14日 下午6:21:37
     * @param see
     * @param postId
     * @return
     */
    public static Long snsCommentSingleNum(String postId,int see){
        //see=0:表示执行统计后查看,see=1表示只查询
        if(postId!=null&&see==0){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", 0);
            map.put("is_delete", 0);
            map.put("post_id", postId);
            // 初始化redis评论数
            try {
                Long commentNum = BaseSqlTemplate.getCount("sns_comment", map);
                CacheCount.set(RedisConstants.lovelifeComment(String.valueOf(postId)), commentNum);
            } catch (Exception e) {
                log.error("设置单条帖子评论计数",e);
            }
        }
        return CacheCount.get(RedisConstants.lovelifeComment(String.valueOf(postId)));
    }
    /**
     * 
     * @Description 设置单条帖子点赞计数
     * @author liyan
     * @date 2016年1月14日 下午6:21:37
     * @param see
     * @param postId
     * @return
     */
    public static Long snsLikeSingleNum(String postId,int see){
        //see=0:表示执行统计后查看,see=1表示只查询
        if(postId!=null&&see==0){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("type", 0);
            map.put("is_delete", 0);
            map.put("business_id", postId);
            // 初始化redis评论数
            try {
                Long commentNum = BaseSqlTemplate.getCount("sns_ilike",map);
                CacheCount.set(RedisConstants.lovelifeComment(String.valueOf(postId)), commentNum);
            } catch (Exception e) {
                log.error("",e);
            }
        }
        return CacheCount.get(RedisConstants.lovelifeIlike(String.valueOf(postId)));
    }
    
}
