package com.gomeo2o;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
/**
 * 
 * @Description: junit 测试基类
 * @author: fengxin
 * @date: 2015年4月17日 下午2:29:23
 */
public class BaseTest extends TestCase {
	ClassPathXmlApplicationContext context = null;

	@Override
	protected void setUp() throws Exception {

		context = new ClassPathXmlApplicationContext(new String[] { "gome-account-dubbo-consumer.xml" });
		context.start();
	}

	@Override
	protected void tearDown() throws Exception {
		
	}
	
}
