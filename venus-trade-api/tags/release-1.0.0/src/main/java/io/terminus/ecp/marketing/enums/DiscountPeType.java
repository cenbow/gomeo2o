package io.terminus.ecp.marketing.enums;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:优惠对象类型
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-03.
 */
public enum DiscountPeType {
    ALL_BUYER(1, "全网买家"),
    SHOP_BUYER(2, "店铺会员"),
    BUYER_IDS(3, "买家IDS"),
    BUYER_TYPE(4, "买家类型"),
    COMPANY_IDS(5, "所属公司"),
    BUYER_GENDER(6, "买家性别"),
    BUYER_AGE(7, "买家年龄段");

    private final int value;

    private final String description;

    private DiscountPeType(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static DiscountPeType from(Integer value) {
        for (DiscountPeType t : DiscountPeType.values()) {
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
