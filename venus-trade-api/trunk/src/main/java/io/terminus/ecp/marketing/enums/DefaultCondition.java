package io.terminus.ecp.marketing.enums;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:系统默认的优惠条件类型
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
public enum DefaultCondition {
    FULL_MONEY(1, "满(N)元"),
    FULL_NUMBER(2, "满(N)件"),
    TIME_RANGE(3, "每天限时");

    private final int value;

    private final String description;

    private DefaultCondition(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static DefaultCondition from(Integer value) {
        for (DefaultCondition t : DefaultCondition.values()) {
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
