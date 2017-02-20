/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.shop;

import io.terminus.ecp.event.common.AbstractIdsEvent;

/**
 * @author Effet
 */
public class ShopInsEvent extends AbstractIdsEvent implements ShopEvent {
    public ShopInsEvent(long id) {
        super(id);
    }

    public ShopInsEvent(Iterable<Long> ids) {
        super(ids);
    }
}
