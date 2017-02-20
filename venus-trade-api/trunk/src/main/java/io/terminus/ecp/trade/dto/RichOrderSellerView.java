/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 卖家订单视图
 * Created by yangzefeng on 14-9-11
 */
@Data
public class RichOrderSellerView implements Serializable {

    private static final long serialVersionUID = 6400061774811435333L;

    /**
     * @see io.terminus.ecp.trade.dto.RichOrder
     */
    private RichOrder richOrder;

    /**
     * 是否可以发货，如果有子订单正在走退款流程，值为false
     */
    private boolean canDeliver;
}
