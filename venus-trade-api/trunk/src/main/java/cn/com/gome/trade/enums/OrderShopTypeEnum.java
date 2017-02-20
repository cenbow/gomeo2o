package cn.com.gome.trade.enums;

public enum OrderShopTypeEnum {
	XPOP_SHOP(1, "XPOP店铺"),
	O2M_SHOP(2, "O2M店铺"),
	ONLINE_SELF(3, "在线自营"),
	ONLINE_JOINT(4, "在线联营"),
	OVERSEA_SELF(42, "海外购自营"),
	OVERSEA_JOINT(43, "海外购联营");

	private Integer index;
	private String desc;

	OrderShopTypeEnum(Integer index, String desc) {
		this.index = index;
		this.desc = desc;
	}

	public Integer valueOf() {
		GomeShopCartEnum[] values = GomeShopCartEnum.values();
		for (GomeShopCartEnum str : values) {
			if (str.getDesc().equals(desc)) {
				return str.getIndex();
			}
		}
		return 0;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
