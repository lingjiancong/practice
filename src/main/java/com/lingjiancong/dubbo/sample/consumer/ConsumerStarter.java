package com.lingjiancong.dubbo.sample.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lingjiancong
 * @since 2020-03-05
 */
public class ConsumerStarter {

    public static final Logger logger = LoggerFactory.getLogger(ConsumerStarter.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        SayHelloAction sayHelloAction = context.getBean(SayHelloAction.class);
        String dubbo = sayHelloAction.doSayHello("dubbo");
        logger.info(dubbo);
        SayAction sayAction = context.getBean(SayAction.class);
        dubbo = sayAction.say("dubbo");
        logger.info(dubbo);

    }

}
