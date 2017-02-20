/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.spu;

import io.terminus.ecp.category.model.Spu;

/**
 * @author Effet
 */
public class SpuEnableEvent extends SpuStatusEvent {
    public SpuEnableEvent(long bcId, long id) {
        super(Spu.Status.ENABLED.value(), bcId, id);
    }

    public SpuEnableEvent(long bcId, Iterable<Long> ids) {
        super(Spu.Status.ENABLED.value(), bcId, ids);
    }
}
