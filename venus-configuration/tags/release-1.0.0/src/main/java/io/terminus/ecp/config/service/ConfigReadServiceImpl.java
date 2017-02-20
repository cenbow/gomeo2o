/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.service;

import com.google.common.base.Optional;
import io.terminus.common.model.PageInfo;
import io.terminus.common.model.Paging;
import io.terminus.ecp.config.dao.ConfigDao;
import io.terminus.ecp.config.model.Config;
import io.terminus.ecp.config.util.ConfigCenterUtil;
import io.terminus.ecp.config.util.ConfigMeta;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-03-27 2:51 PM  <br>
 * Author: xiao
 */
@Slf4j
@Service
@Profile({"dev", "standalone"})
@Configuration
public class ConfigReadServiceImpl implements ConfigReadService {

    @Autowired
    private ConfigDao configDao;

    @Override
    public Response<List<Config>> listAll() {
        Response<List<Config>> res = new Response<List<Config>>();
        try {
            List<Config> configs = configDao.listAll();
            res.setResult(configs);
            return res;
        } catch (Exception e) {
            log.error("fail to load config, cause:{}", e);
            res.setError("config.load.fail");
        }

        return res;
    }

    @Override
    public Response<Paging<Config>> pagingConfigs(Integer pageNo,Integer pageSize) {
        Response<Paging<Config>> response=new Response<>();
        try{
            PageInfo page = new PageInfo(pageNo, pageSize);
            Paging<Config> data=configDao.pagingConfigs(page.getOffset(), page.getLimit());
            response.setResult(data);
        }catch (Exception e){
            log.error("fail to paging load config,pageNo:{},pageSize:{}, cause:{}", pageNo,pageSize,e);
            response.setError("config.load.fail");
        }
        return response;
    }

    @Override
    public Response<Config> getByKey(String key) {
        Response<Config> res = new Response<Config>();
        try {
            Config config = configDao.findByKey(key);
            if (config != null) {
                res.setResult(config);
            }

        } catch (Exception e) {
            log.error("fail to load config, cause:{}", e);
            res.setError("config.load.fail");
        }
        return res;
    }

    @Override
    public Response<List<Config>> searchByKey(String key) {
        Response<List<Config>> res = new Response<>();
        try {
            List<Config> configList = configDao.searchByKey(key);
            res.setResult(configList);
        } catch (Exception e) {
            log.error("fail to load config, cause:{}", e);
            res.setError("config.load.fail");
        }
        return res;
    }

    @Override
    public Response<Map<String, Map<String, List<Config>>>> getAll() {
        Response<Map<String, Map<String, List<Config>>>> response = new Response<>();
        Map<String, Map<String, List<Config>>> configMap = new HashMap<>();
        List<Config> configList = configDao.listAll();
        for (Config config : configList) {
            Optional<ConfigMeta> oMeta = ConfigCenterUtil.getConfigMeta(config.getKey());
            if (oMeta.isPresent()) {
                ConfigMeta meta = oMeta.get();
                if (!configMap.containsKey(meta.getConfigGroup())) {
                    Map<String, List<Config>> configTypeMap = new HashMap<>();
                    configMap.put(meta.getConfigGroup(), configTypeMap);
                }
                Map<String, List<Config>> configTypeMap = configMap.get(meta.getConfigGroup());
                if (!configTypeMap.containsKey(meta.getConfigType())) {
                    List<Config> list = new ArrayList<>();
                    configTypeMap.put(meta.getConfigType(), list);
                }
                List<Config> list = configTypeMap.get(meta.getConfigType());
                list.add(config);
            }
        }
        response.setResult(configMap);
        return response;
    }


}
