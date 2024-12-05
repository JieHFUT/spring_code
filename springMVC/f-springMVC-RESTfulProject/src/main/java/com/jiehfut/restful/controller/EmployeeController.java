package com.jiehfut.restful.controller;


import com.jiehfut.restful.bean.Employee;
import com.jiehfut.restful.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        Collection<Employee> employeeList = employeeDao.getAll();
        // 在域对象中将数据从响应中传递到前端
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }


    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        // 从员工列表中删除根据ID查询到的员工
        employeeDao.delete(id);
        // 删除信息以后对前端进行回显操作（重定向）到列表页
        return "redirect:/employee";
    }




}
