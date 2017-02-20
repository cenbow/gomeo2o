package io.terminus.ecp.marketing.model.way;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc: 包邮
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/18/15.
 */
@Data
public class FreeShipWay implements Serializable{
    private static final long serialVersionUID = -1958314603177995199L;

    private Integer scope;      //作用域（1：订单，2：商品）

    private Boolean freeShip;   //是否包邮
}
