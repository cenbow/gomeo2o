package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import com.google.common.collect.Lists;

@Data
public class Sku implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2297891476493346959L;
	private Long id;  //主键id
	private String image;  //图片地址
	private List<Attribute> attributes = Lists.newArrayList(); //商品销售属性
	private TradeItem item;   //商品信息
	private Integer price;  //价格
	private Activity activity; //活动信息
	private Integer discount; //直降了多少价格
	private String outSkuid;
	private String skuStorageKeyStr;//设置外部库存
	private String outSkuNo; //通用的sku码，非内部编码skuid
	private String extra; //isElectrical为1 是电器类 isElectrical为0 是百货类
	
	//海外购新增
	private String salesFee;
	private String vatFee;
	private String tariffFee;
	private String synthesize;
	
	private String salesRate;
	private String vatRate;
	private String tariffRate;
	private String hwgTaxRate;

}
