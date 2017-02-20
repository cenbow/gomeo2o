/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

import io.terminus.ecp.item.model.Item;

/**
 * @author Effet
 */
public class ItemUpEvent extends ItemStatusEvent {
    public ItemUpEvent(long id) {
        super(Item.Status.ON_SHELF.value(), id);
    }

    public ItemUpEvent(Iterable<Long> ids) {
        super(Item.Status.ON_SHELF.value(), ids);
    }
}
