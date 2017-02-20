/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

import io.terminus.ecp.event.common.AbstractIdsEvent;
import io.terminus.ecp.event.common.IdsEvent;

import java.util.List;

/**
 * @author Effet
 */
public abstract class AbstractItemEvent extends AbstractIdsEvent implements IdsEvent, ItemEvent {
    public AbstractItemEvent(long id) {
        super(id);
    }

    public AbstractItemEvent(Iterable<Long> ids) {
        super(ids);
    }
}
