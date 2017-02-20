/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.service.statistics;

import io.terminus.ecp.trade.model.statistics.Statistics;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

/**
 * <pre>
 *   功能描述:商品、订单统计汇总服务
 * </pre>
 *
 * @author wanggen on 2015-02-10.
 */
public interface StatisticsService {


    /**
     * 新增商品、订单统计记录
     *
     * @param statistics 统计信息
     * @return 执行结果
     */
    Response<Boolean> create(Statistics statistics);


    /**
     * 按天插入数据
     *
     * @param statistics 统计数据
     * @return 是否新增成功
     */
    Response<Boolean> createByDaily(Statistics statistics);


    /**
     * 按天查询数据
     *
     * @param date 日期 如: 2015-02-03
     * @return 统计数据
     */
    @Export(paramNames = {"date"})
    Response<Statistics> findByDaily(String date);

}
