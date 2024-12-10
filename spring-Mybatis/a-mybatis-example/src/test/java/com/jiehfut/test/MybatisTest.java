package com.jiehfut.test;

import com.jiehfut.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


public class MybatisTest {
    @Test
    public void testMybatis() throws IOException {
        // mybatis 为我们提供了一个 sqlsession 对象用于操作

        // 1.加载核心配置文件（以字节输入流获取）
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.获取 SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3.获取 SqlSessionFactory 对象
        SqlSessionFactory factory = builder.build(stream);
        // 4.获取 sqlsession 对象（代表 Java 程序和数据库之间的会话）
        SqlSession sqlSession = factory.openSession();

        // 5.我们传进去一个类的类型的时候，就返回一个该类的对象，可以帮助我们返回一个接口的实现类的对象，使用的是代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        int result = userMapper.insertUser();
        System.out.println("result = " + result);

        // 提交事务
        sqlSession.commit();
    }
}
