/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * 事件分发器
 * <T>
 *  实现EventListener的类
 * </T>
 * Author: haolin
 * On: 8/26/14
 */
@Slf4j
public abstract class EventDispatcher <T extends EventListener> {

    @Autowired
    private ApplicationContext applicationContext;

    protected final EventBus eventBus;

    protected final Class eventListenerClass = ((Class<T>) ((ParameterizedType) super.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

    protected EventDispatcher() {
        this(Runtime.getRuntime().availableProcessors() + 1);
    }

    protected EventDispatcher(Integer threadCount) {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadCount));
    }

    @PostConstruct
    public void registerListeners(){
        Map<String, T> eventListenerBeans = applicationContext.getBeansOfType(eventListenerClass);
        for (T listener : eventListenerBeans.values()){
            eventBus.register(listener);
        }
    }

    /**
     * 订阅
     */
    public void subcribe(Object listener) {
        log.info("register a listener({})", listener);
        eventBus.register(listener);
    }

    /**
     * 取消订阅
     */
    public void unsubcribe(Object listener) {
        log.info("unregister a listener({})", listener);
        eventBus.unregister(listener);
    }

    /**
     * 发布事件
     */
    public void publish(Object event) {
        log.info("publish an event({})", event);
        eventBus.post(event);
    }
}
