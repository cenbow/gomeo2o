package io.terminus.ecp.marketing.model.way;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:优惠码优惠方式
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
@Data
public class DiscountNumWay implements Serializable {
    private static final long serialVersionUID = -3420804264200812352L;
    //todo 优惠码这种之后在考虑
    private Long id;

    private String discountNum; //优惠编码

    private Integer scope;      //作用域（1：订单，2：商品）

    private Date createdAt;     //创建时间

    private Date updatedAt;     //结束时间
}
