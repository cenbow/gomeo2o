package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CreationOrderItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2745253266990635362L;
	private Long orderItemId;
	private Mshop mshop;
	private String kid;
	private Sku sku;
	private Integer couponPrice;//优惠券价格
	private Integer gomeMoneyPrice;//国美币价格
	private Integer shipFee; //总运费
	private Integer fee; //总支付金额
	private Integer originFee; //订单原价
	private Integer discount; //直降优惠总额
	private String reference;//来源
	private Integer quantity;   //数量
	private String sourceCode; //商品来源
	private List<ActivityDto> activities;          	// 活动信息
	private String skuInx;//o2m商品序号，在一个订单内不能重复
	private Boolean isUserIdentityRequired; //是否是跨境商品
	private String outOrderItemId;//外部订单号
	private Integer tax;//税费
}
