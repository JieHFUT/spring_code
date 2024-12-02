package com.jiehfut.aop.annotationaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCalcuator {

    @Test
    public void testAopAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(12, 23);
        /**
         * Logger-->前置通知
         * 方法内部 result = 35
         */
    }



}
