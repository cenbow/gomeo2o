package io.terminus.ecp.config.service.zk;
/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

import com.google.common.base.Throwables;
import io.terminus.ecp.config.constants.config.ConfigSettings;
import io.terminus.ecp.config.dao.ConfigDao;
import io.terminus.ecp.config.event.Operator;
import io.terminus.ecp.config.model.Config;
import io.terminus.ecp.config.service.ConfigWriteService;
import io.terminus.ecp.config.util.ConfigCenterUtil;
import io.terminus.pampas.common.Response;
import io.terminus.zookeeper.ZKClientFactory;
import io.terminus.zookeeper.pubsub.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static io.terminus.common.utils.Arguments.isNull;
import static io.terminus.common.utils.Arguments.notEmpty;

/**
 * Created by @author wangxiaolei on 15/4/9.
 * Mail:pivstone@gmail.com
 * 基于 Zookeeper 的配置更新
 */
@Service
@Slf4j
@Configuration
@Profile({"zk", "dubbo", "cluster"})
public class ZkConfigWriteServiceImpl implements ConfigWriteService {

    @Autowired
    private ConfigDao configDao;
    @Autowired
    private ZKClientFactory zkClientFactory;
    private Publisher publisher;




    @PostConstruct
    public void init() throws Exception {
        publisher = new Publisher(zkClientFactory, ConfigSettings.ZK_BASE_PATH, ConfigSettings.ZK_CONFIG_TOPIC);
    }




    @Override
    public Response<Boolean> create(@NotNull Config config) {
        Response<Boolean> res = new Response<>();
        try {
            config.setCreatedAt(new Date());
            config.setUpdatedAt(new Date());
            config = createSingle(config);
            publisher.publish(SerializationUtils.serialize(ConfigCenterUtil.wrapperEvent(Operator.CREATE, config)));

            res.setResult(Boolean.TRUE);
        }catch (IllegalStateException e){
            log.error("fail to create node in Zookeeper,cause:{}", Throwables.getStackTraceAsString(e));
            res.setError(e.getMessage());
        }catch (Exception e) {
            log.error("fail to create node in Zookeeper,cause:{}", Throwables.getStackTraceAsString(e));
            res.setError(Throwables.getStackTraceAsString(e));
        }
        return res;
    }

    @Override
    public Response<Boolean> bulkCreate(@NotEmpty List<Config> configs) {
        Response<Boolean> res = new Response<>();
        try {
            for ( Config cfg:configs) {
                cfg.setCreatedAt(new Date());
                cfg.setUpdatedAt(new Date());
                cfg = createSingle(cfg);
                publisher.publish(SerializationUtils.serialize(ConfigCenterUtil.wrapperEvent(Operator.CREATE, cfg)));
            }

            res.setResult(true);
        } catch (Exception e) {
            log.error("fail to bulk create node in Zookeeper,cause:{}", Throwables.getStackTraceAsString(e));
            res.setError(Throwables.getStackTraceAsString(e));
        }
        return res;
    }


    @Override
    public Response<Boolean> update(@NotNull Config config) {
        Response<Boolean> res = new Response<>();
        try {

            Config updating = configDao.findByKey(config.getKey());
            if(updating == null){
                res.setError("配置项不存在,key:{}");
                return res;
            }

            // filed need to assign
            config.setId(updating.getId());
            config.setKey(updating.getKey());
            config.setUpdatedAt(new Date());

            config = updateSingleConfig(config);
            publisher.publish(SerializationUtils.serialize(ConfigCenterUtil.wrapperEvent(Operator.UPDATE, config)));


            res.setResult(true);
        } catch (Exception e) {
            log.error("fail to update node data in Zookeeper,cause:{}", Throwables.getStackTraceAsString(e));
            res.setError(Throwables.getStackTraceAsString(e));
        }
        return res;
    }

    @Override
        public Response<Boolean> bulkUpdate(@NotNull Config[] configs) {
        Response<Boolean> res = new Response<>();
        try {
            for (Config cfg:configs) {
                if(configDao.findByKey(cfg.getKey())==null){
                    res.setError("配置项不存在,key:{}");
                    return res;
                }
                cfg.setUpdatedAt(new Date());
                cfg = updateSingleConfig(cfg);
                publisher.publish(SerializationUtils.serialize(ConfigCenterUtil.wrapperEvent(Operator.UPDATE, cfg)));
            }
            res.setResult(true);
        } catch (Exception e) {
            log.error("fail to bulk update node in Zookeeper,cause:{}", Throwables.getStackTraceAsString(e));
            res.setError(Throwables.getStackTraceAsString(e));
        }
        return res;
    }



    @Override
    public Response<Boolean> delete(@NotNull Config config) {
        Response<Boolean> res = new Response<>();
        try {

            Config cfg = configDao.findByKey(config.getKey());

            if(cfg == null){
                res.setError("配置项不存在,key:{}");
                return res;
            }
            configDao.delete(cfg.getId());
            publisher.publish(SerializationUtils.serialize(ConfigCenterUtil.wrapperEvent(Operator.DELETE, config)));
            res.setResult(true);
        } catch (Exception e) {
            log.error("fail to update node data in Zookeeper,cause:{}", Throwables.getStackTraceAsString(e));
            res.setError(Throwables.getStackTraceAsString(e));
        }
        return res;
    }




    /**
     * 检查是否有重复配置项
     */
    private void checkIfDuplicate(Config config) {
        checkState(isNull(configDao.findByKey(config.getKey())), "config.key.duplicate");
    }

    /**
     * 插入或更新单个配置项
     */
    private Config updateSingleConfig(Config config) {
        configDao.update(config);
        return configDao.findByKey(config.getKey());
    }

    private Config createSingle(Config config) {
        checkArgument(notEmpty(config.getKey()), "config.key.empty");
        checkArgument(notEmpty(config.getValue()), "config.value.empty");
        checkIfDuplicate(config);
        configDao.create(config);
        return configDao.findByKey(config.getKey());
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
            Config[] template = new Config[0];
            return bulkUpdate(data.toArray(template));

        }catch (Exception e){
            res.setError(Throwables.getStackTraceAsString(e));
            log.warn(Throwables.getStackTraceAsString(e));
        }
        return res;
    }
}
