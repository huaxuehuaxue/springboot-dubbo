package com.demo.dubbo.consumer.controller;

import com.demo.dubbo.api.MathApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

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


    @GetMapping("futureSum/{max}")
    public Long rpcGetFutureSum(@PathVariable(value = "max") int max, HttpServletRequest request, HttpServletResponse response){
        AsyncContext context = request.startAsync(request, response);
        CompletableFuture<Long> result = mathApi.getMultiSum(max);
        result.thenAccept(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                log.info("成功访问MathController, max = {}, 远程调用结果sum = {}", max, aLong);
                try {
                    context.getResponse().getWriter().print(aLong);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                context.complete();
            }
        });
        log.debug("方法返回");
        return null;
    }
}
