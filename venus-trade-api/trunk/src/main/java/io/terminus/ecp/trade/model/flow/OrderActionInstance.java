/*
 *
 *  * Copyright (c) 2015 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.model.flow;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 动作实例(针对某个节点实例)
 * Author: haolin
 * On: 2/27/15
 */
@Data @EqualsAndHashCode(of = {"id"})
public class OrderActionInstance implements Serializable {

    private static final long serialVersionUID = -3515843701795982711L;

    /**
     * ID
     */
    private Long id;

    /**
     * 对应的Action ID
     */
    private Long aid;

    /**
     * 上一节点实例ID
     */
    private Long pnid;

    /**
     * 当前节点实例ID
     */
    private Long nid;

    /**
     * 名称
     */
    private String name;

    /**
     * 动作名称(bean id)
     */
    private String action;

    /**
     * 是否是起始动作
     */
    private Boolean start;

    /**
     * 是否是结尾动作
     */
    private Boolean end;

    /**
     * 是否显示在前端
     */
    private Boolean display;

    /**
     * 是否导致流程流转
     */
    private Boolean flow;

    /**
     * 是否为全局动作(即整个流程都可执行的动作)
     */
    private Boolean global;

    /**
     * 是否为自动触发的任务Action 1->normal, 2->schedule, 3->notify
     */
    private Integer type;

    /**
     * Action实例属于哪种用户类型，0-运营，1-买家，2-卖家，4-系统
     */
    private Integer userType;

    private Date createdAt;

    private Date updatedAt;


    public static enum Type {

        NORMAL(1, "普通action"),
        SCHEDULE(2, "定时任务"),
        NOTIFY(3, "通知");

        private final Integer value;

        private final String display;

        private Type(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        @Override
        public String toString() {
            return display;
        }

        public Integer value() {
            return value;
        }

        public static Type from(Integer value) {
            for(Type t : Type.values()) {
                if (Objects.equals(t.value, value)) {
                    return t;
                }
            }
            return null;
         }
    }
}
