/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.shop;

import io.terminus.ecp.event.common.AbstractIdsEvent;

/**
 * @author Effet
 */
public class ShopStatusEvent extends AbstractIdsEvent implements ShopEvent {
    private final int status;

    public final int status() {
        return status;
    }

    public ShopStatusEvent(int status, long id) {
        super(id);
        this.status = status;
    }

    public ShopStatusEvent(int status, Iterable<Long> ids) {
        super(ids);
        this.status = status;
    }
}
