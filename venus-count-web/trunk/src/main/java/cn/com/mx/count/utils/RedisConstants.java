package cn.com.mx.count.utils;

import cn.com.mx.count.sns.post.constant.SnsConstants;

/**
 * @Description redis计数用key值常量 
 * @author yuanchangjun
 * @date 2016年1月12日 上午11:21:50
 */
public class RedisConstants {
	// 工程名称
    public static final String KEY_PROJECT = "social";
    // redis群组定义
    public static final String KEY_BUSINESS_GROUP = "group";
    // redis话题定义
    public static final String KEY_BUSINESS_TOPIC = "topic";
    // redis群组成员数(示例：key= social:group:120:grouppernum)
    public static final String KEY_GROUPPERNUM = "grouppernum";
    // redis群组话题数(示例：key= social:group:120:grouptopicnum)
    public static final String KEY_GROUPTOPNUM = "grouptopicnum";
    // redis群组内某个话题回复数(示例：key= social:topic:120:topicreplynum)
    public static final String KEY_TOPICREPLYNUM = "topicreplynum";
    //商品销量 11
    public static final String CHECK_ITEM_SALE_COUNT_ALL = "check_item_sale_count_all";
    //商品销量 12
    public static final String CHECK_ITEM_SALE_COUNT = "check_item_sale_count";
    
    /**********************社交****************************/
    //检查是否执行完毕 0
    public static final String CHECK_SOCIAL_PERSON = "check_social_person";
    //话题 1
    public static final String CHECK_SOCIAL_TOPIC = "check_social_topic";
    //话题回复 2
    public static final String CHECK_SOCIAL_TOPIC_BACK = "check_social_topic_back";
    //全部执行 100
    public static final String CHECK_SOCIAL_GROUP_ALL = "check_social_group_all";
    /**********************商品****************************/
    //商品收藏
    public static final String CHECK_PRODUCT_COLLECT = "check_prodcut_collect";
    //商品收藏(单个)
    public static final String CHECK_PRODUCT_COLLECT_SINGLE = "check_prodcut_collect_single";
    /**********************店铺收藏****************************/
    //统计收藏的所有的店铺数 401
    public static final String CHECK_SHOP_COLLECT = "check_shop_collect";
    //统计单个店铺被收藏的次数 402
    public static final String CHECK_SHOP_COLLECT_SINGLE = "check_shop_collect_single";
    /*********************IM***************************/
    // IM所有好友数 200
    public static final String CHECK_IM_FRIEND_ALL = "check_im_friend_all";
    // IM单个好友数 201
    public static final String CHECK_IM_FRIEND_SINGLE = "check_im_friend_single";
    // IM所有粉丝数 202
    public static final String CHECK_IM_FANS_ALL = "check_im_fans_all";
    // IM单个粉丝数 203
    public static final String CHECK_IM_FANS_SINGLE = "check_im_fans_single";
    
    
    /*********************爱生活***************************/
    //爱生活帖子  300
    public static final String CHECK_SNS_POST_ALL = "check_sns_post_all";
    //爱生活帖子评论数
    public static final String CHECK_SNS_POST_COMMENT = "check_sns_post_comment";
    //爱生活帖子点赞数
    public static final String CHECK_SNS_POST_ISLIKE = "check_sns_post_islike";
    
    /*********************商品***************************/
    //店铺上架商品数
    public static final String CHECK_ITEM_ONSHELVES = "check_item_onshelves";
    
    
    /*********************新IM数据同步***************************/
    //同步圈子
    public static final String CHECK_IM_GROUP = "check_im_group";
    //同步圈子成员
    public static final String CHECK_IM_GROUP_PERSON = "check_im_group_person";
    
    /*********************会员***************************/
    //全量初始化数据
    public static final String CHECK_USER_INITIALIZE_ALL = "check_user_initialize_all";
    public static final String CHECK_USER_INFO_ALL = "check_user_info_all";
    //单个初始化数据
    public static final String CHECK_USER_INITIALIZE_SINGLE = "check_user_initialize_single";
    public static final String CHECK_USER_INFO_SINGLE = "check_user_info_single";
    
    
    
    /**
     * @Description 群组下面的人 
     * @author yuanchangjun
     * @date 2016年1月13日 上午10:31:37
     * @param groupId
     * @return
     */
    public static String groupPerson(String groupId){
    	return RedisConstants.KEY_PROJECT+":"+RedisConstants.KEY_BUSINESS_GROUP+":"+groupId+":"+RedisConstants.KEY_GROUPPERNUM;
    }
    
    /**
     * @Description 群下面的话题 
     * @author yuanchangjun
     * @date 2016年1月13日 上午10:32:54
     * @param groupId
     * @return
     */
    public static String groupTopic(String groupId){
    	return RedisConstants.KEY_PROJECT+":"+RedisConstants.KEY_BUSINESS_GROUP+":"+groupId+":"+RedisConstants.KEY_GROUPTOPNUM;
    }
    
    /**
     * @Description 群下面话题的回复 
     * @author yuanchangjun
     * @date 2016年1月13日 上午10:34:23
     * @param topicId
     * @return
     */
    public static String groupTopicBack(String topicId){
    	return RedisConstants.KEY_PROJECT+":"+RedisConstants.KEY_BUSINESS_TOPIC+":"+topicId+":"+RedisConstants.KEY_TOPICREPLYNUM;
    }
    /**
     * @Description 爱生活帖子评论 
     * @author liyan
     * @date 2016年1月13日 上午10:34:23
     * @param business_id
     * @return
     */
    public static String lovelifeComment(String business_id){
        return SnsConstants.PROJECTNAME+":"+SnsConstants.BUSINESS+":"+business_id+":"+SnsConstants.COMMENTSNUM; 
    }
    /**
     * @Description 爱生活帖子评论 
     * @author liyan
     * @date 2016年1月13日 上午10:34:23
     * @param business_id
     * @return
     */
    public static String lovelifeIlike(String business_id){
        return SnsConstants.PROJECTNAME+":"+SnsConstants.BUSINESS+":"+business_id+":"+SnsConstants.ILIKENUM; 
    }
}
