package com.jiehfut.xml;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    // 创建 Logger 对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);


    @Test
    public void testUserObject(){
        // 1.加载 spring 配置文件，进行对象创建（）
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获取对象的创建
        User user = (User) context.getBean("user");
        System.out.println("user = " + user);
        // 3.使用对象调用方法进行测试
        user.add();

        /*
            如何使用反射创建的对象：
            1.加载 .xml 配置文件
            2.对 .xml 文件进行解析
            3.获得 .xml 文件中的属性，得到 bean 标签值 id 属性值和 class 属性值
            4.使用反射根据类的全路径创建对象 Class.forName(class属性值)
            5.创建好的对象被统一管理到一个 map 中（DefaultListableBeanFactory 类中有一个map属性
                                             private final Map<String, BeanDefinition> beanDefinitionMap;）
                                             其中 String 就是自己设定xml配置中唯一的标识
                                             beanDefinitionMap 是指类的描述信息（bean对象）
            6.
        */

        // 测试手动写日志，可以将其打印到日志中
        logger.info("logger 调用成功！！！！！！！！！！！！！");
    }

    // 通过反射创建对象
    @Test
    public void testUserObjectByReflection() throws Exception {
        // 获取类 Class 对象
        Class clazz = Class.forName("com.jiehfut.xml.User");
        // 调用方法创建对象
        User user1 = (User) clazz.newInstance();
        // 或者通过构造方法
        User user2 = (User) clazz.getDeclaredConstructor().newInstance();
    }


}
