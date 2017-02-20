/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.shop;

import io.terminus.ecp.event.common.AbstractIdsEvent;

/**
 * @author Effet
 */
public class ShopDelEvent extends AbstractIdsEvent implements ShopEvent {
    public ShopDelEvent(long id) {
        super(id);
    }

    public ShopDelEvent(Iterable<Long> ids) {
        super(ids);
    }
}
