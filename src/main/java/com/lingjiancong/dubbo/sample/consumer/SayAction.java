package com.lingjiancong.dubbo.sample.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lingjiancong.dubbo.sample.service.SayHelloService;
/**
 * @author lingjiancong
 * @since 2020-03-05
 */
@Component
public class SayAction {

    @Reference
    private SayHelloService sayHelloService;

    public String say(String name) {
        return sayHelloService.sayHello(name);
    }

}
