/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */
package io.terminus.ecp.config.util;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.reflect.ClassPath;
import io.terminus.ecp.config.event.ConfigEvent;
import io.terminus.ecp.config.event.Operator;
import io.terminus.ecp.config.model.Config;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Created by @author wangxiaolei on 15/4/9.<br>
 * Mail:pivstone@gmail.com
 */
@Slf4j
public class ConfigCenterUtil {

    //配置信息类所在的包名
    public static final String PACKAGE_NAME = "io.terminus.ecp.config.constants";

    //Key为配置项，例如email.port ,value 为 io.terminus.ecp.config.constants.mail.CommonMailSettings
    public static final Map<String, String> configNameMap = Maps.newHashMap();


    /**
     * 获取所有的配置项的名字
     *
     * @return 配置项名字数组
     */
    public static String[] getAllConfigName() {
        List<String> res = Lists.newArrayList();
        ClassPath path;
        try {
            path = ClassPath.from(ConfigCenterUtil.class.getClassLoader());
        } catch (IOException e) {
            log.error("fail to fetch Config Class Meta,{}", Throwables.getStackTraceAsString(e));
            //配置加载失败是十分严重问题，需要停止相关启动操作。
            throw new IllegalStateException();
        }
        for (ClassPath.ClassInfo info : path.getTopLevelClassesRecursive(ConfigCenterUtil.PACKAGE_NAME)) {
            Field[] fields = info.load().getDeclaredFields();
            for (Field f : fields) {
                if (f.getType() == String.class) {
                    try {
                        String key = (String) f.get(null);
                        configNameMap.put(key, info.getName());
                        res.add(key);
                    } catch (IllegalAccessException e) {
                        log.error("fail to get Field Value from Config Constant Class,{}", Throwables.getStackTraceAsString(e));
                    }
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }

    /**
     * 获取配置对应的类名
     *
     * @param configName 配置名
     * @return 配置所在的静态类类名
     */
    public static Optional<String> getClassName(String configName) {
        //元数据为空的时候需要初始化
        if (configNameMap.isEmpty()) {
            //防止多个线程一起初始化
            //仅允许一个线程去初始化，需要获取configNameMap的则进入wait
            synchronized (configNameMap) {
                //防止初始化阶段，等待的线程在完成后再次进行初始化操作
                if (configNameMap.isEmpty())
                    getAllConfigName();
            }
        }
        if (configNameMap.containsKey(configName)) {
            return Optional.of(configNameMap.get(configName));
        } else {
            return Optional.absent();
        }
    }

    /**
     * 封装配置更新事件对象（装填变更的类）
     * @param config 配置信息
     * @return 配置更新事件对象
     */
    public static ConfigEvent wrapperEvent(Config config) {
        ConfigEvent event = new ConfigEvent();
        Optional<String> className = getClassName(config.getKey());
        event.setClassName(className);
        event.setData(Optional.of(config));
        return event;
    }

    /**
     * 封装配置更新事件对象（装填变更的类）
     * @param config 配置信息
     * @return 配置更新事件对象
     */
    public static ConfigEvent wrapperEvent(Operator op, Config config) {
        ConfigEvent event = new ConfigEvent();
        Optional<String> className = getClassName(config.getKey());
        event.setOp(Optional.of(op.value));
        event.setClassName(className);
        event.setData(Optional.of(config));
        return event;
    }




    /**
     * 获取配置的分组信息
     * @param key 配置名
     * @return 配置的分组信息
     */
    public static Optional<ConfigMeta> getConfigMeta(String key) {
        Optional<String> oClassName = getClassName(key);
        if (oClassName.isPresent()) {
            String className = oClassName.get();
            String temp = className.replace(PACKAGE_NAME+".", "");
            String[] simpleName = temp.split("\\.");
            if (simpleName.length > 1) {
                ConfigMeta meta = new ConfigMeta(simpleName[0], simpleName[1]);
                return Optional.of(meta);
            }

        }
        return Optional.absent();
    }
}
