package io.terminus.ecp.trade.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 联表查询   mergerOrder 和 order
 * @author tangfeng
 *
 */
@Data
public class MergerOrderUnionOrder implements Serializable{


	private static final long serialVersionUID = 288321308949348773L;
	
	
	public MergerOrderUnionOrder() {
		super();
	}
	
	public MergerOrderUnionOrder(Long unionOrderId, Long buyerId,
			Integer status, Long shipFee, Long fee, Long originFee,
			Long balance, Long discount, Long couponPrice, Date createdAt) {
		super();
		this.unionOrderId = unionOrderId;
		this.buyerId = buyerId;
		this.status = status;
		this.shipFee = shipFee;
		this.fee = fee;
		this.originFee = originFee;
		this.balance = balance;
		this.discount = discount;
		this.couponPrice = couponPrice;
		this.createdAt = createdAt;
	}



	/**
	 * 总单ID 或者 订单ID
	 */
	private Long unionOrderId;
	/**
	 * 买家
	 */
	private Long buyerId;
	/**
	 * 定单状态
	 */
	private Integer status ;
	/**
	 * 运费
	 */
	private Long shipFee;
	/**
	 * 支付金额
	 */
	private Long fee;
	/**
	 * 原价
	 */
	private Long originFee;
	/**
	 * 使用的国美币
	 */
	private Long balance;
	/**
	 * 折扣
	 */
	private Long discount;
	/**
	 * 优惠券金额
	 */
	private Long couponPrice;
	/**
	 * 创建时间
	 */
	private Date createdAt ;

}
