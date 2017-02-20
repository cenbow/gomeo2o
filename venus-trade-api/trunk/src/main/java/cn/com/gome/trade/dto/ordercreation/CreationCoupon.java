package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreationCoupon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3601331115376340394L;
	private Long id;  //主键id
	private Long shopId;  //店铺金额
	private Long startTime; //有效开始时间
	private Long endTime;
	private Integer type;
	private Integer money;
	private Integer quantity;
	private Integer baseMoney; 
	private Long planId;
	private ActivityDto activity;//活动信息
	private Integer couponPlat;//CouponPlatEnum
	private String planName;
	private String budgetCode;
}
