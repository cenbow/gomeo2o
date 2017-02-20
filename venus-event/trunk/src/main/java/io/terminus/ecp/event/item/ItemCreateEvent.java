/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

/**
 * 创建商品事件
 *
 * @author Effet
 */
public class ItemCreateEvent extends AbstractItemEvent implements ItemEvent {
    public ItemCreateEvent(long id) {
        super(id);
    }

    public ItemCreateEvent(Iterable<Long> ids) {
        super(ids);
    }
}
