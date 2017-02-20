package cn.com.mx.count.user.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import cn.com.mx.count.template.BaseSqlTemplate;
import cn.com.mx.count.template.CacheCount;
import cn.com.mx.count.template.CacheRedis;
import cn.com.mx.count.user.bean.Expertlabel;
import cn.com.mx.count.user.bean.User;
import cn.com.mx.count.user.bean.UserExtras;
import cn.com.mx.count.user.constant.UserRedisConstants;
import cn.com.mx.count.user.vo.Category;
import cn.com.mx.count.user.vo.ExpertInfoVo;
import cn.com.mx.count.user.vo.UserInfoVo;
import cn.com.mx.count.utils.StringUtil;


/**
 * @Description 初始化会员数据到redis 
 * @author jiale
 * @date 2016年3月3日 下午2:59:52
 */
@Slf4j
public class UserTemplate {
	
	//会员基本信息表
	private static final String TABLE_ECP_USERS = "ecp_users";
	//会员信息扩展表
	private static final String TABLE_GOME_USER_EXTRAS = "gome_user_extras";
	//达人标签表
	private static final String TABLE_MEMBER_EXPERT_LABEL = "member_expert_label";
	//会员店铺收藏表
	private static final String TABLE_MEMBER_SHOP_FAVORITE = "member_shop_favorite";
	//会员商品收藏表
	private static final String TABLE_MEMBER_GOODS_FAVORITE = "member_goods_favorite";
	//会员话题收藏表
	private static final String TABLE_MEMBER_TOPIC_COLLECTION = "member_topic_collection";
	//每次处理条数
	private static final int PAGESIZE = 50;
	
	/**
	 * @Description 初始化所有会员基本信息、店铺收藏数、商品收藏数、话题收藏数
	 * @author jiale
	 * @date 2016年3月4日 下午2:36:07
	 * @return
	 */
	@SuppressWarnings("all")
	public static String loadsAllUsersInfo(){
		String result="";
        Map<String, Object> paramMap = getUserParamMap();
        
		try {
			// 查询有效的买家用户数目
			long totalUser = BaseSqlTemplate.getCount("ecp_users", paramMap);
			result += "初始化所有会员基本信息:会员总数为" + totalUser + "条。";
			for (int pageNum = 1; (pageNum-1)*PAGESIZE < totalUser; pageNum++) {
				// 分页查询用户信息
                List<User> users = BaseSqlTemplate.pagingObjects("ecp_users", pageNum, PAGESIZE,
                        paramMap, User.class);
                for (User user : users) {
                    long userId = user.getId();
                    UserExtras userExtra = null;
                    Expertlabel label = null;
                    String sqlExtra = "select * from " + TABLE_GOME_USER_EXTRAS +" where member_id = '" + userId + "'";
                    List userExtras = BaseSqlTemplate.pagingObjectsBySql(sqlExtra, UserExtras.class);
                    if(userExtras != null && userExtras.size() > 0) {
                    	userExtra = (UserExtras)userExtras.get(0);
                    	if(userExtra.getExpertLabelId() != null) {
                    		String sqlLabel = "select * from " + TABLE_MEMBER_EXPERT_LABEL +" where id = '" + userExtra.getExpertLabelId().intValue() + "'";
                    		List expertLabels = BaseSqlTemplate.pagingObjectsBySql(sqlLabel, Expertlabel.class);
                    		if(expertLabels !=null && expertLabels.size() > 0) {
                    			label = (Expertlabel)expertLabels.get(0);
                    		}
                    	}
                    }
                    //封装会员基本信息数据
                    UserInfoVo vo = getUserInfo(user,userExtra,label);
                    try {
                    	CacheRedis.createUserInfo(userId, vo);
                    } catch (Exception e) {
                        log.error("初始化所有会员基本信息到redis失败！userId={}，异常信息是：{}", userId, e);
                    }
                    //缓存会员店铺收藏数
                    getAndSetShopCollectNumByUserId(userId);
                    //缓存会员商品收藏数
                    getAndSetProductCollectNumByUserId(userId);
                    //缓存会员话题收藏数
                    getAndSetTopicCollectNumByUserId(userId);
                }
			}
		} catch (Exception e) {
			log.error("初始化所有会员信息到redis失败！sql查询结果失败！异常信息是：{}", e);
		}
		return result;
	}
	
