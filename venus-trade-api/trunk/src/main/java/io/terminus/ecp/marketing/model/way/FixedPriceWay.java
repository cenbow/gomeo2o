package io.terminus.ecp.marketing.model.way;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc: 一口价数据定义
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/17/15.
 */
@Data
public class FixedPriceWay implements Serializable{
    private static final long serialVersionUID = -6863356625792384146L;

    private Integer scope;      //作用域（1：订单，2：商品）

    private Integer fixedFee;   //价格
}
