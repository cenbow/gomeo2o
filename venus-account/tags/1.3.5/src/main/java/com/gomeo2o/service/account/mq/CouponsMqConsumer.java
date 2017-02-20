/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: fengxin
 * @date: 2015年6月23日 下午5:29:51
 */
package com.gomeo2o.service.account.mq;

import io.terminus.ecp.config.service.ConfigReadService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.gomeo2o.facade.account.entity.CouponDetail;
import com.gomeo2o.facade.account.entity.CouponInfo;

/**
 * @Description: 用户领取红包MQ接收 
 * @author: fengxin
 * @date: 2015年6月23日 下午5:29:51
 */
@Slf4j
public class CouponsMqConsumer implements InitializingBean{
	
	
	@Autowired
	private CouponsMqManage couponsMqManage;
	
	@Autowired
	private ConfigReadService configReadService;
	
	private DefaultMQPushConsumer consumer;

	@Override
	public void afterPropertiesSet() throws Exception {
		consumer = new DefaultMQPushConsumer(configReadService.getByKey("coupon.gome.mq.group").getResult().getValue());
		consumer.setNamesrvAddr(configReadService.getByKey("coupon.gome.mq.address").getResult().getValue());
		consumer.subscribe(configReadService.getByKey("coupon.gome.mq.topic").getResult().getValue(), "*");
		consumer.registerMessageListener(new MessageListenerConcurrently() {
		public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
			MessageExt msg = msgs.get(0);
			if (msg.getTopic().equals(configReadService.getByKey("coupon.gome.mq.topic").getResult().getValue())) {
				ByteArrayInputStream bis = new ByteArrayInputStream (msg.getBody());        
	            ObjectInputStream ois = null;
				try {
					ois = new ObjectInputStream (bis);
					if (msg.getTags() != null && msg.getTags().equals("collectCoupons")) {
						couponsMqManage.collectCoupons((CouponInfo) ois.readObject());
					}else if(msg.getTags() != null && msg.getTags().equals("useCoupons")){
				        couponsMqManage.useCoupons((CouponDetail) ois.readObject());
					}
				} catch (IOException e) {
					log.error("MQ接收红包信息错误{}", e);
				} catch (ClassNotFoundException e) {
					log.error("MQ接收红包信息错误{}", e);
				}finally{
					try {
						ois.close();
						bis.close();   
					} catch (IOException e) {
						log.error("com.gomeo2o.service.account.mq.CouponsMqManage.collectCoupons,method json is error{}", e);
					}
				}     
			} 
			
			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		}
		});
		consumer.start();
		log.info("com.gomeo2o.service.account.mq.CouponsMqConsumer,CouponsGroupName is start");
	}

}
