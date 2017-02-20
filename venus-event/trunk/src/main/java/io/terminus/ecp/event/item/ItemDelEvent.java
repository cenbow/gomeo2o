/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.item;

import java.util.List;

/**
 * 删除商品事件
 *
 * @author Effet
 */
public class ItemDelEvent extends AbstractItemEvent implements ItemEvent {
    public ItemDelEvent(long id) {
        super(id);
    }

    public ItemDelEvent(Iterable<Long> ids) {
        super(ids);
    }
}
