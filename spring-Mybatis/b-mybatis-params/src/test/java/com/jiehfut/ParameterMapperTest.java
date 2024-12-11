package com.jiehfut;

import com.jiehfut.mapper.ParameterMapper;
import com.jiehfut.pojo.User;
import com.jiehfut.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParameterMapperTest {

    @Test
    public void testGetAllUser(){
        // 简单封装工具类获取 SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> userList = parameterMapper.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * mybatis 获取参数的两种方法
     * ${} 本质是字符串拼接，可能会出现字符注入的问题
     * #{} 本质是占位符赋值
     *
     * mybatis 获取参数值的各种情况
     * 1.mapper 接口的参数为单个的字面量的类型
     *   可以通过 ${} #{} 以任意的字符串来获取参数值，但是要注意 '${}' 的单引号问题
     * 2.
     */

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
        User user = parameterMapper.getUserByName("admin");
        System.out.println(user);
    }





}
