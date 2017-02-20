/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: haolin
 * On: 8/27/14
 */
@NoArgsConstructor @AllArgsConstructor
public abstract class Event<T> {
    @Getter @Setter
    private T data;         //事件携带数据

}
