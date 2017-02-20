package io.terminus.ecp.marketing.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Desc: 商品订单活动
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-03.
 */
public class DefOrder implements Serializable {
    private static final long serialVersionUID = 3409330903558334128L;

    @Getter
    @Setter
    private Long itemId;        //商品编号

    @Getter
    @Setter
    private Integer num;        //购买数量

    @Getter
    @Setter
    private Long activityId;    //标记当前商品使用的优惠活动（用于切换子订单优惠时，对总订单的影响）
}
