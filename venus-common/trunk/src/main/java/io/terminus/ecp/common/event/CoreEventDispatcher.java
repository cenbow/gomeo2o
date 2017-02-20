/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * 非泛型实现
 *
 * Mail: xiao@terminus.io <br>
 * Date: 2015-05-07 1:35 PM  <br>
 * Author: xiao
 */
@Slf4j @Component
public class CoreEventDispatcher {

    protected final EventBus eventBus;

    @Autowired
    private ApplicationContext applicationContext;


    public CoreEventDispatcher() {
        this(Runtime.getRuntime().availableProcessors() + 1);
    }

    public CoreEventDispatcher(Integer threadCount) {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadCount));
    }

    @PostConstruct
    public void registerListeners() {
        Map<String, EventListener> listeners = applicationContext.getBeansOfType(EventListener.class);
        for(EventListener eventListener : listeners.values()) {
            eventBus.register(eventListener);
        }
    }

    /**
     * 发布事件
     */
    public void publish(Object event) {
        log.info("publish an event({})", event);
        eventBus.post(event);
    }


}
