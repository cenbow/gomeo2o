package io.terminus.ecp.marketing.service;

import io.terminus.ecp.marketing.dto.MarketingToolDto;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

/**
 * Desc:优惠工具的写服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-10.
 */
public interface MarketingToolWriteService {
    /**
     * 创建工具模版对象
     * @param user              创建人员
     * @param marketingToolDto  工具信息
     * @return  Boolean
     * 返回工具创建是否成功
     */
    public Response<Boolean> createTool(BaseUser user , MarketingToolDto marketingToolDto);

    /**
     * 数据单独定义创建写入
     * @param user          创建用户
     * @param registerId    服务注册中心编号(null:默认系统提供服务)
     * @param wayType       方式类型
     * @param dataJson      方式数据的json字符串
     * @return  Boolean
     * 返回定义是否成功
     */
    public Response<Boolean> createWayData(BaseUser user , Long registerId, Integer wayType, String dataJson);

    /**
     * 删除活动的规则数据信息（异步删除）
     * @param user          操作用户
     * @param activityId    活动编号
     * @param toolDataId    活动数据id
     * @return  Boolean
     * 返回删除活动是否成功
     */
    public Response<Boolean> deleteToolData(BaseUser user , Long activityId, Long toolDataId);
}
