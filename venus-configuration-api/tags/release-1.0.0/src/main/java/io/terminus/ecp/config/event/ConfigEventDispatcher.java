package io.terminus.ecp.config.event;

/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

import io.terminus.ecp.common.event.EventDispatcher;
import org.springframework.stereotype.Component;

/**
 * Created by @author wangxiaolei on 15/4/8.
 * Mail:pivstone@gmail.com
 */
@Component
public class ConfigEventDispatcher extends EventDispatcher<ConfigEventListener> {

    public ConfigEventDispatcher() {
        super();
    }

    public ConfigEventDispatcher(Integer threadCount) {
        super(threadCount);
    }
}
