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
public class SearchMqConfig extends MqConfig{

    private static final long serialVersionUID = -512850237505694001L;

    @Override
    public void build(Map<String, String> properties) {
        setMqAddress(properties.get(MqSettings.SEARCH_MQ_ADDRESS) == null ? "10.125.31.24:9876" : properties.get(MqSettings.SEARCH_MQ_ADDRESS));

        setInstanceName(properties.get(MqSettings.SEARCH_INSTANCE_NAME) == null ? "Producter" : properties.get(MqSettings.SEARCH_INSTANCE_NAME));

        setGroupName(properties.get(MqSettings.SEARCH_GROUP_NAME) == null ? "meixinProductName" : properties.get(MqSettings.SEARCH_GROUP_NAME));

        setTopic(properties.get(MqSettings.SEARCH_GROUP_TOPIC) == null ? "meixin_product" : properties.get(MqSettings.SEARCH_GROUP_TOPIC));
    }
}
