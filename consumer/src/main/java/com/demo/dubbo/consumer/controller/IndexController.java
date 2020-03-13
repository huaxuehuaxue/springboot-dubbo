package com.demo.dubbo.consumer.controller;

import com.demo.dubbo.api.utils.DateFormatUtil;
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
        SimpleDateFormat sdf = DateFormatUtil.getCommonFormat();
        return "Hello,Dubbo Consumer! MsgTime:" + sdf.format(new Date());
    }
}
