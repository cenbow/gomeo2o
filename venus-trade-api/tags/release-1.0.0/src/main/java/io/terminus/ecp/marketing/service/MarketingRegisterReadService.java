package io.terminus.ecp.marketing.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.marketing.model.MarketingRegisterCenter;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Desc:优惠注册中心
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-17.
 */
public interface MarketingRegisterReadService {
    /**
     * 获取某个人的插件数据信息
     * @param user      当前用户
     * @param callType  调用方式
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @return  Paging
     * 返回全部可用的插件信息
     */
    @Export(paramNames = {"user", "callType", "pageNo", "pageSize"})
    public Response<Paging<MarketingRegisterCenter>> queryByParams(BaseUser user, Integer callType, Integer pageNo, Integer pageSize);

    /**
     * 获取当前用户全部可用的全部插件
     * @param user  用户信息
     * @return  List
     * 返回全部可用插件
     */
    @Export(paramNames = {"user"})
    public Response<List<MarketingRegisterCenter>> queryAllPlugin(BaseUser user);

    /**
     * 根据注册中心编号返回注册管理详细信息
     * @param pluginId    插件编号
     * @return  MarketingRegisterCenter
     * 返回插件信息
     */
    @Export(paramNames = {"toolId"})
    public Response<MarketingRegisterCenter> queryById(Long pluginId);
}
