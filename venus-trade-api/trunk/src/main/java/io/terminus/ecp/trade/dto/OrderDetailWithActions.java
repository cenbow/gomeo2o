/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.flow.OrderActionInstance;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangzefeng on 15/3/31
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class OrderDetailWithActions extends OrderDetail implements Serializable {
    private static final long serialVersionUID = 2145631564537360819L;

    private List<OrderActionInstance> actionInstances;
}
