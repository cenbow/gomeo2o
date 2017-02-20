/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.enums;

import com.google.common.base.Objects;

/**
 * 物流类型
 *
 * @author Effet
 */
public enum LogisticsType {
    /**
     * 无需物流
     */
    NONE(0),
    /**
     * 第三方物流
     */
    THIRD(1),
    /**
     * 海尔物流
     */
    HAIER(2);

    private final int value;

    private LogisticsType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static LogisticsType from(Integer value) {
        for (LogisticsType type : LogisticsType.values()) {
            if (Objects.equal(type.value, value)) {
                return type;
            }
        }
        return null;
    }
}
