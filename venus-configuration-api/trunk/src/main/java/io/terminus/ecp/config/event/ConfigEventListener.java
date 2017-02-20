package io.terminus.ecp.config.event;
/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

import com.google.common.eventbus.Subscribe;
import io.terminus.ecp.common.event.EventListener;
import io.terminus.ecp.config.center.ConfigCenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by @author wangxiaolei on 15/4/9.
 * Mail:pivstone@gmail.com
 * <p/>
 * 监听所以ZK触发的节点数据更新事件，当且仅当ZK触发了配置更新事件采取更新本地数据库
 */
@Component
@Slf4j
public class ConfigEventListener implements EventListener {

    @Autowired
    private ConfigCenter configCenter;

    /**
     * 提交更新的配置数据到本地内存和本地持久层
     *
     * @param event 配置更新事件
     */
    @Subscribe
    @SuppressWarnings("unused")
    public void commit(ConfigEvent event) {
        if (event.getOp().isPresent() && event.getData().isPresent())
            configCenter.commit(Operator.from(event.getOp().get()), event.getData().get());
    }
}
