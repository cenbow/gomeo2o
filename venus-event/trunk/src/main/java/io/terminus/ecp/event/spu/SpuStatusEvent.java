/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.spu;

/**
 * @author Effet
 */
public abstract class SpuStatusEvent extends AbstractSpuEvent implements SpuEvent {
    private final int status;

    public final int status() {
        return status;
    }

    public SpuStatusEvent(int status, long bcId, long id) {
        super(bcId, id);
        this.status = status;
    }

    public SpuStatusEvent(int status, long bcId, Iterable<Long> ids) {
        super(bcId, ids);
        this.status = status;
    }
}
