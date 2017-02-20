package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

@Data
public class TradeShop implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9124159628104823893L;
	private Long id;
	private String name;
	private Integer type; //店铺类型 1:XPOP 2:O2M
	private String outerShopId;//外部店铺id
	private String shopAddress;//店铺地址信息
	private String shopFlag;//店铺类型分类
	private String distrMode;//店铺配送类型
	private String companyCode;//店铺的公司代码
	private String salesModel;//销售模式
	private Double orderAmountLimit;//订单限制金额: 0不限制
	private Integer entryType;//入驻类型: 1：国内商家,2：海外购商家',
}
