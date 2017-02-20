package cn.com.gome.trade.enums;

public enum ShopEntryTypeEnum {
	
	DOMESTIC_SUPPLIER(1, "国内商家"), 
	OVERSEA_SUPPLIER(2, "海外购商家");

	private Integer index;
	private String desc;

	ShopEntryTypeEnum(Integer index, String desc) {
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
