/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.flow.OrderActionInstance;
import io.terminus.ecp.trade.model.flow.OrderNodeInstance;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangzefeng on 15/3/31
 */
@Data
public class RichOrderWithActions implements Serializable {
    private static final long serialVersionUID = 5735716356164990791L;

    private Order order;

    private List<RichOrderItem> richOrderItems;

    private List<OrderActionInstance> actionInstances;

    private OrderNodeInstance orderNodeInstance;
}
