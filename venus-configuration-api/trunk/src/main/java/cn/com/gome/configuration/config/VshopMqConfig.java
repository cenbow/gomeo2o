package cn.com.gome.configuration.config;

import cn.com.gome.configuration.mq.MqSettings;
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
public class VshopMqConfig extends MqConfig{

    private static final long serialVersionUID = -4689909850046040744L;

    @Override
    public void build(Map<String, String> properties) {
        setMqAddress(properties.get(MqSettings.VSHOP_MQ_ADDRESS) == null ? "10.125.31.24:9876;10.125.31.25:9876" : properties.get(MqSettings.VSHOP_MQ_ADDRESS));

        setInstanceName(properties.get(MqSettings.VSHOP_INSTANCE_NAME) == null ? "vshop_product" : properties.get(MqSettings.VSHOP_INSTANCE_NAME));

        setGroupName(properties.get(MqSettings.VSHOP_GROUP_NAME) == null ? "vshopProductName" : properties.get(MqSettings.VSHOP_GROUP_NAME));

        setTopic(properties.get(MqSettings.VSHOP_GROUP_TOPIC) == null ? "vshop_product" : properties.get(MqSettings.VSHOP_GROUP_TOPIC));
    }
}
