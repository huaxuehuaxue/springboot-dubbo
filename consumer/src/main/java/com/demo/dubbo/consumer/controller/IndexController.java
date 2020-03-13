package com.demo.dubbo.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("index")
public class IndexController {

    @GetMapping("hello")
    public String sayHello(){
        log.info("成功调用IndexController");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Hello,Dubbo Consumer! MsgTime:" + sdf.format(new Date());
    }
}
