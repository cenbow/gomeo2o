/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

import io.terminus.ecp.item.model.Item;

/**
 * @author Effet
 */
public class ItemFrozenEvent extends ItemStatusEvent {
    public ItemFrozenEvent(long id) {
        super(Item.Status.FROZEN.value(), id);
    }

    public ItemFrozenEvent(Iterable<Long> ids) {
        super(Item.Status.FROZEN.value(), ids);
    }
}
