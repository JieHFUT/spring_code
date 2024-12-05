package com.jiehfut.restful.controller;


import com.jiehfut.restful.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    
}
