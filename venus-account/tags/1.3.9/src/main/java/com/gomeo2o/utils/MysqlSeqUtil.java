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

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: mysql获取序列工具类
 * @author: wangyunpeng
 * @modifier:gongjiaming
 * @date: 2015年4月20日
 */
public class MysqlSeqUtil {
	private static final Logger log = LoggerFactory.getLogger(MysqlSeqUtil.class);
	
	private volatile static MysqlSeqUtil self;
	private static Map<String, MysqlSequence> seqMap = new HashMap<String, MysqlSequence>();
	private static DataSource dataSource;
	
	private MysqlSeqUtil() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring/spring-context.xml" });
			dataSource = (DataSource) context.getBean("dataSource");
		} catch (Exception e) {
			log.error("MysqlSeqUtil initialize error!", e);
			throw new RuntimeException(e);
		}
	}

	public static MysqlSeqUtil getInstance() {
		if (self == null) {
			synchronized (MysqlSeqUtil.class) {
				if (self == null) {
					self = new MysqlSeqUtil();
				}
			}
		}
		return self;
	}
	
	private MysqlSequence getSeq(String name) {
		MysqlSequence seq = seqMap.get(name);
		if(null == seq) {
			synchronized (MysqlSeqUtil.class) {
				seq = new MysqlSequence(dataSource, name);
				seqMap.put(name, seq);
			}
		}
		return seq;
	}
	
	public long get(String name) {
		return getSeq(name).get();
	}
}
