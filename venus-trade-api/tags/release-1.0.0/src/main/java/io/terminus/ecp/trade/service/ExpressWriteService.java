/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.service;

import io.terminus.ecp.trade.model.ExpressInfo;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Effet
 */
public interface ExpressWriteService {

    /**
     * 创建快递公司信息
     * @param expressInfo 快递公司信息
     * @return 创建的id号
     */
    Response<Long> create(
            @NotNull(message = "express.info.invalid") ExpressInfo expressInfo);

    /**
     * 更新快递公司信息
     * @param expressInfo 快递公司信息
     * @return 是否更新成功
     */
    Response<Boolean> update(
            @NotNull(message = "express.info.invalid") ExpressInfo expressInfo);

    /**
     * 删除快递公司信息(逻辑删除)
     * @param id 快递公司信息id
     * @return 删除成功
     */
    Response<Boolean> delete(
            @Min(value = 1L, message = "express.info.id.invalid")
            @NotNull(message = "express.info.id.invalid") Long id);

    /**
     * 启用
     * @param id 快递公司信息id
     * @return 启用成功
     */
    Response<Boolean> enable(
            @Min(value = 1L, message = "express.info.id.invalid")
            @NotNull(message = "express.info.id.invalid") Long id);

    /**
     * 禁用
     * @param id 快递公司信息id
     * @return 禁用成功
     */
    Response<Boolean> disable(
            @Min(value = 1L, message = "express.info.id.invalid")
            @NotNull(message = "express.info.id.invalid") Long id);
}