	/**
	 * @Description 根据会员id初始化该会员基本信息、店铺收藏数、商品收藏数、话题收藏数 
	 * @author jiale
	 * @date 2016年3月7日 下午5:56:30
	 * @param UserId
	 * @return
	 */
	@SuppressWarnings("all")
	public static String loadsUserInfoByUserId(long userId){
		String result="";
        Map<String, Object> paramMap = getUserParamMap();
        paramMap.put("id", userId);
        
		try {
			// 查询有效的买家用户
			result += "初始化会员信息:会员id为:" + userId + "。";
			// 分页查询用户信息
            List<User> users = BaseSqlTemplate.pagingObjects("ecp_users", 1, 1,
                    paramMap, User.class);
            if(users != null && users.size() > 0) {
            	User user = users.get(0);
                UserExtras userExtra = null;
                Expertlabel label = null;
                String sqlExtra = "select * from " + TABLE_GOME_USER_EXTRAS +" where member_id = '" + userId + "'";
                List userExtras = BaseSqlTemplate.pagingObjectsBySql(sqlExtra, UserExtras.class);
                if(userExtras != null && userExtras.size() > 0) {
                	userExtra = (UserExtras)userExtras.get(0);
                	if(userExtra.getExpertLabelId() != null) {
                		String sqlLabel = "select * from " + TABLE_MEMBER_EXPERT_LABEL +" where id = '" + userExtra.getExpertLabelId().intValue() + "'";
                		List expertLabels = BaseSqlTemplate.pagingObjectsBySql(sqlLabel, Expertlabel.class);
                		if(expertLabels !=null && expertLabels.size() > 0) {
                			label = (Expertlabel)expertLabels.get(0);
                		}
                	}
                }
                //封装会员基本信息数据
                UserInfoVo vo = getUserInfo(user,userExtra,label);
                try {
                	CacheRedis.createUserInfo(userId, vo);
                } catch (Exception e) {
                    log.error("初始化会员基本信息到redis失败！userId={}，异常信息是：{}", userId, e);
                }
                //缓存会员店铺收藏数
                getAndSetShopCollectNumByUserId(userId);
                //缓存会员商品收藏数
                getAndSetProductCollectNumByUserId(userId);
                //缓存会员话题收藏数
                getAndSetTopicCollectNumByUserId(userId);
            } else {
            	log.error("初始化会员信息到redis失败！该会员不存在。userId={}", userId);
            }
		} catch (Exception e) {
			log.error("初始化会员信息到redis失败！sql查询结果失败！异常信息是：{}", e);
		}
		return result;
	}
	
