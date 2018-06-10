package com.lingjiancong.dubbo.sample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lingjiancong
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        String path = "classpath:/spring/dubbo-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.start();

        System.in.read(); // 按任意键退出
    }
}
