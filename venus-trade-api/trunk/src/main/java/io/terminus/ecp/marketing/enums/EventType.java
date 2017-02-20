package io.terminus.ecp.marketing.enums;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc: 系统事件类型
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/16/15.
 */
public enum EventType {
    ACTIVITY(1, "交易"),
    REGISTER(2, "注册"),
    LOGIN(3, "登陆"),
    INVITE(4, "邀请"),
    EVALUATION(5, "评价"),
    COLLECTION(6, "收藏");

    private final int value;

    private final String description;

    private EventType(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static EventType from(Integer value) {
        for (EventType t : EventType.values()) {
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
