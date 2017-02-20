package io.terminus.ecp.marketing.model.way;

import io.terminus.ecp.marketing.model.coupon.CouponDefinition;
import lombok.Data;

import java.io.Serializable;

/**
 * Desc: 优惠劵数据存储
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/17/15.
 */
@Data
public class CouponWay implements Serializable{

    private static final long serialVersionUID = 3069625487135990018L;

    private CouponDefinition couponDefinition;

    private Long couponId;  //coupon的数据

    private Integer num;    //数量

    private Integer scope;  //范围
}
