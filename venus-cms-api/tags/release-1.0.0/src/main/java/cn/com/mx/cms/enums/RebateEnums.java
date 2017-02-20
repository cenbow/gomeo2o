package cn.com.mx.cms.enums;

/**
 * @Description 超级返的类型
 * @author zhangxianpeng
 * @date 2015年12月1日 下午1:58:12
 */
public enum RebateEnums {

	product("商品", 0), // 商品

	shop("店铺", 1), // 店铺

	h5("h5", 2);// H5

	/**
	 * 值
	 */
	private String label;

	/**
	 * 编号
	 */
	private int code;

	private RebateEnums(String label, int code) {
		this.code = code;
		this.label = label;
	}

	public static String getLabel(int code) {
		for (RebateEnums t : RebateEnums.values()) {
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
