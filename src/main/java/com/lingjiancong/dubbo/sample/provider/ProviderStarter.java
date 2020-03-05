package com.lingjiancong.dubbo.sample.provider;

import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lingjiancong
 * @since 2020-03-05
 */
public class ProviderStarter {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();
    }

}
