/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.util;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Effet
 */
public final class Iters {

    public static <I> Iterable<I> nullToEmpty(@Nullable Iterable<I> iter) {
        if (iter == null) {
            return new Iterable<I>() {
                @Override
                public Iterator<I> iterator() {
                    return Collections.emptyIterator();
                }
            };
        }
        return iter;
    }

    public static <I> List<I> nullToEmpty(@Nullable List<I> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public static <K, V> Map<K, V> nullToEmpty(@Nullable Map<K, V> map) {
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }

    public static <I> Iterable<I> emptyToNull(@Nullable Iterable<I> iter) {
        return iter != null && iter.iterator().hasNext() ? iter : null;
    }

    public static <T> List<T> emptyToNull(@Nullable List<T> list) {
        return list != null && !list.isEmpty() ? list : null;
    }

    public static <T> T[] emptyToNull(@Nullable T[] array) {
        return array != null && array.length > 0 ? array : null;
    }

    public static long[] emptyToNull(@Nullable long[] array) {
        return array != null && array.length > 0 ? array : null;
    }
}
