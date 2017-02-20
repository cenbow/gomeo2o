/*
 *
 *  * Copyright (c) 2014 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.model.flow;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单流程: 拥有多个订单节点
 * Author: haolin
 * On: 2/25/15
 */
@Data
public class OrderFlow implements Serializable{

    private static final long serialVersionUID = 5126585811372148039L;

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    private Date createdAt;

    private Date updatedAt;
}
