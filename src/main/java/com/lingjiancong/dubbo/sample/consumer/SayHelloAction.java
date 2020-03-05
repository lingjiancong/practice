package com.lingjiancong.dubbo.sample.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import com.lingjiancong.dubbo.sample.service.SayHelloService;

/**
 * @author lingjiancong
 * @since 2020-03-05
 */
@Component
public class SayHelloAction {

    @Reference(cache = "threadlocal")
    private SayHelloService sayHelloService;

    public String doSayHello(String name) {
        return sayHelloService.sayHello(name);
    }

}
