/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 订单详细
 * Created by yangzefeng on 14-9-11
 */
@Data
public class
        RichOrder implements Serializable {

    private static final long serialVersionUID = -4937145957485041052L;

    /**
     * 总订单
     */
    private Order order;

    /**
     * 子订单
     */
    private List<RichOrderItem> richOrderItems;
}
