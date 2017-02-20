package io.terminus.ecp.marketing.model.way;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:减现优惠方式
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
@Data
public class DiscountCashWay implements Serializable {
    private static final long serialVersionUID = -3420804264200812352L;

    private Integer discount;   //减现（保留2位小数:减100元）

    private Integer scope;      //作用域（1：订单，2：商品）

    public float discountFee(){
        return (float)this.discount / 100;
    }
}
