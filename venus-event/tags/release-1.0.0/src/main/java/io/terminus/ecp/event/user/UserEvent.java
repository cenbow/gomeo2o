/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.event.user;

import io.terminus.ecp.common.event.Event;
import io.terminus.ecp.user.dto.LoginUser;
import io.terminus.pampas.common.BaseUser;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: haolin
 * On: 8/27/14
 */
public abstract class UserEvent extends Event<BaseUser> {

    @Getter @Setter
    private HttpServletRequest request;

    @Getter @Setter
    private HttpServletResponse response;

    public UserEvent(HttpServletRequest request, HttpServletResponse response){
        this(request, response, null);
    }

    public UserEvent(HttpServletRequest request, HttpServletResponse response, LoginUser data){
        super(data);
        this.request = request;
        this.response = response;
    }
}
