/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

/**
 * 商品基础信息变更事件
 *
 * TODO(Effet): sku 变更是否算作基本信息变更 ?
 * TODO(Effet): 暂时将 sku 变更定义为商品基本信息变更
 *
 * 1. sku 变更算作基本信息变更:
 *              无法分辨出非 sku 变更导致的 item 基本信息更新
 * 2. 不算作:
 *              sku 变更时须同时发送两种事件
 *
 * @author Effet
 */
public class ItemInfoEvent extends AbstractItemEvent implements ItemEvent {
    public ItemInfoEvent(long id) {
        super(id);
    }

    public ItemInfoEvent(Iterable<Long> ids) {
        super(ids);
    }
}
