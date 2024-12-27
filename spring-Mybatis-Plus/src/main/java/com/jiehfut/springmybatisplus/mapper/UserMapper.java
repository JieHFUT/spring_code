package com.jiehfut.springmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiehfut.springmybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义根据 ID 来查询一条用户记录，返回一个 Map 集合
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);
}
