/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递公司码值对应
 *
 * @author Effet
 */
@Data
@EqualsAndHashCode(of = {"name"})
public class ExpressInfo implements Serializable {
    private static final long serialVersionUID = -1835322356949149454L;

    private Long id;

    /**
     * 快递名
     */
    private String name;

    /**
     * 快递代号(快递100)
     */
    private String code;

    /**
     * 状态, 1启用, 0停用, -1逻辑删除
     */
    private Integer status;

    private Date createdAt;

    private Date updatedAt;
}
