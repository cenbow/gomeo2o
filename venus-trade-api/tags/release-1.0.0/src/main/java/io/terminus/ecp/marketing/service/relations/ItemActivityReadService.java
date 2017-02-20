package io.terminus.ecp.marketing.service.relations;

import io.terminus.common.model.Paging;
import io.terminus.ecp.marketing.model.relations.ItemActivity;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Desc:商品与活动的关系读取服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-29.
 */
public interface ItemActivityReadService {
    /**
     * 获取商品绑定的活动
     * @param status        活动状态（-1:活动停止，0:待发布，1:已发布，2:活动开始，3:活动结束）
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回商品绑定关系
     */
    @Export(paramNames = {"status", "pageNo", "pageSize"})
    public Response<Paging<ItemActivity>> queryByParams(Integer status, Integer pageNo, Integer pageSize);

    /**
     * 查询店铺下(单一活动)优惠额度最大的商品
     * @param shopId    店铺编号
     * @return  ItemActivity
     * 返回商品活动信息
     */
    @Export(paramNames = {"shopId"})
    public Response<ItemActivity> findMostDiscount(Long shopId);

    /**
     * 根据商品编号列表获取商品的直降信息
     * @param itemIds   商品列表
     * @return  List
     * 返回商品的直降信息
     */
    public Response<List<ItemActivity>> findDiscountByItemIds(List<Long> itemIds);
}
