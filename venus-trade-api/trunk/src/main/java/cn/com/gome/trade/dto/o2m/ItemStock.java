package cn.com.gome.trade.dto.o2m;

import static io.terminus.common.utils.Arguments.equalWith;

import java.io.Serializable;

import lombok.Data;
@Data
public class ItemStock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -307985962979394326L;
	
	String shopCode;//国美电器的虚拟门店代码
	Integer skuId;//国美电器的SkuId
	Integer decNum;//准备减少的库存数量
	Integer stockStatus;//库存状态 0库存不够减 1库存够减
	String skuStorageKeyStr;//Sku对应的库存关键信息，提交订单时需要
	Integer isSmallWares;//是否3C小件仓 1是0否，如果是3C小件仓，走国美在线平台的快递配送，如果不是，走国美电器自己的物流配送
	
	public static enum StockType{
		ENOUGH(1,"库存够减"),
		NOTENOUGH(0,"库存不够减");
		
		private final Integer value;
		
		private final String display;

        private StockType(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static StockType fromNumber(Integer value) {
            for (StockType t : StockType.values()) {
                if (equalWith(t.value, value)) {
                    return t;
                }
            }
            return null;
        }

        public Integer toNumber() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.display;
        }
	}

}
