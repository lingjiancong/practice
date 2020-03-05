package com.lingjiancong.dubbo.sample.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * @author lingjiancong
 * @since 2020-03-05
 */
@Configuration
@EnableDubbo
@PropertySource("classpath:/spring/dubbo-consumer.properties")
@ComponentScan
public class ConsumerConfiguration {

}
