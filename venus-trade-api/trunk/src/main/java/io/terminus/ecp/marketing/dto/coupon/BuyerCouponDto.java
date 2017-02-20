/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.marketing.dto.coupon;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:Guo Chaopeng
 * Created on 12/4/14.
 */
public class BuyerCouponDto implements Serializable {

    private static final long serialVersionUID = 4572626706541710851L;

    @Setter
    @Getter
    private Integer type;                //优惠券类型(1:商家优惠券, 2:平台优惠券)

    @Setter
    @Getter
    private Long couponDefId;             //优惠券id

    @Setter
    @Getter
    private String couponName;            //优惠券名称

    @Setter
    @Getter
    private Integer discount;             //优惠券面值

    @Setter
    @Getter
    private Integer remainQuantity;       //买家优惠券剩余数量

    @Setter
    @Getter
    private Integer mostUseQuantity;      //该优惠券每个订单最多使用数量

    @Setter
    @Getter
    private Integer baseMoney;            //起用价格（订单满多少元可用）

    @Setter
    @Getter
    private Date startAt;                 //优惠券开始时间

    @Setter
    @Getter
    private Date endAt;                   //优惠券有效期

    @Setter
    @Getter
    private Boolean isPerMoneyCoupon;     //是否是每满券

}
