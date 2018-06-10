package com.lingjiancong.dubbo.sample;

/**
 * @author lingjiancong
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
