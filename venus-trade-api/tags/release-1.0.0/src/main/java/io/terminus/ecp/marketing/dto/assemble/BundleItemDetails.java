package io.terminus.ecp.marketing.dto.assemble;

import io.terminus.ecp.item.model.Item;
import io.terminus.ecp.item.model.ItemDetail;
import io.terminus.ecp.item.model.Sku;
import io.terminus.ecp.marketing.model.assemble.ItemBundle;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

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
