package com.study.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

public class ServiceStart {
    private static Logger logger = LoggerFactory.getLogger(ServiceStart.class);
    private static volatile boolean running = true;

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:dubbo-provider.xml"});
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    context.stop();
                    context.close();
                    logger.info("Dubbo Service stopped!");
                } catch (Throwable t) {
                    logger.error(t.getMessage(), t);
                }
                synchronized (ServiceStart.class) {
                    running = false;
                    ServiceStart.class.notify();
                }
            }
        });
        context.start();
        logger.info("Dubbo Service start...!!!!!!!!!");
        synchronized (ServiceStart.class) {
            while (running) {
                try {
                    ServiceStart.class.wait();
                } catch (Throwable e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }
}
