package com.jiehfut;

import com.jiehfut.mapper.DeptMapper;
import com.jiehfut.mapper.EmpMapper;
import com.jiehfut.pojo.Dept;
import com.jiehfut.pojo.Emp;
import com.jiehfut.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMBG {
    @Test
    public void testEmpMBG() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession();
        EmpMapper empMapper = session.getMapper(EmpMapper.class);

        // 1.测试查询所有数据
        List<Emp> empList = empMapper.selectByExample(null);
        for (Emp emp : empList) {
            System.out.println(emp);
        }
        System.out.println("===========================");
        // 2.根据条件查询
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("李四").andAgeLessThan(33);
        empExample.or().andDidIsNotNull();
        List<Emp> empList1 = empMapper.selectByExample(empExample);
        for (Emp emp : empList1) {
            System.out.println(emp);
        }
        // 3.修改数据
    }

    @Test
    public void testDeptMBG() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession();
        DeptMapper deptMapper = session.getMapper(DeptMapper.class);

        // 1.测试查询所有数据
        List<Dept> depts = deptMapper.selectByExample(null);
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        System.out.println("===========================");
        // 2.根据条件查询

        // 3.修改数据

    }



}
