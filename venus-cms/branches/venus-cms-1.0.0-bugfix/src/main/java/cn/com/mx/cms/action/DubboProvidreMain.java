package cn.com.mx.cms.action;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class DubboProvidreMain {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/venus-cms-dubbo-provider.xml","classpath:/spring/venus-cms-dubbo-consumer.xml" });
		context.start();
		System.out.println("Press any key to exit.");
		System.in.read();
		
	}
}
