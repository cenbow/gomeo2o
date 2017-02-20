/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.center;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import io.terminus.ecp.config.event.Operator;
import io.terminus.ecp.config.model.Config;
import io.terminus.ecp.config.service.ConfigReadService;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-03-27 4:03 PM  <br>
 * Author: xiao
 */
@Slf4j
@Component
public class ConfigCenter implements InitializingBean {

    @Autowired
    private ConfigReadService configReadService;
    private Map<String, String> properties = Maps.newHashMap();
    private static final String DATE_FORMAT = "yyyy/mm/dd hh:mm:ss";


    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied
     * (and satisfied BeanFactoryAware and ApplicationContextAware).
     * <p>This method allows the bean instance to perform initialization only
     * possible when all bean properties have been set and to throw an
     * exception in the event of misconfiguration.
     *
     * @throws Exception in the event of misconfiguration (such
     *                   as failure to set an essential property) or if initialization fails.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Response<List<Config>> res = configReadService.listAll();
        if (!res.isSuccess()) {
            log.warn("fail to load properties from database, error:{}", res.getError());
            return;
        }

        List<Config> configs = res.getResult();
        log.info("Load Properties:");
        for (Config config : configs) {
            properties.put(config.getKey(), config.getValue());
            log.info("Loaded Key:{}, value:{}", config.getKey(), config.getValue());
        }
    }


    public String get(String key) {
        String property = properties.get(key);
        if (isEmpty(property)) {
            throw new IllegalStateException("property " + key + " is empty or null");
        }

        return property;
    }

    public <T extends ConfigAware> T build(T o) {
        o.build(properties);
        return o;
    }

    /**
     * 更新本地数据
     *
     * @param cfg 配置数据
     */
    public Map<String, String> commit(Operator op, Config cfg) {
        if (op == Operator.UPDATE) {
            String oldValue = properties.put(cfg.getKey(), cfg.getValue());
            log.info("配置发生更新, 配置项:{},更新为:{},旧值为:{}", cfg.getKey(), cfg.getValue(), oldValue);
        }

        if (op == Operator.DELETE) {
            String oldValue = properties.remove(cfg.getKey());
            log.info("删除了原来的配置, 配置项:{}, 旧值为:{}", cfg.getKey(), oldValue);
        }

        if (op == Operator.CREATE) {
            properties.put(cfg.getKey(), cfg.getValue());
            log.info("加入了新的配置, 配置项:{}, 值为:{}, 创建时间:{}", cfg.getKey(), cfg.getValue(), new DateTime(cfg.getCreatedAt()).toString(DATE_FORMAT));
        }

        //返回更新后的本地配置，方便测试用
        return ImmutableMap.copyOf(this.properties);
    }

    public Map<String, String> getAll(){
        return properties;
    }


}
