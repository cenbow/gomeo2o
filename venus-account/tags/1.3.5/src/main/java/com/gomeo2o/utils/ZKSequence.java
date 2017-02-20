/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: wangyunpeng
 * @date: 2015年4月8日上午9:27:56
 */
package com.gomeo2o.utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 通过zookeeper获取序列
 * @author: wangyunpeng
 * @date: 2015年4月8日下午3:05:03
 */
public class ZKSequence {
	private static final Logger log = LoggerFactory.getLogger(ZKSequence.class);
	private long blockSize;
	private long startValue;
	private long currentValue;
	private long endValue;
	private CuratorFramework client;
	private String BASE_PATH = "/zk_seq/";
	private DistributedAtomicLong count;
	private String seqName;
	
	
	public ZKSequence(CuratorFramework client, String seqName) {
		this.blockSize = 1;
//		this.blockSize = 20;
		this.startValue = 0L;
		this.currentValue = 0L;
		this.endValue = 0L;
		this.client = client;
		this.seqName = seqName;
		this.count = new DistributedAtomicLong(this.client, BASE_PATH+this.seqName , new RetryNTimes(10, 10));
	}

	/**
	* @Description:　获取步长 
	* @author: wangyunpeng
	* @date: 2015年4月8日下午3:05:33
	*/
	private void getNextBlock() {
		try {
			AtomicValue<Long> value = null;
			boolean flag = false;
			int tc = 0;
			do {
				value = count.add(blockSize);
				flag = value.succeeded();
				tc++;
				if(tc > 70)
					Thread.sleep(50);
			} while (!flag || tc>100);
			this.startValue = value.preValue();
			this.currentValue = value.preValue();
			this.endValue = value.postValue();
			log.info(startValue + "-" + currentValue + "-" + endValue);
		} catch (Exception e) {
			log.error("",e);
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	* @Description:　获取序列
	* @author: wangyunpeng
	* @date: 2015年4月8日下午3:06:17
	* @return
	*/
	public synchronized long get() {
		if(this.startValue == 0)
			getNextBlock();
		if(this.currentValue == this.endValue)
			getNextBlock();
		
		return ++this.currentValue;
	}


}