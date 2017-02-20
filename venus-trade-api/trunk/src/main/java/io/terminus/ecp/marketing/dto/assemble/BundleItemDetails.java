package io.terminus.ecp.marketing.dto.assemble;

import io.terminus.ecp.marketing.model.assemble.ItemBundle;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import cn.com.gome.trade.dto.itemdto.Item;
import cn.com.gome.trade.dto.itemdto.ItemDetail;
import cn.com.gome.trade.dto.itemdto.Sku;

/**
 * Created by yangzefeng on 14-4-24
 */
public class BundleItemDetails implements Serializable {
    private static final long serialVersionUID = 4034432807368437709L;

    @Getter
    @Setter
    private ItemBundle itemBundle;

    @Getter
    @Setter
    private List<ItemDetailAndSku> itemDetails;

    public static class ItemDetailAndSku {
        @Getter
        @Setter
        private Item item;

        @Getter
        @Setter
        private List<Sku> skuList;

        @Getter
        @Setter
        private ItemDetail itemDetail;
    }
}
