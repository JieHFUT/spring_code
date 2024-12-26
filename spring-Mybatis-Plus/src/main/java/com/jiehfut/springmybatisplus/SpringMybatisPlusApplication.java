package com.jiehfut.springmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiehfut.springmybatisplus.mapper") // 配置扫描路径，将该路径下的使用相关注解的组件注册进容器中
public class SpringMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisPlusApplication.class, args);

    }

}
