package cn.com.gome.marketing.model;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:直降规则
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-14.
 */
public enum RuleCondition {
    ITEM_DOWN(4, "直降");

    private final int value;

    private final String description;

    private RuleCondition(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static RuleCondition from(Integer value) {
        for (RuleCondition t : RuleCondition.values()) {
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
