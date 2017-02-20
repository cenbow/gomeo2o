/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.util;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.Map;

/**
 * 日期区间，单位为天
 *
 * <p>默认格式 yyyy-MM-dd, todo 可以传入自定义格式
 *
 * @author Effet
 * @since 1.0.0
 */
public final class DayRange {

    private static final DateTimeFormatter DTF = DateTimeFormat.forPattern("yyyy-MM-dd");

    /**
     * 时间左区间
     */
    private DateTime startAt;

    /**
     * 时间右区间(开区间)
     */
    private DateTime endAt;

    public DayRange(@Nullable String startAtText, @Nullable String endAtText) {
        if (!Strings.isNullOrEmpty(startAtText)) {
            startAt = DTF.parseDateTime(startAtText).withTimeAtStartOfDay();
        }
        if (!Strings.isNullOrEmpty(endAtText)) {
            endAt = DTF.parseDateTime(endAtText).withTimeAtStartOfDay().plusDays(1);

            if (startAt != null && !startAt.isBefore(endAt)) {
                // 时间错乱时，修正 endAt
                endAt = startAt.plusDays(1);
            }
        }
    }

    public static DayRange from(@Nullable String startAtText, @Nullable String endAtText) {
        return new DayRange(startAtText, endAtText);
    }

    public Map<String, Object> toMap(@Nullable String startAtKey, @Nullable String endAtKey) {
        Map<String, Object> map = Maps.newHashMap();
        if (!Strings.isNullOrEmpty(startAtKey) && startAt != null) {
            map.put(startAtKey, startAt.toDate());
        }
        if (!Strings.isNullOrEmpty(endAtKey) && endAt != null) {
            map.put(endAtKey, endAt.toDate());
        }
        return map;
    }

    public Date start() {
        return startAt == null ? null : startAt.toDate();
    }

    public Date end() {
        return endAt == null ? null : endAt.toDate();
    }
}
