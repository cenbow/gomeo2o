/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 店铺评价总和
 * Created by yangzefeng on 14-9-23
 */
@Data
public class OrderCommentSum implements Serializable {

    private static final long serialVersionUID = -8446668080342433695L;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 评价总数
     */
    private Long sumQuantity;

    /**
     * 质量评分总和
     */
    private Long sumQuality;

    /**
     * 描述评分总和
     */
    private Long sumDescribe;

    /**
     * 服务评分总和
     */
    private Long sumService;

    /**
     * 物流评分总和
     */
    private Long sumExpress;
}
