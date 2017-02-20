package cn.com.gome.configuration.service;


import cn.com.gome.configuration.config.MqConfig;
import cn.com.gome.configuration.exception.MqSendException;
import cn.com.gome.configuration.mq.EventMessage;

/**
 * Desc:mq服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-27.
 */
public interface MqEventService {
    /**
     * 向MQ发送消息
     * @param eventContent  消息信息
     * @throws MqSendException
     */
    public void send(Object eventContent, MqConfig mqConfig) throws MqSendException;

    /**
     * 向MQ发送消息
     * @param eventMessage  消息对象
     * @throws MqSendException
     */
    public void send(EventMessage eventMessage, MqConfig mqConfig) throws MqSendException;
}