	/**
	 * @Description 根据会员Id获取改会员的店铺收藏数，并且存入redis缓存。 
	 * @author jiale
	 * @date 2016年3月7日 下午5:33:41
	 * @param userId
	 */
	public static void getAndSetShopCollectNumByUserId(long userId){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_id", userId);
            map.put("status", 1);
            String key = UserRedisConstants.getShopcollectcountKey(String.valueOf(userId));
            long num = BaseSqlTemplate.getCount(TABLE_MEMBER_SHOP_FAVORITE, map);
            try {
                CacheCount.set(key, num);
            } catch (Exception e) {
                log.error("初始化会员店铺收藏数到redis失败！userId={}，异常信息：{}", userId, e);
            }
		}catch (Exception e) {
			log.error("初始化会员店铺收藏数到redis失败！失败信息：{}", e);
		}
	}
	
	/**
	 * @Description 根据会员Id获取改会员的商品收藏数，并且存入redis缓存。 
	 * @author jiale
	 * @date 2016年3月7日 下午5:34:48
	 * @param userId
	 */
	public static void getAndSetProductCollectNumByUserId(long userId){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_id", userId);
            map.put("status", 1);
            String key = UserRedisConstants.getProductcollectcountKey(String.valueOf(userId));
            long num = BaseSqlTemplate.getCount(TABLE_MEMBER_GOODS_FAVORITE, map);
            try {
                CacheCount.set(key, num);
            } catch (Exception e) {
                log.error("初始化会员商品收藏数到redis失败！userId={}，异常信息：{}", userId, e);
            }
		} catch (Exception e) {
			log.error("初始化会员商品收藏数到redis失败！失败信息：{}", e);
		}
	}
	
	/**
	 * @Description 根据会员Id获取改会员的话题收藏数，并且存入redis缓存。 
	 * @author jiale
	 * @date 2016年3月7日 下午5:35:08
	 * @param userId
	 */
	public static void getAndSetTopicCollectNumByUserId(long userId){
		try{
			Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_id", userId);
            map.put("is_delete", 0);
            String key = UserRedisConstants.getTopiccollectcountKey(String.valueOf(userId));
            long num = BaseSqlTemplate.getCount(TABLE_MEMBER_TOPIC_COLLECTION, map);
            try {
                CacheCount.set(key, num);
            } catch (Exception e) {
                log.error("初始化会员话题收藏数到redis失败！userId={}，异常信息：{}", userId, e);
            }
		} catch (Exception e) {
			log.error("初始化会员话题收藏数到redis失败！失败信息：{}", e);
		}
	}

	/**
	 * @Description 获取会员基本信息 
	 * @author jiale
	 * @date 2016年3月3日 下午5:57:10
	 * @param user
	 * @param userExtra
	 * @param label
	 */
	private static UserInfoVo getUserInfo(User user, UserExtras userExtra,
			Expertlabel label) {
		UserInfoVo vo = new UserInfoVo();
		//手机号
		vo.setMobile(user.getMobile());
		//邮箱号
		vo.setEmail(user.getEmail());
		//昵称
		vo.setNickname(user.getDisplayName());
		//自己的推荐码
		vo.setReferralCode(user.getOuterUserId());
		//用户角色
		vo.setRoleId(user.getType());
		if(userExtra!=null){
			//出生日期
			vo.setBirthday(userExtra.getBirthday());
			//性别
			vo.setGender(userExtra.getSex());
			//会员头像
			vo.setFacePicUrl(userExtra.getPicturePath());
			//会员推荐人id（本地的UserId）
			if (!StringUtil.isNullOrEmpty(userExtra.getRefereeId())) {
				String sql = "select id from " + TABLE_ECP_USERS +" where outer_user_id = '" + userExtra.getRefereeId() + "'";
				List users = BaseSqlTemplate.pagingObjectsBySql(sql, User.class);
				if(users != null && users.size() > 0) {
					vo.setMembershipRefereeId(((User)users.get(0)).getId());
				}
			}
			//商家推荐人Id
			vo.setXpopRefereeId(userExtra.getSaleRefereeId());
			//用户签名
			vo.setUserSign(userExtra.getUserSign());
			//用户达人信息
			ExpertInfoVo expertInfo = new ExpertInfoVo();
			expertInfo.setAuditStatus(userExtra.getExpertAuditStatus());
			List<Category> Categories = new ArrayList<Category>();
			if(userExtra.getExpertLabelId()!=null) {
				Category category = new Category();
				category.setId(userExtra.getExpertLabelId());
				if(label!=null) {
					category.setName(label.getName());
				}
				Categories.add(category);
			}
			expertInfo.setCategoryList(Categories);
			vo.setExpertInfoVo(expertInfo);
			//IM账号
			vo.setImId(userExtra.getImBuyerId());
			//手机绑定状态
			vo.setMobileActivated(userExtra.getPhoneActiveState());
			//邮箱绑定状态
			vo.setEmailActivated(userExtra.getEmailActiveState());
		}
		return vo;
	}
	
	/**
	 * @Description 得到会员信息查询条件 
	 * @author jiale
	 * @date 2016年3月5日 下午1:20:37
	 * @return
	 */
	private static Map<String, Object> getUserParamMap() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", 1);
		// 1:买家 2:XPOP商家 3:达人 6:普通员工 7:门店员工 8:促销员工
		paramMap.put("type", Arrays.asList(1, 2, 3, 6, 7, 8));
		return paramMap;
	}

}
