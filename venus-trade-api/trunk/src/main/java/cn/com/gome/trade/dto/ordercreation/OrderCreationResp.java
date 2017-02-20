package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import com.google.common.collect.Lists;

@Data
public class OrderCreationResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7553141920320311412L;
	private String addressJson;
	private String deliveryJson;
	private String invoiceJson;
	private Buyer buyer;
	private List<CreationOrder> orders = Lists.newArrayList();
	private Integer gomeMoney;  //使用的国美币
	private List<CreationCoupon> coupons = Lists.newArrayList();  //使用优惠券情况
	private Integer payType; //支付类型
	private Integer couponMoney; //优惠券总额
	private Integer shipFee; //总运费
	private Integer fee; //总支付金额
	private Integer originFee; //订单原价
	private Integer discount; //直降优惠总额
	private Integer platCouponPrice; //平台优惠总价
	private Long platCouponId; //平台优惠券id
	private Long mergerId;//合单id
}