package cn.com.gome.marketing.model;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:国美优惠工具方式定义
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-28.
 */
public enum RuleWay {
    ITEM_DOWN(8, "商品直降");

    private final int value;

    private final String description;

    private RuleWay(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static RuleWay from(Integer value) {
        for (RuleWay t : RuleWay.values()) {
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
