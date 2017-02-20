package io.terminus.ecp.config.service.zk;
/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import io.terminus.ecp.config.model.Config;
import io.terminus.ecp.config.service.ConfigReadServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.Map;

/**
 * Created by @author wangxiaolei on 15/4/9.
 * Mail:pivstone@gmail.com
 * <p/>
 * 基于ZK的Config Read Service Implement
 */

@Slf4j
@Service
@Configuration
@Profile({"zk", "dubbo", "cluster"})
public class ZkConfigReadServiceImpl extends ConfigReadServiceImpl {

    // 不保证数据一致,仅供测试用
    private Map<String, Config> properties = Maps.newHashMap();

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        String[] configNames = ConfigCenterUtil.getAllConfigName();
//        for (String configName : configNames) {
//            loadProperties(configName);
//        }
//    }

    /**
     * 加载配置信息
     *
     * @param configName 配置名
     * @throws Exception ZK的异常
     */
    public Map<String, Config> loadProperties(String configName) throws Exception {
//        String path = "/" + configName;
//        if (client.getCuratorClient().checkExists().watched().forPath(path) != null) {
//            byte[] data = client.getCuratorClient().getData().watched().forPath(path);
//            addData(data);
//        } else {
//            Response<Config> response = getByKey(configName);
//            if (response.isSuccess()) {
//                Config cfg=response.getResult();
//                properties.put(cfg.getKey(), cfg);
//                byte[] data = SerializationUtils.serialize(cfg);
//                log.debug("add Config to ZK,key:{},value:{}", configName, cfg);
//                client.getCuratorClient().create().withMode(CreateMode.PERSISTENT).forPath(path, data);
//            }
//        }
        return ImmutableMap.copyOf(properties);
    }

    /**
     * 更新本地数据
     *
     * @param data 序列化后的配置数据
     */
    public Map<String, Config> addData(byte[] data) {
        Object obj = SerializationUtils.deserialize(data);
        if (obj instanceof Config) {
            Config cfg = (Config) obj;
            properties.put(cfg.getKey(), cfg);
            log.debug("读取Zk上的配置,配置项:{},value:{}", cfg.getKey(), cfg.getValue());
        }
        //返回更新后的本地配置，方便测试用
        return ImmutableMap.copyOf(properties);
    }
}
