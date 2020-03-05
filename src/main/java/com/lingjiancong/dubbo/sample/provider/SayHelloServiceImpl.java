package com.lingjiancong.dubbo.sample.provider;

import org.apache.dubbo.config.annotation.Service;
import com.lingjiancong.dubbo.sample.service.SayHelloService;

/**
 * @author lingjiancong
 * @since 2020-03-05
 */
@Service
public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
