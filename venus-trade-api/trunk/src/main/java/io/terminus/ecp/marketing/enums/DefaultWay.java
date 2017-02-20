package io.terminus.ecp.marketing.enums;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:系统默认的优惠方式类型
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
public enum DefaultWay {
    COUPON_WAY(1, "优惠券"),
    CASH_WAY(2, "减现"),
    PRO_WAY(3, "打折"),
    NUM_WAY(4, "优惠码"),
    GIFT_WAY(5, "赠品"),
    FIEXED_WAY(6, "一口价"),
    FREE_SHIP_WAY(7, "包邮");

    private final int value;

    private final String description;

    private DefaultWay(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static DefaultWay from(Integer value) {
        for (DefaultWay t : DefaultWay.values()) {
            if (equalWith(t.value, value)) {
                return t;
            }
        }
        return null;
    }

    public int value(){
        return this.value;
    }

    @Override
    public String toString(){
        return this.description;
    }
}
