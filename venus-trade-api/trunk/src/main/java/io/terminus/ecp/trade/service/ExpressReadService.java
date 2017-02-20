/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.trade.model.ExpressInfo;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 快递公司查询接口
 *
 * @author Effet
 */
public interface ExpressReadService {

    /**
     * 列出快递公司列表(启用的)
     */
    Response<List<ExpressInfo>> getAllEnabled();

    /**
     * 分页接口
     *
     * @param name   物流公司名
     * @param status 状态
     * @param pageNo 页码
     * @param size   大小
     * @return 分页内容
     */
    @Export(paramNames = {"name", "status", "pageNo", "size"})
    Response<Paging<ExpressInfo>> paging(
            @Nullable String name,
            @Nullable Integer status,
            @Nullable Integer pageNo,
            @Nullable Integer size);
}
