/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 买家订单视图
 * Created by yangzefeng on 14-9-11
 */
@Data
public class RichOrderBuyerView implements Serializable {

    private static final long serialVersionUID = 3452454083372801010L;

    /**
     * 订单详细
     */
    private RichOrder richOrder;

    /**
     * 是否可以确认收货，如果当前有子订单走退货款流程，值为false
     */
    private boolean canConfirm;
}
