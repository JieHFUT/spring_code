package com.jiehfut.springmybatisplusmultidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringMybatisPlusMultiDatasourceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc =
                SpringApplication.run(SpringMybatisPlusMultiDatasourceApplication.class, args);
        

    }

}
