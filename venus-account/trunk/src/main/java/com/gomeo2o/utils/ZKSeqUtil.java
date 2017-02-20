/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: wangyunpeng
 * @date: 2015年4月8日上午9:27:56
 */
package com.gomeo2o.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @Description: zookeeper获取序列工具类
 * @author: wangyunpeng
 * @date: 2015年4月8日下午3:08:42
 */
public class ZKSeqUtil {
	
	private String dubboRegistry;
	
	@Autowired
    private ApplicationContext applicationContext;
	
	private static final Logger log = LoggerFactory.getLogger(ZKSeqUtil.class);
	
	private volatile static ZKSeqUtil self;
	
	private static Map<String, ZKSequence> seqMap = new HashMap<String, ZKSequence>();
	//private static final String ZK_HOST = PropertiesUtil.getProProperties("zookeeperAddress", null).replace("zookeeper://", "").replace("?backup=", ",");
	private static CuratorFramework zkclient;

	private ZKSeqUtil() {
		System.out.println("");
	}
	private ZKSeqUtil(String dubboRegistry) {
		this.dubboRegistry = dubboRegistry;
		try {
			RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
			zkclient = CuratorFrameworkFactory.newClient(dubboRegistry.replace("zookeeper://", "").replace("?backup=", ","), retryPolicy);
			zkclient.start();
		} catch (Exception e) {
			log.error("ZKSeqUtil initialize error!", e);
			throw new RuntimeException(e);
		}
	}

	public static ZKSeqUtil getInstance() {
		if (self == null) {
			synchronized (ZKSeqUtil.class) {
				if (self == null) {
					self = (ZKSeqUtil)SpringContextUtil.getBean("zKSeqUtil");
				}
			}
		}
		return self;
	}
	
	private ZKSequence getSeq(String name) {
		ZKSequence seq = seqMap.get(name);
		if(null == seq) {
			synchronized (ZKSeqUtil.class) {
				seq = new ZKSequence(zkclient, name);
				seqMap.put(name, seq);
			}
		}
		return seq;
	}
	/**
	 * @Description:根据名称获取序列 
	 * @author: gongjiaming
	 * @date: 2015年4月24日
	 * @param name
	 * @return
	 */
	public long get(String name) {
		return getSeq(name).get();
	}
	/**
	 * @Description: 根据名称获取序列，并指定长度（不足补0)
	 * @author: gongjiaming
	 * @date: 2015年4月24日
	 * @param name
	 * @param length
	 * @return
	 */
	public String getSeqByFixedLength(String name,int length){
			StringBuilder ruleStr = new StringBuilder("");
			if(length > 0){
				ruleStr.append("%0").append(length).append("d");
			}else{
				ruleStr.append("%d");
			}
			return String.format(ruleStr.toString(), get(name));
		}
	/**
	 * @return the marketLimit
	 */
	public String getDubboRegistry() {
		return dubboRegistry;
	}
	/**
	 * @param marketLimit the marketLimit to set
	 */
	public void setDubboRegistry(String dubboRegistry) {
		this.dubboRegistry = dubboRegistry;
	}
}
