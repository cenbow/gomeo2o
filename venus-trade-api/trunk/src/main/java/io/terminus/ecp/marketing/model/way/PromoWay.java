package io.terminus.ecp.marketing.model.way;

import io.terminus.ecp.marketing.model.promo.PromoDefinition;
import lombok.Data;

import java.io.Serializable;

/**
 * Desc: 优惠码方式
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/18/15.
 */
@Data
public class PromoWay implements Serializable{
    private static final long serialVersionUID = -4859854817257473260L;

    private PromoDefinition promoDefinition;

    private Integer num;

    private Integer scope;      //作用域（1：订单，2：商品）
}
