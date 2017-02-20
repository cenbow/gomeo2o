/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.trade.util;

import io.terminus.common.utils.JsonMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by yangzefeng on 15/3/25
 */
public class Jsons {

    private final static JsonMapper JSON_MAPPER = JsonMapper.nonDefaultMapper();

    public static <T, O> Map<T, O> transJsonToMap(String json, Class<T> t, Class<O> o) {
        return JSON_MAPPER.fromJson(json, JSON_MAPPER.createCollectionType(Map.class, t.getClass(), o.getClass()));
    }

    public static <T> List<T> transJsonToList(String json, Class<T> t) {
        return JSON_MAPPER.fromJson(json, JSON_MAPPER.createCollectionType(List.class, t.getClass()));
    }
}
