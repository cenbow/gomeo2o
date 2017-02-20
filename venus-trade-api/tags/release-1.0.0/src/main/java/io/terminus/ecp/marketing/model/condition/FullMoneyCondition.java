package io.terminus.ecp.marketing.model.condition;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Desc:满足价格的条件
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
@ToString
public class FullMoneyCondition implements Serializable {
    private static final long serialVersionUID = 8703621975571041222L;

    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private Long money;     //满多少元条件

    @Setter
    @Getter
    private Integer scope;      //作用域（1：订单，2：商品）
}
