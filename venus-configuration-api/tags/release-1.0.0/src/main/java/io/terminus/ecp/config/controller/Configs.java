package io.terminus.ecp.config.controller;
/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

import io.terminus.common.exception.JsonResponseException;
import io.terminus.ecp.config.service.ConfigWriteService;
import io.terminus.pampas.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * ConfigCenter Controller
 *
 * Created by @author wangxiaolei on 15/6/9.
 * Mail:pivstone@gmail.com
 */
@Controller
@RequestMapping("/api/config_center")
public class Configs {

    @Autowired
    private ConfigWriteService service;
    /**
     * 重新从数据库中加载配置信息
     */
    @RequestMapping(value = "/reload", method = RequestMethod.POST)
    @ResponseBody
    public boolean Reload(){
       Response<Boolean> response = service.reload();
        if (response.isSuccess()) {
            return response.getResult();
        }
        throw new JsonResponseException(response.getError());
    }
}
