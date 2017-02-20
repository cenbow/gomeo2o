package com.gomeo2o;


import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @Description: doubbo服务测试类  服务提供者
 * @author: fengxin
 * @date: 2015年4月17日 下午2:27:23
 */
public class DubboProviderMain {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/venus-account-dubbo-provider.xml" });
		context.start();
		System.out.println("Press any key to exit.");
		System.in.read();
		
	}
}