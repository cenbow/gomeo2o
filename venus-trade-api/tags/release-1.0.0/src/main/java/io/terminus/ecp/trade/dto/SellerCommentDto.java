/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.dto;

import io.terminus.ecp.item.model.Item;
import lombok.Data;

import java.io.Serializable;

/**
 * Mail: F@terminus.io
 * Data: 15/5/27
 * Author: yangzefeng
 */
@Data
public class SellerCommentDto implements Serializable {
    private static final long serialVersionUID = 3972228998667962415L;

    private Item item;

    /**
     * 评价数量
     */
    private Integer commentCount;

    /**
     * 月成交记录
     */
    private Integer monthDeal;
}
