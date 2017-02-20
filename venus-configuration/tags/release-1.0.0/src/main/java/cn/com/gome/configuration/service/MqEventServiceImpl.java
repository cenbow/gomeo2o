package cn.com.gome.configuration.service;

import cn.com.gome.configuration.config.MqConfig;
import cn.com.gome.configuration.exception.MqSendException;
import cn.com.gome.configuration.mq.EventMessage;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;
import com.google.common.base.Throwables;
import io.terminus.common.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Desc:Mq消息发送机制
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-27.
 */
@Slf4j
@Service
@Primary
public class MqEventServiceImpl implements MqEventService {

    @Override
    public void send(Object eventContent, MqConfig mqConfig) throws MqSendException {
        log.info("mqconfig = {}", JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(mqConfig));
        if (mqConfig.getTopic() == null) {
            throw new MqSendException("topic can not be empty.");
        }

        if(eventContent == null){
            throw new MqSendException("eventContent can not be null.");
        }

        EventMessage eventMessage = new EventMessage(eventContent, null, null);

        DefaultMQProducer producer = null;
        try {
            producer = new DefaultMQProducer(mqConfig.getGroupName());
            producer.setNamesrvAddr(mqConfig.getMqAddress());
            producer.setInstanceName(mqConfig.getInstanceName());
            producer.start();

            Message message;
            if (eventMessage.getTag() != null && !eventMessage.getTag().isEmpty()) {
                message = new Message(mqConfig.getTopic(), eventMessage.getTag(), eventMessage.getKey(), eventMessage.getEventData());
            } else {
                message = new Message(mqConfig.getTopic(), eventMessage.getEventData());
            }

            SendResult result = producer.send(message);
            if( result != null && result.getSendStatus().equals(SendStatus.SEND_OK)){
                log.info("send mq message success, msgId = {}", result.getMsgId());
            }
        }catch(Exception e){
            log.error("Send message to mq failed, topic={}, eventContent={}, error code={}",
                    mqConfig.getTopic(), eventContent, Throwables.getStackTraceAsString(e));
        }finally {
            if(producer != null){
                producer.shutdown();
            }
        }
    }

    @Override
    public void send(EventMessage eventMessage, MqConfig mqConfig) throws MqSendException {
        log.info("mqconfig = {}", JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(mqConfig));
        if (mqConfig.getTopic() == null) {
            throw new MqSendException("topic can not be empty.");
        }

        if(eventMessage.getEventData() == null){
            throw new MqSendException("eventContent can not be null.");
        }

        DefaultMQProducer producer = null;
        try {
            producer = new DefaultMQProducer(mqConfig.getGroupName());
            producer.setNamesrvAddr(mqConfig.getMqAddress());
            producer.setInstanceName(mqConfig.getInstanceName());
            producer.start();

            Message message;
            if (eventMessage.getTag() != null && !eventMessage.getTag().isEmpty()) {
                message = new Message(mqConfig.getTopic(), eventMessage.getTag(), eventMessage.getKey(), eventMessage.getEventData());
            } else {
                message = new Message(mqConfig.getTopic(), eventMessage.getEventData());
            }

            SendResult result = producer.send(message);
            if( result != null && result.getSendStatus().equals(SendStatus.SEND_OK)){
                log.info("send mq message success, eventMessage= {}, msgId = {}", eventMessage, result.getMsgId());
            }
        }catch(Exception e){
            log.error("Send message to mq failed, eventMessage={}, error code={}",
                    eventMessage, Throwables.getStackTraceAsString(e));
        }finally {
            if(producer != null){
                producer.shutdown();
            }
        }
    }
}
