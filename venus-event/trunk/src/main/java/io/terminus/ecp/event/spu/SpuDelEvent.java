/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.spu;

/**
 * SPU 删除事件
 *
 * @author Effet
 */
public class SpuDelEvent extends AbstractSpuEvent implements SpuEvent {
    public SpuDelEvent(long bcId, long id) {
        super(bcId, id);
    }

    public SpuDelEvent(long bcId, Iterable<Long> ids) {
        super(bcId, ids);
    }
}
