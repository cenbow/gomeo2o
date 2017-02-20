/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.common;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author Effet
 */
public abstract class AbstractIdsEvent implements IdsEvent {

    private final ImmutableList<Long> ids;

    @Override
    public final List<Long> ids() {
        return ids;
    }

    public AbstractIdsEvent(long id) {
        this.ids = ImmutableList.of(id);
    }

    public AbstractIdsEvent(Iterable<Long> ids) {
        this.ids = ImmutableList.copyOf(ids);
    }
}
