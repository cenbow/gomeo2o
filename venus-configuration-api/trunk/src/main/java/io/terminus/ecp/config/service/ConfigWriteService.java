/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.service;

import io.terminus.ecp.config.model.Config;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-03-27 12:00 PM  <br>
 * Author: xiao
 */
public interface ConfigWriteService {

    /**
     * 创建一条配置信息
     * @param config 配置信息
     * @return 操作是否成功
     */
    @Export(paramNames = {"config"})
    Response<Boolean> create(@NotNull Config config);


    /**
     * 创建一组配置信息
     * @param configs   配置信息
     * @return  操作是否成功
     */
    Response<Boolean> bulkCreate(@NotEmpty List<Config> configs);


    /**
     * 更新一条配置信息
     * @param config    配置信息
     * @return  操作是否成功
     */
    @Export(paramNames = {"config"})
    Response<Boolean> update(@NotNull Config config);


    /**
     * 更新多条配置信息
     * @param configs   配置列表
     * @return  操作是否成功
     */
    @Export(paramNames = {"configs"})
    Response<Boolean> bulkUpdate(@NotNull Config[] configs);


    /**
     * 删除一条配置信息
     * @param config  配置信息
     * @return 操作是否成功
     */
    @Export(paramNames = {"config"})
    Response<Boolean> delete(@NotNull Config config);



    /**
     * 从数据库中重新加载所有的配置数据
     * @return 操作结果
     */
    @Export
    Response<Boolean> reload();

}
