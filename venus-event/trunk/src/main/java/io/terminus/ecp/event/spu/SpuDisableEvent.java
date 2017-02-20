/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.spu;

import io.terminus.ecp.category.model.Spu;

/**
 * @author Effet
 */
public class SpuDisableEvent extends SpuStatusEvent {
    public SpuDisableEvent(long bcId, long id) {
        super(Spu.Status.DISABLED.value(), bcId, id);
    }

    public SpuDisableEvent(long bcId, Iterable<Long> ids) {
        super(Spu.Status.DISABLED.value(), bcId, ids);
    }
}
