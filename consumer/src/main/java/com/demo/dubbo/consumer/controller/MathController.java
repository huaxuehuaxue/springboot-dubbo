package com.demo.dubbo.consumer.controller;

import com.demo.dubbo.api.MathApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("math")
public class MathController {
    @Reference
    MathApi mathApi;

    @GetMapping("sum")
    public int rpcGetSum(){
        int a = 1;
        int b = 3;
        int sum = mathApi.getSum(a,b);
        log.info("成功访问MathController, a = {}, b = {}, 远程调用结果sum = {}", a, b, sum);
        return sum;
    }
}
