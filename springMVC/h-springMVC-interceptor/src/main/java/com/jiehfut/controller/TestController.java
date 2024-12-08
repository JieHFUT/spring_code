package com.jiehfut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: TestController
 * Package: com.jiehfut.controller
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/12/8 15:41
 * @Version 1.0
 */
@Controller
public class TestController {



    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        return "success";
    }



}
