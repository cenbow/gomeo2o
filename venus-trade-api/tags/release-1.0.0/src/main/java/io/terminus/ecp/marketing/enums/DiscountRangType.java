package io.terminus.ecp.marketing.enums;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:优惠范围类型
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-03.
 */
public enum DiscountRangType {
    ALL_SHOP(1, "全部站点"),
    SHOP_RANG(2, "指定店铺"),
    CATEGORY_RANG(3, "指定类目"),
    ITEM_RANG(4, "指定商品"),
    SPU_RANG(5, "商品SPU"),
    BRAND_RANG(6, "商品品牌"),
    BUSINESS_RANG(7, "所属行业");

    private final int value;

    private final String description;

    private DiscountRangType(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static DiscountRangType from(Integer value) {
        for (DiscountRangType t : DiscountRangType.values()) {
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
