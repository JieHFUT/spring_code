package com.jiehfut.mapper;

import com.jiehfut.pojo.User;

import java.util.List;

public interface ParameterMapper {

    /**
     * 查询所有的员工信息集合2
     */
    List<User> getAllUsers();
    /**
     * 根据用户名查询用户信息
     */
    User getUserByName(String username);
}
