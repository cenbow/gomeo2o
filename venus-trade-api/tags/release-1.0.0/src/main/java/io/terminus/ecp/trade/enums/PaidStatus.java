/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.enums;

import com.google.common.base.Objects;

/**
 * 总订单支付状态
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-05 3:47 PM  <br>
 * Author: xiao
 */
public enum PaidStatus {

    NOT_PAID(0, "未付款"),
    PAID(1, "已付款"),
    EXPIRED(-1, "买家关闭交易");

    private final int value;

    private final String description;

    private PaidStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static PaidStatus from(final int value) {
        for (PaidStatus status : PaidStatus.values()) {
            if (Objects.equal(status.value, value)) {
                return status;
            }
        }
        return null;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return description;
    }

}
