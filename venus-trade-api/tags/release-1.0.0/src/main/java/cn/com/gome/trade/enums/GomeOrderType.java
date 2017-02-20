package cn.com.gome.trade.enums;

/**
 * Mail: F@terminus.io
 * Data: 15/5/29
 * Author: yangzefeng
 */
public enum GomeOrderType {

    PLAIN(1, "普通"),
    PRE_SELL(2,"预售"),
    ESTATE_PACKAGE(3,"地产套餐"),
    GOME_ONLINE(4, "国美在线");

    private final int value;

    private final String description;

    private GomeOrderType(int value, String description) {
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
