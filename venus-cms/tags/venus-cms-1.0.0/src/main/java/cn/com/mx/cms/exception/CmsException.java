package cn.com.mx.cms.exception;

import com.gomeo2o.common.exceptions.BizException;

public class CmsException extends BizException {

	private static final long serialVersionUID = -4963928691479261332L;
	
	/**
	 * 参数校验失败
	 */
	public static final BizException ITEM_FAILE= new BizException(90060001, "获取商品信息失败");
	public static final BizException SHOP_ITEMNUM_FAILE= new BizException(90060002, "获取店铺上架商品数失败");
	public static final BizException EXPERT_INFO_FAILE= new BizException(90060003, "获取达人信息失败");
	public static final BizException FAVORITE_ITEMNUM_FAILE= new BizException(90060004, "获取商品被收藏数失败");
	public static final BizException FAVORITE_SHOPNUM_FAILE= new BizException(90060005, "获取店铺被收藏数失败");
	public static final BizException GROUP_INFO_FAILE= new BizException(90060006, "获取群组信息失败");
	public static final BizException FANS_NUM_FAILE= new BizException(90060007, "获取粉丝数失败");
	public static final BizException PICTRUE_INFO_FAILE= new BizException(90060008, "获取图片信息失败");
	public static final BizException POST_INFO_FAILE= new BizException(90060009, "获取贴子动态信息失败");
	public static final BizException POSTID_INFO_FAILE= new BizException(90060010, "获取贴子id信息失败");
	public static final BizException POST_INFO_FAILE1= new BizException(90060011, "获取贴子信息失败");
	public static final BizException REBATE_RULE_INFO_FAILE= new BizException(90060012, "获取商家规则信息失败");
	public static final BizException VSHOP_INFO_FAILE= new BizException(90060013, "获取微店信息失败");
	public static final BizException TOPIC_INFO_FAILE= new BizException(90060014, "获取话题信息失败");
	public static final BizException ITEM_REBATE_WARN= new BizException(90060015, "商品没有返利");
	public static final BizException EXPERT_SHAREPIC_WARN= new BizException(90060016, "达人分享商品不足2个");
	public static final BizException SHOP_REBATE_WARN= new BizException(90060017, "店铺没有返利");
	public static final BizException ITEM_PRICE_DEPRECIATE_WARN= new BizException(90060018, "获取商品价格直降失败");
	public static final BizException REBATE_PLAN_INFO_FAILE= new BizException(90060012, "获取计划信息失败");
	

	/**
	 * 异常信息
	 */
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected int code;

	public CmsException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public CmsException() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	/**
	 * 实例化异常
	 * 
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public BizException newInstance(String msgFormat, Object... args) {
		return new BizException(this.code, msgFormat, args);
	}

	public CmsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CmsException(Throwable cause) {
		super(cause);
	}

	public CmsException(String message) {
		super(message);
	}
}
