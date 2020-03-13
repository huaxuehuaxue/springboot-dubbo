package com.demo.dubbo.api;

import java.util.concurrent.CompletableFuture;

public interface MathApi {
    public int getSum(int a, int b);
    public CompletableFuture<Long> getMultiSum(int max);
}
