package com.jiehfut.mapper;

import com.jiehfut.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    /**
     * 查询所有的员工数据
     */
    List<Emp> findAllEmp();

}
