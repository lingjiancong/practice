package com.lingjiancong.dubbo.sample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lingjiancong
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        String path = "classpath:/spring/dubbo-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法

        System.out.println(hello); // 显示调用结果

        Integer count = 0;
        while (count++ < 10) {
            hello = demoService.sayHello(count.toString());
            System.out.println(hello);
        }

        while (count > 0) {

        }

    }

}
