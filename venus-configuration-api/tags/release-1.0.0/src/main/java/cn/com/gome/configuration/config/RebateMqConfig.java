package cn.com.gome.configuration.config;

import cn.com.gome.configuration.mq.MqSettings;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Author: luoys
 * Date: 2015-06-26 17:08
 */
public class RebateMqConfig extends MqConfig{

    private static final long serialVersionUID = 2865695545302690803L;

    @Override
    public void build(Map<String, String> properties) {
        setMqAddress(properties.get(MqSettings.REBATE_MQ_ADDRESS) == null ? "10.125.31.24:9876;10.125.31.25:9876" : properties.get(MqSettings.REBATE_MQ_ADDRESS));

        setInstanceName(properties.get(MqSettings.REBATE_INSTANCE_NAME) == null ? "rebateProduct" : properties.get(MqSettings.REBATE_INSTANCE_NAME));

        setGroupName(properties.get(MqSettings.REBATE_GROUP_NAME) == null ? "rebateProductGroup" : properties.get(MqSettings.REBATE_GROUP_NAME));

        setTopic(properties.get(MqSettings.REBATE_GROUP_TOPIC) == null ? "rebate_product_changed" : properties.get(MqSettings.REBATE_GROUP_TOPIC));
    }
}