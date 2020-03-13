package com.demo.dubbo.provider.service;

import com.demo.dubbo.api.MathApi;
import com.demo.dubbo.api.utils.DateFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Slf4j
@Service
public class MathService implements MathApi {

    @Override
    public int getSum(int a, int b) {
        log.info("成功调用 MathService.getSum() 方法");
        return a + b;
    }


    @Override
    public CompletableFuture<Long> getMultiSum(int max) {
        return CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = 0L;
                for(int i=0;i<max;i++){
                    result += i;
                }
                SimpleDateFormat sdf = DateFormatUtil.getCommonFormat();
                log.info("计算出结果：result = {}, time = {}", result, sdf.format(new Date()));
                return result;
            }
        });

    }
}
