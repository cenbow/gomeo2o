/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.enums;

import com.google.common.base.Objects;

/**
 * @author Effet
 */
public enum ExpressStatus {
    /**
     * 启用
     */
    ENABLED(1),
    /**
     * 停用
     */
    DISABLED(0),
    /**
     * 逻辑删除
     */
    DELETED(-1);

    int value;

    private ExpressStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ExpressStatus from(Integer value) {
        for (ExpressStatus status : ExpressStatus.values()) {
            if (Objects.equal(status.value, value)) {
                return status;
            }
        }
        return null;
    }
}
