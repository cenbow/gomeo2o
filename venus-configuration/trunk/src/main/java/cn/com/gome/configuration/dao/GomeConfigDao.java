/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author mojianli
 * @date 2015年12月4日 下午5:25:40
 */
package cn.com.gome.configuration.dao;

import java.util.Map;

import io.terminus.common.model.Paging;
import io.terminus.ecp.config.model.Config;

/**
 * @Description TODO 
 * @author mojianli
 * @date 2015年12月4日 下午5:25:40
 */
public interface GomeConfigDao {

    public Paging<Config> pagingConfigs(Map<String,Object> criteria);
}
