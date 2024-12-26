package com.jiehfut.springmybatisplus;


import com.jiehfut.springmybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testMybatisPlusTest(){
        // selectList()根据 MP 内置的条件构造器查询一个list集合，null表示没有条件（Wrapper<T>），即查询所有
        userMapper.selectList(null).forEach(System.out::println);
    }
    


}
