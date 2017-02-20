/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

import io.terminus.ecp.event.common.IdsEvent;

import java.util.List;

/**
 * 基础商品事件
 *
 * @author Effet
 */
public interface ItemEvent extends IdsEvent {

    /**
     * Item IDs
     */
    @Override
    List<Long> ids();
}
