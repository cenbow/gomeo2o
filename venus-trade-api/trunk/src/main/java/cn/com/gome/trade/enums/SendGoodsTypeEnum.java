/**
 * 
 */
package cn.com.gome.trade.enums;

/**
 * @author tangfeng
 *
 */
public enum SendGoodsTypeEnum {
	SEND_BY_WORKDAYS (1,"只工作日送货"),
	SEND_BY_WEEEKENDS_AND_HOLIDAYS (2,"只双休日、假日送货"),
	SEND_BY_ANYDAYS  (3,"工作日、双休日与假日均可送货");
	
	/**
	 * 枚举值
	 */
	private int index;
	/**
	 * 枚举值描述
	 */
	private String desc;
	
	
	private SendGoodsTypeEnum(int index, String desc) {
		this.index = index;
		this.desc = desc;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static SendGoodsTypeEnum getEnum(int index){
		for(SendGoodsTypeEnum typeEnum:SendGoodsTypeEnum.values()){
			if(typeEnum.getIndex() == index){
				return typeEnum;
			}
		}
		return null;
	}
	public static String getEnumDesc(int index){
		for(SendGoodsTypeEnum typeEnum:SendGoodsTypeEnum.values()){
			if(typeEnum.getIndex() == index){
				String desc2 = typeEnum.getDesc();
				return desc2;
			}
		}
		return null;
	}
}
