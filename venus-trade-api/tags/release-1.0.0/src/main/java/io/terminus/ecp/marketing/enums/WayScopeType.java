package io.terminus.ecp.marketing.enums;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc: 方式的作用域
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/18/15.
 */
public enum WayScopeType {
    ORDER(1, "订单"),
    ITEM(2, "商品");

    private final int value;

    private final String description;

    private WayScopeType(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static WayScopeType from(Integer value) {
        for (WayScopeType t : WayScopeType.values()) {
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

