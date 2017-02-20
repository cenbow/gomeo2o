/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.service;

import com.google.common.base.Throwables;
import io.terminus.ecp.config.event.ConfigEvent;
import io.terminus.ecp.config.dao.ConfigDao;
import io.terminus.ecp.config.event.ConfigEventDispatcher;
import io.terminus.ecp.config.model.Config;
import io.terminus.ecp.config.util.ConfigCenterUtil;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static io.terminus.common.utils.Arguments.isNull;
import static io.terminus.common.utils.Arguments.notEmpty;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-03-27 2:30 PM  <br>
 * Author: xiao
 */
@Slf4j
@Service
@Profile({"dev", "standalone"})
@Configuration
public class ConfigWriteServiceImpl implements ConfigWriteService {

    @Autowired
    private ConfigDao configDao;

    @Autowired
    private ConfigEventDispatcher eventDispatcher;

    /**
     * 创建一条配置信息
     *
     * @param config 配置信息
     * @return 操作是否成功
     */
    @Override
    public Response<Boolean> create(Config config) {
        Response<Boolean> res = new Response<>();
        try {
            config.setCreatedAt(new Date());
            config.setUpdatedAt(new Date());
            createSingle(config);
            ConfigEvent configEvent = ConfigCenterUtil.wrapperEvent(config);
            eventDispatcher.publish(configEvent);
            res.setResult(Boolean.TRUE);
        } catch (IllegalArgumentException | IllegalStateException e) {
            log.error("fail to create {}, error:{}", config, e.getMessage());
            res.setError(e.getMessage());
        } catch (Exception e) {
            log.error("fail to create {}, cause:{}", config, e);
            res.setError("config.create.fail");
        }
        return res;
    }


    /**
     * 创建一组配置信息
     *
     * @param configs 配置信息
     * @return 操作是否成功
     */
    @Override
    public Response<Boolean> bulkCreate(List<Config> configs) {
        Response<Boolean> res = new Response<>();
        try {
            for (Config config : configs) {
                config.setCreatedAt(new Date());
                config.setUpdatedAt(new Date());
                createSingle(config);
                ConfigEvent configEvent = ConfigCenterUtil.wrapperEvent(config);
                eventDispatcher.publish(configEvent);
            }
            res.setResult(true);
        } catch (IllegalArgumentException | IllegalStateException e) {
            log.error("fail to create {}, error:{}", configs, e.getMessage());
            res.setError(e.getMessage());
        } catch (Exception e) {
            log.error("fail to create {}, cause:{}", configs, e);
            res.setError("config.create.fail");
        }
        return res;
    }

    private void checkIfDuplicate(Config config) {
        checkState(isNull(configDao.findByKey(config.getKey())), "config.key.duplicate");
    }

    private void createSingle(Config config) {
        checkArgument(notEmpty(config.getKey()), "config.key.empty");
        checkArgument(notEmpty(config.getValue()), "config.value.empty");
        checkIfDuplicate(config);
        configDao.create(config);
    }

    /**
     * 更新一条配置信息
     *
     * @param config 配置信息
     * @return 操作是否成功
     */
    @Override
    public Response<Boolean> update(Config config) {
        Response<Boolean> res = new Response<>();
        try {
            config.setUpdatedAt(new Date());
            updateSingle(config);
            ConfigEvent configEvent = ConfigCenterUtil.wrapperEvent(config);
            eventDispatcher.publish(configEvent);
            res.setResult(Boolean.TRUE);
        } catch (IllegalArgumentException | IllegalStateException e) {
            log.error("fail to create {}, error:{}", config, e.getMessage());
            res.setError(e.getMessage());
        } catch (Exception e) {
            log.error("fail to create {}, cause:{}", config, e);
            res.setError("config.create.fail");
        }
        return res;
    }

    /**
     * 更新多条配置信息
     *
     * @param configs 配置列表
     * @return 操作是否成功
     */
    @Override
    public Response<Boolean> bulkUpdate(Config[] configs) {
        Response<Boolean> res = new Response<>();
        try {
            for (Config config : configs) {
                config.setUpdatedAt(new Date());
                updateSingle(config);
                ConfigEvent configEvent = ConfigCenterUtil.wrapperEvent(config);
                eventDispatcher.publish(configEvent);
            }
            res.setResult(Boolean.TRUE);
        } catch (IllegalArgumentException | IllegalStateException e) {
            log.error("fail to create {}, error:{}", configs, e.getMessage());
            res.setError(e.getMessage());
        } catch (Exception e) {
            log.error("fail to create {}, cause:{}", configs, e);
            res.setError("config.create.fail");
        }
        return res;
    }

    /**
     * 删除一条配置信息
     *
     * @param config 配置信息
     * @return 操作是否成功
     */
    @Override
    public Response<Boolean> delete(@NotNull Config config) {
        Response<Boolean> res = new Response<>();
        try {
            configDao.delete(config.getId());
            ConfigEvent configEvent = ConfigCenterUtil.wrapperEvent(config);
            eventDispatcher.publish(configEvent);
            res.setResult(Boolean.TRUE);
        } catch (IllegalArgumentException | IllegalStateException e) {
            log.error("fail to create {}, error:{}", config, e.getMessage());
            res.setError(e.getMessage());
        } catch (Exception e) {
            log.error("fail to create {}, cause:{}", config, e);
            res.setError("config.create.fail");
        }
        return res;
    }

    /**
     * {@link ConfigWriteService#reload()}
     *
     *
     * 重新将数据库中的配置信息加载内存中，由于是才有了Update的事件通知，在一个节点上执行，所有其他节点的配置都会更新
     * @return 操作结果
     */
    @Override
    public Response<Boolean> reload() {
        Response<Boolean> res=new Response<>();
        try{
            List<Config> data=configDao.listAll();
            for(Config config:data){
                ConfigEvent configEvent = ConfigCenterUtil.wrapperEvent(config);
                eventDispatcher.publish(configEvent);
            }
            res.setResult(Boolean.TRUE);
        }catch (Exception e){
            res.setError(Throwables.getStackTraceAsString(e));
            log.warn(Throwables.getStackTraceAsString(e));
        }
        return res;
    }
    private void updateSingle(Config config) {
        configDao.update(config);
    }
}
