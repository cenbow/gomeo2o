/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.spu;

import io.terminus.ecp.event.common.AbstractIdsEvent;
import io.terminus.ecp.event.common.IdsEvent;

/**
 * @author Effet
 */
public abstract class AbstractSpuEvent extends AbstractIdsEvent implements IdsEvent, SpuEvent {
    private final long bcId;

    @Override
    public final long bcId() {
        return bcId;
    }

    public AbstractSpuEvent(long bcId, long id) {
        super(id);
        this.bcId = bcId;
    }

    public AbstractSpuEvent(long bcId, Iterable<Long> ids) {
        super(ids);
        this.bcId = bcId;
    }
}
