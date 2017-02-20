package io.terminus.ecp.config.event;
/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

import com.google.common.base.Throwables;
import io.terminus.ecp.config.constants.config.ConfigSettings;
import io.terminus.zookeeper.ZKClientFactory;
import io.terminus.zookeeper.pubsub.SubscribeCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.PostConstruct;

/**
 * Created by @author wangxiaolei on 15/4/9.
 * Mail:pivstone@gmail.com
 * ZK的Node update 事件监听器
 *TODO: 过滤不关心的事件
 */
@Slf4j
@Component
public class ConfigUpdateListener {

    @Autowired
    private ConfigEventDispatcher eventDispatcher;
    @Autowired(required = false)
    private ZKClientFactory zkClientFactory;

    @PostConstruct
    public void listen() throws Exception {
        if (zkClientFactory == null) return;

        Subscriber subscriber = new Subscriber(zkClientFactory, ConfigSettings.ZK_BASE_PATH,
                ConfigSettings.ZK_CONFIG_TOPIC);
        try {
            subscriber.subscribe(new SubscribeCallback() {
                @Override
                public void fire(byte[] data) {
                    Object obj = SerializationUtils.deserialize(data);

                    if (obj instanceof ConfigEvent) {
                        log.info("********* catch curator event {} *****************", obj);
                        ConfigEvent configEvent = (ConfigEvent) obj;
                        eventDispatcher.publish(configEvent);
                    }
                }
            });
        } catch (Exception e) {
            log.error("failed to subscribe cache event, cause: {}",
                    Throwables.getStackTraceAsString(e));
        }
    }
}
