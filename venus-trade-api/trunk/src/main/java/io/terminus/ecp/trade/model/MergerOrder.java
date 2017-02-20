package io.terminus.ecp.trade.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MergerOrder  implements Serializable {

	private static final long serialVersionUID = -619619537142654837L;
	
	/**
     *merger_id
     */
    private Long mergerId;
    
    /***
     * 支付ID
     */
    private Long payId;
    
    /**
     * 订单运费
     */
    private Integer shipFee;
    /**
     * 订单总费用
     */
    private Integer fee;
    /**
     * 订单原价
     */
    private Integer originFee;
    /**
     * 优惠(折扣)
     */
    private Integer discount;
    /**
     * 订单使用的账户余额
     */
    private Integer balance;
    
    /**
     * 优惠券
     */
    private Integer couponPrice;
    
    /***
     * 拆分平台优惠
     */
    private Integer platCouponPrice;
    
    /**
     * 拆分平台ID
     */
    private Long platCouponId;
    
    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
    
    /**
     * 订单状态
     * @see io.terminus.ecp.trade.enums.Status
     */
    private Integer status;
    
    /**
     * 买家ID
     */
    private Long buyerId;
    
    /**
     * 外部订单id
     */
    private Long outMergerOrderId;
    
	public MergerOrder(Long mergerId, Long payId, Integer shipFee,
			Integer fee, Integer originFee, Integer discount, Integer balance,Integer couponPrice,
			Integer platCouponPrice, Long platCouponId) {
		super();
		this.mergerId = mergerId;
		this.payId = payId;
		this.shipFee = shipFee;
		this.fee = fee;
		this.originFee = originFee;
		this.discount = discount;
		this.balance = balance;
		this.couponPrice = couponPrice;
		this.platCouponPrice = platCouponPrice;
		this.platCouponId = platCouponId;
	}

	public MergerOrder() {
		super();
	}
	
}
