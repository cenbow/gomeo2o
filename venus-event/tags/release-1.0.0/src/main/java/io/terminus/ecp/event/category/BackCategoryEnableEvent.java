/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.category;

import io.terminus.ecp.category.model.BackCategory;

/**
 * @author Effet
 */
public class BackCategoryEnableEvent extends BackCategoryStatusEvent {
    public BackCategoryEnableEvent(long id) {
        super(BackCategory.Status.ENABLED.value(), id);
    }

    public BackCategoryEnableEvent(Iterable<Long> ids) {
        super(BackCategory.Status.ENABLED.value(), ids);
    }
}
