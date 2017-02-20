package cn.com.mx.cms.enums;
/**
 * @Description 推荐的类型 
 * @author zhangxianpeng
 * @date 2015年12月1日 下午1:55:37
 */
public enum RecommendType {
	/**
	 * 普通推荐
	 */
	commonRec("普通推荐", 0),
	/**
	 * 最热群组
	 */
	groupRec("最热群组", 1),
	/**
	 * 达人推荐
	 */
	expertRec("达人推荐", 2),
	/**
	 * 精品推荐
	 */
	boutiqueRec("精品推荐", 3),
	/**
	 * 精选店铺
	 */
	shopRec("精选店铺", 4),
	/**
	 * 促销活动
	 */
	promotionRec("促销活动", 5), 
	/**
	 * 热门话题
	 */
	topicRec("热门话题", 6),
	/**
	 * 资讯广播
	 */
	broadcastRec("资讯广播", 7), 
	/**
	 * 达人动态
	 */
	expertDynRec("达人动态", 8),
	/**
	 * 找便宜超级返
	 */
	superRebateRec("找便宜超级返", 9);
	/**
	 * 值
	 */
	private String label;

	/**
	 * 编号
	 */
	private int code;

	private RecommendType(String label, int code) {
		this.code = code;
		this.label = label;
	}

	public static String getLabel(int code) {
		for (RecommendType t : RecommendType.values()) {
			if (t.getCode() == code) {
				return t.label;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return String.valueOf(this.code);
	}

	/**
	 * 比较
	 * 
	 * @param code
	 * @return
	 */
	public boolean compare(String code) {
		try {
			return this.code == Integer.parseInt(code);
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 比较
	 * 
	 * @param code
	 * @return
	 */
	public boolean compare(int code) {
		return this.code == code;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
}