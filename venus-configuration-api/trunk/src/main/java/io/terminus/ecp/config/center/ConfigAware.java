/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.center;

import java.util.Map;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-03-27 5:58 PM  <br>
 * Author: xiao
 */
public interface ConfigAware {

    /**
     * 将参数注入到需要的对象中
     * @param properties properties map store
     */
    public void build(Map<String, String> properties);

}
