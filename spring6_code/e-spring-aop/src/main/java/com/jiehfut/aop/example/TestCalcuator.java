package com.jiehfut.aop.example;

import org.junit.jupiter.api.Test;

public class TestCalcuator {

    @Test
    public void testProxyFactory(){
        // 创建代理类对象
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);

        /**
         * [动态代理][日志] add，参数：[1, 2]
         * 方法内部 result = 3
         * [动态代理][日志] add，结果：3
         * [动态代理][日志] add，方法执行完毕
         */
    }



}
