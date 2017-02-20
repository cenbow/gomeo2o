package io.terminus.ecp.marketing.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.marketing.dto.MarketingToolDto;
import io.terminus.ecp.marketing.model.MarketingTool;
import io.terminus.ecp.plugin.model.ToolRulesData;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Desc:优惠工具的读取服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-10.
 */
public interface MarketingToolReadService {
    /**
     * 获取用户全部可用的工具数据
     * @param user      当前用户
     * @param scope     工具作用范围
     * @param name      工具名称
     * @param status    工具状态
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回全部可用的工具模版
     */
    @Export(paramNames = {"user", "scope", "name", "status", "pageNo", "pageSize"})
    public Response<Paging<MarketingTool>> queryByParams(BaseUser user , Integer scope, String name,
                                                        Integer status, Integer pageNo, Integer pageSize);

    /**
     * 获取当前用户全部可用的优惠工具
     * @param user  用户信息
     * @return  List
     * 返回全部可用优惠工具
     */
    @Export(paramNames = {"user"})
    public Response<List<MarketingTool>> queryAllTools(BaseUser user);

    /**
     * 根据工具编号返回工具模版详细信息
     * @param toolId    工具编号
     * @return  ToolRulesDto
     * 返回工具模版
     */
    @Export(paramNames = {"toolId"})
    public Response<MarketingToolDto> queryById(Long toolId);

    /**
     * 依据活动编号&工具编号获取数据详情
     * @param activityId    活动编号
     * @param toolId        工具编号
     * @return  ToolRulesData
     * 返回全部工具数据
     */
    public Response<ToolRulesData> queryByRuleData(Long activityId, Long toolId);
}
