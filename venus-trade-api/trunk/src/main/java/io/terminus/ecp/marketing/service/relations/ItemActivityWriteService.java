package io.terminus.ecp.marketing.service.relations;

import io.terminus.ecp.marketing.model.relations.ItemActivity;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Desc:商品与活动的关系写入服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-29.
 */
public interface ItemActivityWriteService {
    /**
     * 创建商品活动关系
     * @param itemActivityList  商品活动关系信息
     * @return  Boolean
     * 返回创建是否成功
     */
    public Response<Boolean> createItemActivities(List<ItemActivity> itemActivityList);

    /**
     * 批量更改某个活动的商品状态
     * @param activityId    活动编号
     * @param status        活动状态
     * @return  Boolean
     * 返回更改是否成功
     */
    public Response<Boolean> updateItemActivityStatus(Long activityId, Integer status);
}
