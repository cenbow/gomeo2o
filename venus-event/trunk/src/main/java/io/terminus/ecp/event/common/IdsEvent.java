/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.common;

import java.util.List;

/**
 * id 相关抽象事件
 */
public interface IdsEvent {

    /**
     * IDs
     */
    List<Long> ids();
}
