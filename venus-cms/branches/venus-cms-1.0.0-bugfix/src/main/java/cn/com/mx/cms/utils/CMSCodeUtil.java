package cn.com.mx.cms.utils;


/**
 * Description: 推荐位状态code类
 * @author duwei
 * @date 2015年11月28日 下午5:22:28
 * @version V1.0
 */
public final class CMSCodeUtil {
    public static final int SUCCESS = 0;
    public static final String SUCCESS_MSG = "成功";

    // 使用gome-web-frontend中的CodeUtil.java中的公共错误码
    public static final int PAMAS_ERROR = 881007;
    public static final String PAMAS_ERROR_MSG = "请求参数错误";

    public static final int PAMAS_NULL = 881006;
    public static final String PAMAS_NULL_MSG = "请求参数为空";

    public static final int HX_FAIL = 130050;
    public static final String HX_FAIL_MSG = "调用环信服务失败！";

    public static final int EXIST = 130051;
    public static final String EXIST_MSG = "数据已存在！";

    public static final int MSG_FAIL = 130052;
    public static final String MSG_FAIL_MSG = "调用消息服务失败！";

    public static final int REPEATREGIST_FAIL = 130053;
    public static final String REPEATREGIST_FAIL_MSG = "注册用户失败！";

    public static final int ADD_GROUP_MEM_BATCH_FAIL = 130054;
    public static final String ADD_GROUP_MEM_BATCH_FAIL_MSG = "批量添加群成员失败！";

    public static final int FOLLOWED_FAIL = 130055;
    public static final String FOLLOWED_FAIL_MSG = "该用户已经被关注！";

    public static final int GROUPID_FAIL = 130056;
    public static final String GROUPID_FAIL_MSG = "该群不存在！";

    public static final int DUPLICATE_DOWNLOAD = 130057;
    public static final String DUPLICATE_DOWNLOAD_MSG = "重复下载！";
    
    public static final int REDIS_EXCEPTION = 130058;
    public static final String REDIS_EXCEPTION_MSG = "redis异常！";
    
    public static final int OVER_GROUP_NUM_MAX = 130059;
    public static final String OVER_GROUP_NUM_MAX_MSG = "创建群数不能超过5个！";
	
    public static final int OVER_USER_FAIL = 130060;
    public static final String OVER_USER_NUM_MAX_MSG = "用户不能为空";
    
    public static final int TOPIC_NOT_EXIST_CODE = 90040010;
	public static final String TOPIC_NOT_EXIST_MSG = "话题不存在";
	
	public static final int USERINFO_EXCEPTION_CODE = 90040011;
	public static final String USERINFO_EXCEPTION_MSG = "获取话题创建人用户信息异常";
	
	public static final int TOPIC_TPYE_EXCEPTION_CODE = 90040012;
	public static final String TOPIC_TPYE_EXCEPTION_MSG = "话题类型不支持";
	
	public static final int SERVER_EXCEPTION = 90040020;
	public static final String SERVER_EXCEPTION_MSG = "服务器异常";
	
	public static final int GROUP_MEMBER = 90040021;
	public static final String GROUP_MEMBER_MSG = "群成员数量已达到上限";
	
	public static final int GROUP_NOT_EXIST = 90040022;
	public static final String GROUP_NOT_EXIST_MSG = "群组不存在";
    
	public static final int USER_EXCEPTION_CODE = 90040023;
	public static final String USER_EXCEPTION_MSG = "用户不用存在";
	
	public static final int CALLBACKTOPIC_EXCEPTION_CODE = 90040024;
	public static final String CALLBACKTOPIC_EXCEPTION_MSG = "回复话题失败";
	
	public static final int USER_NOTGROUP_EXCEPTION_CODE = 90040025;
	public static final String USER_NOTGROUP_EXCEPTION_MSG = "用户不在群组内";
	
	public static final int INSERT_TOPIC_EXCEPTION_CODE = 90040026;
	public static final String INSERT_TOPIC_EXCEPTION_MSG = "插入话题失败";
	
	public static final int INSERT_RECOMMEND_EXCEPTION_CODE = 91050001;
	public static final String INSERT_RECOMMEND_EXCEPTION_MSG = "插入推荐位失败";
	
	public static final int GROUP_OWER_EXCEPTION_CODE = 90040027;
	public static final String GROUP_OWER_EXCEPTION_MSG = "群内缺少群管理";
	
	public static final int GROUP_IM_DELETE_EXCEPTION_CODE = 90040028;
	public static final String GROUP_IM_DELETE_EXCEPTION_MSG = "IM删除用户失败";
	
	public static final int GROUP_REFUSED_TO_JOIN_CODE = 90040029;
	public static final String GROUP_REFUSED_TO_JOIN_MSG = "群组拒绝加入";
	
	public static final int SYSTEM_ANOMALY_CODE = 90040030;
	public static final String SYSTEM_ANOMALY_MSG = "系统日期转化错误";
	
	public static final int MONGO_DB_ERROR = 90040031;
	public static final String MONGO_DB_ERROR_MSG = "查询mongo数据库异常";
	
	public static final int GROUP_MEMBERS_EXIST = 90040032;
	public static final String GROUP_MEMBERS_EXIST_MSG = "该用户已在群列表中,请不要重复添加";
	
    public static final int DELETE_GROUP_MEM_FAIL = 90040033;
    public static final String OWER_NOT_DELETE_MSG = "群主不能删除！";
    
    public static final int SERVICE_FAIL = 90060001;
    public static final String SERVICE_FAIL_MSG = "调用服务失败！";
 

}
