/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.spu;

/**
 * SPU 创建事件
 *
 * @author Effet
 */
public class SpuInsEvent extends AbstractSpuEvent implements SpuEvent {
    public SpuInsEvent(long bcId, long id) {
        super(bcId, id);
    }

    public SpuInsEvent(long bcId, Iterable<Long> ids) {
        super(bcId, ids);
    }
}
