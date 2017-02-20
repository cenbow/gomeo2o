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
 * 订单节点(枚举作为选择)
 * Author: haolin
 * On: 2/25/15
 */
@Data
public class OrderNode implements Serializable {

    private static final long serialVersionUID = 6401957401533741241L;

    private Long id;

    private String name;

    private Date createdAt;

    private Date updatedAt;
}
