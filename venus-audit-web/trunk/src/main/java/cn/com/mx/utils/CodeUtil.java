package cn.com.mx.utils;

/**
 * APP服务api系统模块 错误编码：99
 */
public final class CodeUtil {    
	public static final int SUCCESS = 0;
	public static final String SUCCESS_MSG = "成功";
	
	public static final int FAIL = 881001;
	public static final String FAIL_MSG = "失败";
	public static final String FAIL_MSG_VSHOPSTATUS = "该店铺不是经营中状态";
	
	public static final int ADD_FAIL = 881002;
	public static final String ADD_FAIL_MSG = "新增失败";
	
	public static final int DELETE_FAIL = 881003;
	public static final String DELETE_FAIL_MSG = "删除失败";	
	
	public static final int UPDATE_FAIL = 881004;
	public static final String UPDATE_FAIL_MSG = "更新失败";
	
	public static final int DB_CONNECT_FAIL = 881005;
	public static final String DB_CONNECT_FAIL_MSG = "数据库连接失败";
	
	public static final int PAMAS_NULL = 881006;
	public static final String PAMAS_NULL_MSG = "请求参数为空";
	
	public static final int PAMAS_ERROR = 881007;
	public static final String PAMAS_ERROR_MSG = "请求参数错误";
	
	public static final int PUBLICPAMAS_NULL = 881008;
	public static final String PUBLICPAMAS_NULL_MSG = "请求公共参数为空";
	
	public static final int PUBLICPAMAS_ERROR = 881009;
	public static final String PUBLICPAMAS_ERROR_MSG = "请求公共参数错误";
	
	public static final int UNDEFINED_PAMAS_VALUE = 881010;
	public static final String UNDEFINED_PAMAS_VALUE_MSG = "未定义参数值";
	
	public static final int UNLOGIN_ERROR = 881011;
	public static final String UNLOGIN_ERROR_MSG = "用户未登录";
	
	public static final int EXCEPTION = 881012;
	public static final String EXCEPTION_MSG = "异常信息";	
	
	public static final int DUBBOEXCEPTION = 881013;
	public static final String DUBBOEXCEPTION_MSG = "系统业务繁忙(99)！";	
	
	public static final int UPLOADIMG_ERROR = 881014;
	public static final String UPLOADIMG_MSG = "上传图片失败";

	public static final int QUERY_ERROR = 881015;
	public static final String QUERY_MSG = "查询数据不存在";

	public static final int NO_PERMISSION = 881016;
	public static final String NO_PERMISSION_MSG = "无权限操作";
	
	public static final int CHECK_IMGCODE_ERROR = 881017;
	public static final String CHECK_IMGCODE_MSG = "图片验证码校验失败";
	
	public static final int CHECK_MOBILE_ERROR = 881018;
	public static final String CHECK_MOBILE_MSG = "手机号格式不正确";
	
	public static final int CHECK_EMAIL_ERROR = 881019;
	public static final String CHECK_EMAIL_MSG = "邮箱格式不正确";
	
	public static final int BAD_WORD_ERROR = 881020;
	public static final String BAD_WORD_MSG = "存在敏感词";
	
	public static final int CHECK_IDCARD_ERROR = 881021;
	public static final String CHECK_IDCARD_MSG = "身份证号格式不正确";
	
	public static final int NO_ADDRESS = 881022;
	public static final String NO_ADDRESS_MSG = "请先增加收货地址";
	
	public static final int NO_REDIS = 881023;
	public static final String NO_REDIS_MSG = "系统业务繁忙(88)！";
	
	public static final int GET_AD_ERROR = 881024;
	public static final String GET_AD_ERROR_MSG = "获取广告信息失败";

	public static final int NO_DEFAULT_ADDRESS = 881025;
	public static final String NO_DEFAULT_ADDRESS_MSG = "没有默认收货地址";	
	
	public static final int NO_VSHOP_EXIST = 881026;
	public static final String NO_VSHOP_EXIST_MSG = "微店不存在";	

	public static final int PRODUCT_MORE = 881027;
	public static final String PRODUCT_MORE_MSG = "生成订单只能有一件商品";	
	
	public static final int BUYER_IS_SELF = 881028;
	public static final String BUYER_IS_SELF_MSG = "商家不能购买自己的商品";	
	
    public static final int CART_NUM_OVER = 881029;
    public static final String CART_NUM_OVER_MSG = "购物车已超载，请先结算或删除一些商品再添加";   
    
	public static final int PASSWORD_ERROR = 881030;
	public static final String PASSWORD_ERROR_MSG = "用户密码处理异常";
	
	public static final int App_VERSION_DETAIL_ERROR = 881031;
	public static final String App_VERSION_DETAIL_ERROR_MSG = "请求参数错误,查找的app类型不存在";

    public static final int CART_PRO_NUM_OVER = 881032;
    public static final String CART_PRO_NUM_OVER_MSG = "单个商品购买总量已超载，请先结算或删除一些商品再添加"; 
    
