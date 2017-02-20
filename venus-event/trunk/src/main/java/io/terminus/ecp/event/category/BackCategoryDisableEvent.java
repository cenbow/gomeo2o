/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.category;

import io.terminus.ecp.category.model.BackCategory;

/**
 * @author Effet
 */
public class BackCategoryDisableEvent extends BackCategoryStatusEvent {
    public BackCategoryDisableEvent(long id) {
        super(BackCategory.Status.DISABLED.value(), id);
    }

    public BackCategoryDisableEvent(Iterable<Long> ids) {
        super(BackCategory.Status.DISABLED.value(), ids);
    }
}
