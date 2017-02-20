package io.terminus.ecp.marketing.service.coupon;

import io.terminus.pampas.common.Response;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 *   功能描述: 优惠券统计服务
 * </pre>
 *
 * @author wanggen on 2015-02-10.
 */
public interface CouponStatisticsService {


    /**
     * 统计各种优惠券个数(当前就是平台券和商品券分别是多少个)
     */
    Response<Map<String, Integer>> totalCount();


    /**
     * 每种优惠券发放个数及数额(总数)
     */
    Response<List<Map<String, Integer>>> totalCountByType();


    /**
     * 每日优惠券使用个数及数额
     *
     * @param date 日期如: 2015-01-01
     */
    Response<Map<String, Object>> dailyCount(String date);


    /**
     * 每日每种优惠券使用个数及数额
     *
     * @param date 日期如: 2015-01-02
     */
    Response<List<Map<String, Object>>> dailyCountByType(String date);

}
