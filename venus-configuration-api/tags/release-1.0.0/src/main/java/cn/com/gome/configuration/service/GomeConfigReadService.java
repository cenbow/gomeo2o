/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author mojianli
 * @date 2015年12月2日 下午4:27:42
 */
package cn.com.gome.configuration.service;

import java.util.Map;

import io.terminus.common.model.Paging;
import io.terminus.ecp.config.model.Config;
import io.terminus.ecp.config.service.ConfigReadService;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

/**
 * @Description 配置中心读服务接口
 * @author mojianli
 * @date 2015年12月2日 下午4:27:42
 */
public interface GomeConfigReadService {

    /**
     * @Description 分页查询配置
     * @author mojianli
     * @date 2015年11月10日 上午11:53:10
     * @param pageNo 请求页数
     * @param pageSize 每页大小
     * @param criteria 查询条件
     */
    @Export(paramNames = {"pageNo","pageSize","criteria"})
    public Response<Paging<Config>> pagingConfigs(Integer pageNo, Integer pageSize,Map<String,Object> criteria);
}
