package cn.com.gome.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-04-29 2:53 PM  <br>
 * Author: xiao
 */
@Slf4j
public class BootStrap {
    public static void main(String[] args) throws InterruptedException {
        final ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/venus-configuration-dubbo-provider.xml");
        ac.start();
        log.info("Configuration Service started successfully");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                log.info("Shutdown hook was invoked. Shutting down Configuration Service.");
                ac.close();
            }
        });
        //prevent main thread from exit
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();

    }
}
