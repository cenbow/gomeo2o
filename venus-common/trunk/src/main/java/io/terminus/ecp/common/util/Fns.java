/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.util;

import com.google.common.base.Function;
import io.terminus.common.model.Indexable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Effet
 */
public final class Fns {

    public static <I extends Indexable> Function<I, Long> toId() {
        return new Function<I, Long>() {
            @Override
            public Long apply(I i) {
                return checkNotNull(checkNotNull(i, "indexable null").getId(), "no index id");
            }
        };
    }
}
