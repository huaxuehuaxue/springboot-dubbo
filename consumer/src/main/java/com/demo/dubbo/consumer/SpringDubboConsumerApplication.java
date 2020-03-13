package com.demo.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class SpringDubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDubboConsumerApplication.class);
    }
}
