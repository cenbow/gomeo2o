/*
 *
 *  * Copyright (c) 2014 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.trade.enums;

/**
 * Author: haolin
 * On: 2/4/15
 */
public enum TradeType {

    PLAIN_ONLINE(1, "普通在线支付"),
    PLAIN_COD(2,"普通货到付款");

    private final Integer value;

    private final String desc;

    private TradeType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer value() {
        return this.value;
    }

    @Override
    public String toString() {
        return desc;
    }
}
