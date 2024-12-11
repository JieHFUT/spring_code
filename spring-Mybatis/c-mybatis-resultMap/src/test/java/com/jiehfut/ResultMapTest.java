package com.jiehfut;

import com.jiehfut.mapper.EmpMapper;
import com.jiehfut.pojo.Emp;
import com.jiehfut.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultMapTest {

    @Test
    public void testAllEmp(){
        // 找不到对应属性的字段，不会为其赋值
        SqlSession session = SqlSessionUtil.getSqlSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.findAllEmp();
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }




}
