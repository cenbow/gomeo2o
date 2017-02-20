package io.terminus.ecp.marketing.service.assemble;

import io.terminus.common.model.Paging;
import io.terminus.ecp.marketing.dto.assemble.BundleItemDetails;
import io.terminus.ecp.marketing.dto.assemble.BundleItems;
import io.terminus.ecp.marketing.model.assemble.ItemBundle;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Created by yangzefeng on 14-4-21
 */
public interface ItemBundleService {

    /**
     * 依据编号获取组合套餐关系数据
     * @param id    组合套餐编号
     * @return  ItemBundle
     * 返回组合套餐关系
     */
    @Export(paramNames = {"id"})
    public Response<ItemBundle> findById(Long id);

    /**
     * 根据用户权限查询对应的组合套餐信息
     * @param user          用户
     * @param name          套餐名称
     * @param status        套餐状态
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回套餐信息
     */
    @Export(paramNames = {"user", "name", "status", "pageNo", "pageSize"})
    public Response<Paging<BundleItems>> queryByParams(BaseUser user , String name, Integer status, Integer pageNo, Integer pageSize);

    /**
     * 创建组合套餐
     * @param itemBundle    组合套餐数据
     * @return  Long
     * 返回组合套餐编号
     */
    public Response<Long> create(ItemBundle itemBundle);

    /**
     * 更新组合套餐信息
     * @param itemBundle    组合套餐数据
     * @param userId        操作用户编号
     * @return  Boolean
     * 返回组合套餐更改结果
     */
    public Response<Boolean> update(ItemBundle itemBundle, Long userId);

    /**
     * 更新组合套餐（上下架）状态
     * @param userId        用户编号
     * @param bundleId      绑定关系编号
     * @param status        上下架状态
     * @return  Boolean
     * 返回修改是否成功
     */
    public Response<Boolean> updateStatus(Long userId, Long bundleId, ItemBundle.Status status);

    /**
     * 查询当前用户的所有套餐信息
     * @param user  操作用户
     * @return  List
     * 返回所有套餐数据
     */
    @Export(paramNames = {"user"})
    public Response<List<BundleItems>> findBySellerId(BaseUser user);

    /**
     * 组合商品详情页
     * @param id 组合商品id
     * @return   组合商品信息，商品信息，商品detail，sku信息
     */
    @Export(paramNames = {"id"})
    public Response<BundleItemDetails> findBundleItemDetails(Long id);
}
