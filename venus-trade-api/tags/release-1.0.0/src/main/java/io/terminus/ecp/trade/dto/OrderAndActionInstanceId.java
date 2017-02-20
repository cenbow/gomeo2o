/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.Order;
import io.terminus.ecp.trade.model.flow.OrderActionInstance;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangzefeng on 15/4/3
 */
@Data
public class OrderAndActionInstanceId implements Serializable {
    private static final long serialVersionUID = 2601600500463256923L;

    private Order order;

    private List<OrderActionInstance> actionInstances;
}
