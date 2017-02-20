/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.service;

import io.terminus.common.model.Paging;
import io.terminus.ecp.config.model.Config;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.Response;

import java.util.List;
import java.util.Map;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-03-27 12:00 PM  <br>
 * Author: xiao
 */
public interface ConfigReadService {


    /**
     * 加载所有配置想
     * @return  配置项
     */
    @Export
    Response<List<Config>> listAll();

    @Export(paramNames = {"pageNo","pageSize"})
    Response<Paging<Config>> pagingConfigs(Integer pageNo, Integer pageSize);

    /**
     * 根据配置名获取配置项
     * @param key 配置名
     * @return 配置项
     */
    Response<Config> getByKey(String key);

    /**
     * 更新配置名查询配置项(Like)
     * @param key 配置名
     * @return 配置项
     */
    Response<List<Config>> searchByKey(String key);

    /**
     * 获取分组后的所有配置向
     * @return  内容例子： ['pay' -> ['Aipay' -> 'Config'] ]
     *                  第一个String 为配置分类:pay、mail
     *                  第二个String 为配置具体类型：     Alipay。
     */
    //too too too bad code
    @Export
    Response<Map<String,Map<String,List<Config>>>> getAll();

}
