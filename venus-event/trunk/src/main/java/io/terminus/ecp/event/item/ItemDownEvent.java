/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

import io.terminus.ecp.item.model.Item;

/**
 * @author Effet
 */
public class ItemDownEvent extends ItemStatusEvent {
    public ItemDownEvent(long id) {
        super(Item.Status.OFF_SHELF.value(), id);
    }

    public ItemDownEvent(Iterable<Long> ids) {
        super(Item.Status.OFF_SHELF.value(), ids);
    }
}
