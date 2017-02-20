/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.model;

import com.google.common.collect.Multiset;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:
 * Mail: F@terminus.io
 * Data: 15/7/15
 * Author: yangzefeng
 */
@Data
public class UserShopCart implements Serializable {

    private Long shopId;

    private Multiset<Long> skuIds;

    private Date updatedAt;
}
