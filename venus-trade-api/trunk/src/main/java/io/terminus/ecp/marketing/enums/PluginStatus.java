package io.terminus.ecp.marketing.enums;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc: 插件状态
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
public enum PluginStatus {
    ACTIVITY(1, "交易"),
    REGISTER(2, "注册"),
    LOGIN(3, "登陆"),
    INVITE(4, "邀请"),
    EVALUATION(5, "评价"),
    COLLECTION(6, "收藏");

    private final int value;

    private final String description;

    private PluginStatus(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static PluginStatus from(Integer value) {
        for (PluginStatus t : PluginStatus.values()) {
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
