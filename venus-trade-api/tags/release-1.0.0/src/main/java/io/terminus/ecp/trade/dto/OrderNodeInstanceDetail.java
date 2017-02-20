/*
 *
 *  * Copyright (c) 2015 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.flow.OrderActionInstance;
import io.terminus.ecp.trade.model.flow.OrderNodeInstance;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * Author: haolin
 * On: 3/3/15
 */
@Data
public class OrderNodeInstanceDetail implements Serializable {

    private static final long serialVersionUID = -6477567714871037446L;

    private OrderNodeInstance instance;

    private List<OrderActionInstance> actions;
}
