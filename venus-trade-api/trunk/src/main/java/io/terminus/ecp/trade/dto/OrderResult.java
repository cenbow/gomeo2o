/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangzefeng on 14-9-22
 */
@Data
public class OrderResult implements Serializable {

    private static final long serialVersionUID = 7416658391736043092L;

    /**
     * 库存变化
     */
    private List<StockChange> stockChanges;
}
