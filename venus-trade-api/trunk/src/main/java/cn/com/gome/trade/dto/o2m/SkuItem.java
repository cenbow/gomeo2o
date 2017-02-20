package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;

@Data
public class SkuItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3020640845122656113L;
	private String skuItemId;//商品明细项ID
	private String skuInx; //商品序号，在一个订单内不能重复
	private Integer originalSkuItemId;//逆向时的原订单的商品明细项ID
	private Integer skuId;//国美电器的SkuId
	private Integer outerSkuId;//POP平台的SkuId
	private Integer retailPrice;//商品原价 单位分
	private Integer dealPrice;//商品成交价  单位分
	private Integer dealAmount;//成交总额 单位分，正向订单为正值，逆向订单为负值
	private Integer discAmount;//折扣总额 单位分，正向订单为正值，逆向订单为负值
	private Integer saleNum;//销售数量，正向订单为正值，逆向订单为负值

}
