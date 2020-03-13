package com.demo.dubbo.provider.controller;

import com.demo.dubbo.api.utils.DateFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {

    @GetMapping("hello")
    public String sayHello(){
        log.info("成功访问IndexController");
        SimpleDateFormat sdf = DateFormatUtil.getCommonFormat();
        return "Hello,Dubbo Provider! MsgTime:" + sdf.format(new Date());
    }
}
