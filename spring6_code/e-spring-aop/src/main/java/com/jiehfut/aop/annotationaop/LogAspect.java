package com.jiehfut.aop.annotationaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 切面类
@Aspect // 表示是一个切面类
@Component // 表示在 ioc 容器中进行管理
public class LogAspect {
    // 1.设置切入点和通知类型：value：切入点表达式配置切入点：即对哪个目标方法进行前置通知
    // "execution(public int com.jiehfut.aop.annotationaop.CalculatorImpl.add(int, int ))"
    // "访问修饰符好 增强方法返回类型 增强方法所在类全路径.方法名称（方法参数）"

    // 前置 @Before(value = "切入点表达式配置切入点")、
    // 返回 @AfterReturning、
    // 异常 @AfterThrowing、
    // 后置 @After()、
    // 环绕 @Around()、
    @Before(value = "execution(public int com.jiehfut.aop.annotationaop.CalculatorImpl.add(int, int ))")
    public void beforeMethod() {

        System.out.println("Logger-->前置通知");
    }




    // 2.

    // 3.
}
