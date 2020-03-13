package com.demo.dubbo.provider.service;

import com.demo.dubbo.api.MathApi;

public class MathService implements MathApi {
    @Override
    public int getSum(int a, int b) {
        return a + b;
    }
}
