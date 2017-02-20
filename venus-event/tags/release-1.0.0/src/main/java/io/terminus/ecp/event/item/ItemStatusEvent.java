/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

/**
 * @author Effet
 */
public abstract class ItemStatusEvent extends AbstractItemEvent implements ItemEvent {
    private final int status;

    public final int status() {
        return status;
    }

    public ItemStatusEvent(int status, long id) {
        super(id);
        this.status = status;
    }

    public ItemStatusEvent(int status, Iterable<Long> ids) {
        super(ids);
        this.status = status;
    }
}
