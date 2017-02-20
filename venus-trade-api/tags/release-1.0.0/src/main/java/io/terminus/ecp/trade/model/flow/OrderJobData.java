/*
 *
 *  * Copyright (c) 2015 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.model.flow;

import com.google.common.base.Objects;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单Job的数据
 * Author: haolin
 * On: 3/4/15
 */
@Data
public class OrderJobData implements Serializable {

    private static final long serialVersionUID = 4883864747767682003L;

    /**
     * ID
     */
    private Long id;

    /**
     * 对应的订单id
     */
    private Long orderId;

    /**
     * 订单状态,在状态流转前做验证
     */
    private Integer orderStatus;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务数据, 比如一些调度信息或者action的参数信息
     */
    private String data;

    /**
     * 对应的action bean id
     */
    private String action;

    /**
     * 添加自动任务的node instance id
     */
    private Long nodeInstanceId;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 超时时间
     */
    private Integer expireHours;

    /**
     * 定时执行任务的状态 1->normal, -1->finish
     */
    private Integer status;

    /**
     * 超时时间点(预售活动的超时时间是一个具体时间点)
     */
    private Date expireAt;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    public static enum Status {
        NORMAL(1, "正常"),
        FINISH(-1, "已结束");

        private int value;
        private String desc;

        private Status(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public int value() {
            return value;
        }

        public static Status from(int number) {
            for (Status status : Status.values()) {
                if (Objects.equal(status.value, number)) {
                    return status;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return desc;
        }
    }
}
