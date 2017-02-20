/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.shop;

import io.terminus.ecp.event.common.IdsEvent;

import java.util.List;

/**
 * @author Effet
 */
public interface ShopEvent extends IdsEvent {

    /**
     * 店铺 id 列表
     */
    @Override
    List<Long> ids();
}
