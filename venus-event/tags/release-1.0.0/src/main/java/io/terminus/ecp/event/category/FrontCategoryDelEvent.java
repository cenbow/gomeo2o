/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.category;

import io.terminus.ecp.event.common.AbstractIdsEvent;

/**
 * @author Effet
 */
public class FrontCategoryDelEvent extends AbstractIdsEvent implements FrontCategoryEvent {
    public FrontCategoryDelEvent(long id) {
        super(id);
    }

    public FrontCategoryDelEvent(Iterable<Long> ids) {
        super(ids);
    }
}
