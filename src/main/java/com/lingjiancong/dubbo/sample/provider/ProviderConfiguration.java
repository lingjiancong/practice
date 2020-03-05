package com.lingjiancong.dubbo.sample.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * @author lingjiancong
 * @since 2020-03-05
 */
@EnableDubbo
@Configuration
@PropertySource("classpath:/spring/dubbo-provider.properties")
@ComponentScan
public class ProviderConfiguration {

}
