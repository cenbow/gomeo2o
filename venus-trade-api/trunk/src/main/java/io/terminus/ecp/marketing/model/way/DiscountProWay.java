package io.terminus.ecp.marketing.model.way;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:打折优惠方式
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
@Data
public class DiscountProWay implements Serializable {
    private static final long serialVersionUID = -3420804264200812352L;

    private Integer discount;   //打折（保留1位小数：9.5折）

    private Integer scope;      //作用域（1：订单，2：商品）
}
