package cn.com.gome.configuration.config;

import cn.com.gome.configuration.mq.MqSettings;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Author: luoys
 * Date: 2015-06-16 14:28
 */
@Data
public class OrderMqConfig extends MqConfig implements Serializable{

    private static final long serialVersionUID = 3356473862498233475L;

    @Override
    public void build(Map<String, String> properties) {
        setMqAddress(properties.get(MqSettings.ORDER_MQ_ADDRESS) == null ? "10.125.31.24:9876;10.125.31.25:9876" : properties.get(MqSettings.ORDER_MQ_ADDRESS));

        setInstanceName(properties.get(MqSettings.ORDER_INSTANCE_NAME) == null ? "createOrderOneHundred" : properties.get(MqSettings.ORDER_INSTANCE_NAME));

        setGroupName(properties.get(MqSettings.ORDER_GROUP_NAME) == null ? "CreateOrderToOneHundredGroupName" : properties.get(MqSettings.ORDER_GROUP_NAME));

        setTopic(properties.get(MqSettings.ORDER_GROUP_TOPIC) == null ? "createOrderOneHundred" : properties.get(MqSettings.ORDER_GROUP_TOPIC));
    }
}
