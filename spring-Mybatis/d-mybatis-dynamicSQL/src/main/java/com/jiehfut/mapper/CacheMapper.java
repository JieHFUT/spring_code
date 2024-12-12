package com.jiehfut.mapper;

import com.jiehfut.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    /**
     * 测试缓存
     */
    Emp getEmpById(@Param("eid")Integer eid);


}
