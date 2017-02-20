/*
 *
 *  * Copyright (c) 2015 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.trade.model.flow.OrderFlow;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * Author: haolin
 * On: 3/3/15
 */
@Data
public class OrderFlowDetail implements Serializable {

    private static final long serialVersionUID = -7471816282014769491L;

    private OrderFlow flow;

    private List<OrderNodeInstanceDetail> nodes;
}
