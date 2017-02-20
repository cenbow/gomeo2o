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
    GOME_ONLINE(4, "国美在线"),
    GOME_ONLINE_SELF(6, "国美在线自营"),
    GOME_ONLINE_AFFILIATION(7, "国美在线联营"),
    GOME_SEA_SELF(8, "海外购自营"),
    GOME_SEA_AFFILIATION(9, "海外购联营"),
    O2M(5,"O2M");

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
