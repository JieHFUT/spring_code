package com.jiehfut.springmybatisplus;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiehfut.springmybatisplus.mapper.UserMapper;
import com.jiehfut.springmybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusWrapperTest {

    /**
     * 进行条件查询
     * 将查询条件组装进入查询语句中
     * 需要注意的是这里的属性名字需要写数据库中的字段名称
     */

    @Autowired
    UserMapper userMapper;

    @Test // 组装查询条件
    public void testSelectList(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 用户名包含 a，年龄在 10-40 之间，邮箱信息不为 null
        queryWrapper.like("user_name", "a")
                        .between("age", 10, 40)
                        .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0
        // AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
    }

    @Test // 测试排序条件
    public void testOrderBy(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 先按照年龄进行降序排序，如果年龄相同就按照 id 进行升序排序
        userQueryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
    }


    @Test // 测试删除方法将条件装载进查询中
    public void testDelete(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 删除邮箱地址为 null 的用户信息
        userQueryWrapper.isNull("email");
        int delete = userMapper.delete(userQueryWrapper);
        System.out.println("delete = " + delete);
        // UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
    }



    @Test // 测试修改
    public void testUpdate(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        userQueryWrapper.gt("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        // 修改数据
        User user = new User();
        user.setName("dahuang");
        int update = userMapper.update(user, userQueryWrapper);
        System.out.println("update = " + update);
        // UPDATE t_user SET user_name=?
        // WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR email IS NULL)
    }




    @Test // 条件的优先级
    public void testPriority(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        // lambda 表达式中的条件优先执行
        userQueryWrapper.like("user_name", "a")
                // and 中填写条件构造器
                // 注意 lambda 表达式中的条件会优先执行
                .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("xiaomin");
        int update = userMapper.update(user, userQueryWrapper);
        System.out.println("update = " + update);
        // UPDATE t_user SET user_name=?
        // WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
    }



    @Test // 测试只查询一些相关字段
    public void testSomeColmn(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 查询用户的用户名，年龄，邮箱
        userQueryWrapper.select("user_name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
        // SELECT user_name,age,email FROM t_user WHERE is_deleted=0
    }








}
