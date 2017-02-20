/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by yangzefeng on 15/4/17
 */
@Data
public class SkuIdAndInfo implements Serializable {
    private static final long serialVersionUID = -1325386315234076838L;

    private Long skuId;

    private Integer quantity;

    private Integer level;

    /**
     * sku对应的活动id
     */
    private Long activityId;

    /**
     * 外部系统sku级别需要记录的信息
     */
    private Map<String, Object> outParams;

    /**
     * 订单来源
     */
    private String reference;

    /**
     * 来源id
     */
    private String referenceId;

    /**
     * 商品额外信息
     */
    private Map<String, Object> itemExtras;
}
