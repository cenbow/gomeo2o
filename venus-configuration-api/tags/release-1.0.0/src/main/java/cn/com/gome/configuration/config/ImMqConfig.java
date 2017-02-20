package cn.com.gome.configuration.config;

import cn.com.gome.configuration.mq.MqSettings;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Author: luoys
 * Date: 2015-10-10 17:37
 */
public class ImMqConfig extends MqConfig implements Serializable {


    private static final long serialVersionUID = 1703159062107493099L;

    @Override
    public void build(Map<String, String> properties) {
        setMqAddress(properties.get(MqSettings.IM_MQ_ADDRESS) == null ? "10.125.31.24:9876;10.125.31.25:9876" : properties.get(MqSettings.IM_MQ_ADDRESS));

        setInstanceName(properties.get(MqSettings.IM_INSTANCE_NAME) == null ? "msg-instance" : properties.get(MqSettings.IM_INSTANCE_NAME));

        setGroupName(properties.get(MqSettings.IM_GROUP_NAME) == null ? "msg-group" : properties.get(MqSettings.IM_GROUP_NAME));

        setTopic(properties.get(MqSettings.IM_GROUP_TOPIC) == null ? "msg-topic" : properties.get(MqSettings.IM_GROUP_TOPIC));
    }
}