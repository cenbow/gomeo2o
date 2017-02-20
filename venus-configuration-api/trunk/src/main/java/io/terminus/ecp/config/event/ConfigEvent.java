package io.terminus.ecp.config.event;
/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

import com.google.common.base.Optional;
import io.terminus.ecp.config.model.Config;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by @author wangxiaolei on 15/4/9.
 * Mail:pivstone@gmail.com
 */

@Data
public class ConfigEvent implements Serializable {
    private static final long serialVersionUID = -8350032779757801271L;
    private Optional<Integer> op;
    private Optional<String> className;
    private Optional<Config> data;
}
