/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.spu;

import io.terminus.ecp.event.common.IdsEvent;

import java.util.List;

/**
 * @author Effet
 */
public interface SpuEvent extends IdsEvent {

    /**
     * SPU IDs
     */
    @Override
    List<Long> ids();

    /**
     * SPU 对应后台类目 id
     */
    long bcId();
}
