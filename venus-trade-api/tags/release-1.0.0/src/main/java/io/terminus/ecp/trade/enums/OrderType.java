/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.enums;

/**
 * 总订单类型
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-05 3:51 PM  <br>
 * Author: xiao
 */
//todo: need optimize
public enum  OrderType {

    PLAIN(1, "普通"),
    PRE_SELL(2,"预售"),
    ESTATE_PACKAGE(3,"地产套餐");

    private final int value;

    private final String description;

    private OrderType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return this.value;
    }


    @Override
    public String toString() {
        return description;
    }

}
