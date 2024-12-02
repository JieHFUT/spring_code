package com.jiehfut.resource.controller;


import com.jiehfut.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {

    // 根据名称进行注入
    @Resource(name = "myUserService")
    private UserService userService;

    // 如果不为 Resource 指定名称，也没有对属性名称指定对应的类的名称，就会根据类型注入

    public void insertUser(){
        System.out.println("controller...");
        userService.insertUser();
    }



}