    public static final int ACCESS_AUTHORITY = 881033;
    public static final String ACCESS_AUTHORITY_MSG = "客户端IP不在允许访问的范围内";    
    
    public static final int COUPON_UNDEFINTION = 881034;
    public static final String COUPON_UNDEFINTION_MSG = "所使用红包不存在";   
    
    public static final int PLAT_COUPON_PIRCE_NULL = 881035;
    public static final String PLAT_COUPON_PIRCE_NULL_MSG = "平台红包使用异常";   
    
    public static final int PLAT_COUPON_PIRCE_WRONG = 881036;
    public static final String PLAT_COUPON_PIRCE_WRONG_MSG = "平台红包使用异常";   
    
    public static final int SHOP_COUPON_PIRCE_NULL = 881037;
    public static final String SHOP_COUPON_PIRCE_NULL_MSG = "店铺红包使用异常";   
    
    public static final int SHOP_COUPON_INVALID = 881038;
    public static final String SHOP_COUPON_INVALID_MSG = "店铺红包无效";   
    
    public static final int SHOP_COUPON_PIRCE_WRONG = 881039;
    public static final String SHOP_COUPON_PIRCE_WRONG_MSG = "店铺红包使用异常"; 
    
    public static final int BALANCE_OVER = 881040;
    public static final String BALANCE_OVER_MSG = "国美币超出使用限额"; 
    
    public static final int BALANCE_CHECK_FAIL = 881041;
    public static final String BALANCE_CHECK_FAIL_MSG = "国美币使用校验失败"; 
    
    public static final int BALANCE_NOT_ENOUGH = 881042;
    public static final String BALANCE_NOT_ENOUGH_MSG = "国美币账户余额不足"; 
    
    public static final int PRODUCT_NOT_ENOUGH = 881043;
    public static final String PRODUCT_NOT_ENOUGH_MSG = "购买商品中存在库存不足的商品"; 
    
    public static final int PRODUCT_NOT_ONSHELF = 881044;
    public static final String PRODUCT_NOT_ONSHELF_MSG = "购买商品中存在已下架的商品"; 
    
    public static final int PRODUCT_PRICE_CHANGE = 881045;
    public static final String PRODUCT_PRICE_CHANGE_MSG = "参与直降商品价格不可更改";
    
    public static final int ORDER_FEE_NEGATIVE = 881046;
    public static final String ORDER_FEE_NEGATIVE_MSG = "由于该订单异地跨仓，暂不支持组合支付，请单独结算";
    
	public static final int PASSWORD_TIME_ERROR = 881047;
	public static final String PASSWORD_TIME_ERROR_MSG = "登录失败，请检查手机系统时间是否正确";
    
	public static final int NOT_EXPERT = 881048;
	public static final String NOT_EXPERT_MSG = "该会员不是达人，不能申请开通美店";
	
	public static final int NOT_MSHOP = 881049;
	public static final String NOT_MSHOP_MSG = "该店铺非美店";
	
	public static final int UNDEFINED = 889999;
	public static final String UNDEFINED_MSG = "未定义错误";
	
	
	
	/**参数为空**/
	public static final String RESULT_PUBLIC_NULL = makeError(CodeUtil.PUBLICPAMAS_NULL,CodeUtil.PUBLICPAMAS_NULL_MSG);
	/**参数转换错误**/
	public static final String RESULT_PUBLIC_PARAMS_ERR = makeError(CodeUtil.PUBLICPAMAS_ERROR,CodeUtil.PUBLICPAMAS_ERROR_MSG);
	/**请求参数错误**/
	public static final String RESULT_PARAMS_ERR  = makeError(CodeUtil.PAMAS_ERROR,CodeUtil.PAMAS_ERROR_MSG);
	/**定义错误**/
	public static final String REFULT_UNDEFINED_ERR   = makeError(CodeUtil.UNDEFINED,CodeUtil.UNDEFINED_MSG);
	/**未登录错误**/
	public static final String REFULT_UNLOGIN_ERROR   = makeError(CodeUtil.UNLOGIN_ERROR,CodeUtil.UNLOGIN_ERROR_MSG);
	/**用户不存在**/
	public static final String REFULT_USERID_NOEXISTS   = makeError(CodeUtil.PAMAS_ERROR,CodeUtil.PAMAS_ERROR_MSG + ":用户不存在" );
	/**dubbo异常**/
	public static final String REFULT_DUBBOEXCEPTION = makeError(CodeUtil.DUBBOEXCEPTION,CodeUtil.DUBBOEXCEPTION_MSG);
	
	private static String makeError(int errorCode,String errorMsg){
		return new StringBuilder("{\"success\":false,\"code\":")
		.append(errorCode).append(",\"message\":\"")
		.append(errorMsg)
		.append("\",\"data\":\"\"}").toString();
	}

}
