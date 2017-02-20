/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.category;

import io.terminus.ecp.event.common.AbstractIdsEvent;

/**
 * @author Effet
 */
public class BackCategoryInsEvent extends AbstractIdsEvent implements BackCategoryEvent {
    public BackCategoryInsEvent(long id) {
        super(id);
    }

    public BackCategoryInsEvent(Iterable<Long> ids) {
        super(ids);
    }
}
