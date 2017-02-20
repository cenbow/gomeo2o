/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.spu;

/**
 * SPU 修改事件
 *
 * @author Effet
 */
public class SpuAltEvent extends AbstractSpuEvent implements SpuEvent {
    public SpuAltEvent(long bcId, long id) {
        super(bcId, id);
    }

    public SpuAltEvent(long bcId, Iterable<Long> ids) {
        super(bcId, ids);
    }
}
