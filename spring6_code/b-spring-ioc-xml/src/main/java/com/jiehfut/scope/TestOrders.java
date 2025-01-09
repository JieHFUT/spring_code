package com.jiehfut.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {

    // 单实例是初始化的时候创建，多实例是获取 bean 的时候创建
    @Test
    public void testSongleton(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = (Orders) context.getBean("orders", Orders.class);
        System.out.println(orders);
        /*
          - Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@3542162a
          - Loaded 1 bean definitions from class path resource [bean-scope.xml]
          - Creating shared instance of singleton bean 'orders'
        */
        Orders orders2 = (Orders) context.getBean("orders", Orders.class);
        System.out.println(orders == orders2); // true
    }
    
    @Test
    public void testPrototype(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = (Orders) context.getBean("orders", Orders.class);
        System.out.println(orders);

        Orders orders2 = (Orders) context.getBean("orders", Orders.class);
        System.out.println(orders == orders2); // false
    }
}
