package io.terminus.ecp.marketing.dto.assemble;

import io.terminus.ecp.marketing.model.assemble.ItemBundle;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import cn.com.gome.trade.dto.itemdto.Item;

/**
 * Created by yangzefeng on 14-4-24
 */
public class BundleItems implements Serializable {
    private static final long serialVersionUID = -4003926908602718100L;

    @Getter
    @Setter
    private ItemBundle itemBundle;

    @Getter
    @Setter
    private List<Item> items;
}
