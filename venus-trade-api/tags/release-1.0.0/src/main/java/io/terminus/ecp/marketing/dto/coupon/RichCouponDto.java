/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.marketing.dto.coupon;

import io.terminus.ecp.marketing.model.coupon.Coupon;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Author:Guo Chaopeng
 * Created on 12/5/14.
 */
public class RichCouponDto implements Serializable {

    private static final long serialVersionUID = -1391203640483022524L;

    @Setter
    @Getter
    private Coupon coupon;      //优惠券

    @Setter
    @Getter
    private boolean isExpire;   //是否过期

}
