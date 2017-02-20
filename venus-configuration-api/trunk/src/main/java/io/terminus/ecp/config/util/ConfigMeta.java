package io.terminus.ecp.config.util;
/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

/**
 * Created by @author wangxiaolei on 15/4/14.
 * Mail:pivstone@gmail.com
 * 配置项 元数据
 */

public final class ConfigMeta {
    private final String configGroup;
    private final String configType;

    public ConfigMeta(String configGroup, String configType) {
        this.configGroup = configGroup;
        this.configType = configType;
    }

    public String getConfigGroup() {
        return this.configGroup;
    }

    public String getConfigType() {
        return this.configType;
    }
}
