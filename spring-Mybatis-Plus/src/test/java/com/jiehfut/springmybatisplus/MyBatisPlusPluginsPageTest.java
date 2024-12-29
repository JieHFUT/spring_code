package com.jiehfut.springmybatisplus;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiehfut.springmybatisplus.mapper.UserMapper;
import com.jiehfut.springmybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPluginsPageTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPagePlugins(){
        // 测试分页插件的使用
        Page<User> page = new Page<>(2, 3); // 当前页码，每一页条数
        userMapper.selectPage(page, null); // 查询所有记录
        System.out.println(page);
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user
        // WHERE is_deleted=0 LIMIT ?,?
    }

    
}
