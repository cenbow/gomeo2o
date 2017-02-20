package cn.com.gome.configuration.config;

import io.terminus.ecp.config.center.ConfigAware;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Desc: MQ服务信息设置
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-27.
 */
@Data
public abstract class MqConfig extends BaseMqConfig implements ConfigAware {


    private static final long serialVersionUID = -3735323257003827920L;

}
