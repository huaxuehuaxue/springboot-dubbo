package com.demo.dubbo.provider.service;

import com.demo.dubbo.api.MathApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service
public class MathService implements MathApi {

    @Override
    public int getSum(int a, int b) {
        log.info("成功调用 MathService.getSum() 方法");
        return a + b;
    }
}
