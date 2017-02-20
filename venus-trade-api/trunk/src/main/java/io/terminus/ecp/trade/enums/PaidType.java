/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.enums;

/**
 * 订单支付类型
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-05 3:49 PM  <br>
 * Author: xiao
 */
public enum  PaidType {

    ONLINE(1, "在线支付"),
    COD(2,"货到付款"),
    SCORE(3,"积分"),
    NEWONLINE(4, "新在线支付");


    private final int value;

    private final String description;

    private PaidType(int value, String description) {
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
