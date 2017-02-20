/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yangzefeng on 15/3/27
 */
@Data
public class SkuIdAndQuantityAndLevel implements Serializable {
    private static final long serialVersionUID = -2909326521520788204L;

    private Long skuId;

    private Integer quantity;

    private Integer level;
}
