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
 * 节点实例，针对某个流程OrderFlow
 * Author: haolin
 * On: 2/25/15
 */
@Data
public class OrderNodeInstance implements Serializable {

    private static final long serialVersionUID = 4366557649538075247L;

    /**
     * ID
     */
    private Long id;

    /**
     * 节点ID
     */
    private Long nid;

    /**
     * 父节点实例ID
     */
    private Long pid;

    /**
     * 订单流程ID
     */
    private Long fid;

    /**
     * 节点名称(状态名称):
     * @see OrderNode name
     */
    private String name;

    /**
     * 是否为结算节点
     */
    private Boolean isSettle;

    /**
     * 是否是尾节点
     */
    private Boolean isTail;

    /**
     * 是否是头结点
     */
    private Boolean isHead;

    /**
     * 是否可以进入退款流程
     */
    private Boolean canRefund;

    /**
     * 是否可以进入退货流程
     */
    private Boolean canReturns;

    /**
     * 是否可以评价
     */
    private Boolean canComment;

    /**
     * 是否可以删除
     */
    private Boolean canDelete;

    /**
     * 是否可以修改收货地址信息
     */
    private Boolean canModifyTradeInfo;

    /**
     * 是否可以修改买家留言
     */
    private Boolean canModifyBuyerNotes;

    /**
     * 是否可以修改订单价格
     */
    private Boolean canModifyPrice;

    /**
     * 是否可以修改卖家留言
     */
    private Boolean canModifySellerNotes;

    /**
     * 是否在节点触发自动执行任务
     */
    private Boolean hasSchedule;

    /**
     * 如果有自动执行任务，任务名称不为空
     */
    private String scheduleActionName;

    /**
     * 如果有自动执行任务，任务的默认超时时间
     */
    private Integer defaultExpireHours;

    /**
     * 超时时间点
     */
    private Date expireAt;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;
}
