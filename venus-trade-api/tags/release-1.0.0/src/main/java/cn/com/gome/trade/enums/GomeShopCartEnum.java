package cn.com.gome.trade.enums;

public enum GomeShopCartEnum {
		ADD_SHOOPCART_TYPE(1,"添加商品到购物车"),
		UPDATE_PRODUCT_NUM_TYPE(2,"更改购物车商品数量"),
		ADD_SHOPCART_MAX_NUM(50,"购物车最多添加50个商品"),
		BUY_SINGLE_PRODUCT_MAX_NUM(20,"单个商品最多购买20个");
		
		private Integer index;
		private String desc;
		
		GomeShopCartEnum(Integer index,String desc){
			this.index = index;
			this.desc = desc;
		}
		public Integer valueOf(){
			GomeShopCartEnum[] values = GomeShopCartEnum.values();
			for(GomeShopCartEnum str: values){
				if(str.getDesc().equals(desc)){
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
		//
	}
