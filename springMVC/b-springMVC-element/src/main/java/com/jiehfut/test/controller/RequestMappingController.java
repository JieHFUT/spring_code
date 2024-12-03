package com.jiehfut.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class")
public class RequestMappingController {


/*    @RequestMapping("/")  // 要保证 RequestMapping 的请求路径是唯一的
    public String index() {
        // 返回视图名称
        return "target";
    }*/


    @RequestMapping("/testRequestMapping") // 直接和浏览器的请求创建关联，进行匹配
    public String testRequestMapping() {
        // 若是类上也添加了 RequestMapping，需要在上下文后访问 "/class/testRequestMapping"
        return "success";
    }


    @RequestMapping(
            value = {"/path1", "path2", "path3"})
    public String pathValueArray() {
        // value 属性是一个数组值，且请求中必需有 value 属性
        return "ArrayPath";
    }


    // method 属性是根据请求方式（GET POST...）来匹配请求的
    @RequestMapping(value = {"path4", "path5"}, method = "GET")
    public String methodRequest() {
        
    }







}
