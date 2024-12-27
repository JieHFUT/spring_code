package com.jiehfut.springmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehfut.springmybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
/**
 * 这个泛型<User>决定了从哪个表里面进行 sql 操作
 * 可以使用在实体类添加注解设置实体类对应的表名
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义根据 ID 来查询一条用户记录，返回一个 Map 集合
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);
}
