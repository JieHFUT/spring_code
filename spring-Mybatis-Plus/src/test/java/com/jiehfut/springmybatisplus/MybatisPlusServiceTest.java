package com.jiehfut.springmybatisplus;


import com.jiehfut.springmybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusServiceTest {
    @Autowired
    private UserService userService;
    
    @Test // 查询表中的总的记录数
    public void testAllCount(){
        long count = userService.count();
        System.out.println("count = " + count);
        // SELECT COUNT( * ) AS total FROM user
    }

    @Test
    public void test(){
        
    }

}
