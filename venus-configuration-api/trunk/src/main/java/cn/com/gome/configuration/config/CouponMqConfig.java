package cn.com.gome.configuration.config;

import cn.com.gome.configuration.mq.MqSettings;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Desc:
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-06-24.
 */
@Data
public class CouponMqConfig extends MqConfig{

    private static final long serialVersionUID = -7279561394648908366L;

    @Override
    public void build(Map<String, String> properties) {
        setMqAddress(properties.get(MqSettings.COUPON_MQ_ADDRESS) == null ? "10.125.31.24:9876;10.125.31.25:9876" : properties.get(MqSettings.COUPON_MQ_ADDRESS));

        setInstanceName(properties.get(MqSettings.COUPON_INSTANCE_NAME) == null ? "createOrderOneHundred" : properties.get(MqSettings.COUPON_INSTANCE_NAME));

        setGroupName(properties.get(MqSettings.COUPON_GROUP_NAME) == null ? "CouponsGroupName" : properties.get(MqSettings.COUPON_GROUP_NAME));

        setTopic(properties.get(MqSettings.COUPON_GROUP_TOPIC) == null ? "coupons-topic" : properties.get(MqSettings.COUPON_GROUP_TOPIC));
    }
}
