package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

@Data
public class CouponPlan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2490085591521049168L;
	private Long id; //优惠券id
	private Integer type; //优惠券类型
	private Integer money; //优惠券金额
	private Integer quantity; //优惠券数量
	private Integer baseMoney; //优惠券使用条件
	private Long startTime; //优惠券使用开始时间
	private Long endTime; //优惠券使用结束时间
	private Long ownerId; //拥有者Id
}