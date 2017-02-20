package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SubOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 771823237580642831L;
	private String subInx;//子单序号，1-999，在一个订单内不能重复
	private String shopCode;//国美电器的虚拟门店代码
	private String skuStorageKeyStr;//Sku对应的库存关键信息，在实时查询库存时返回
	private Integer requireInstall;//商品是否需要安装 0否1是
	private Integer deliverFee;//配送费 单位分，收顾客钱为正值，退顾客钱为负值
	private List<SkuItem> skuItems;//o2m订单商品行列表
	private Long subOrderId;//子订单id
	private Integer status;//子订单状态 

}
