package com.jiehfut;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    /**
     * 在配置分页功能之后
     * 只需要在使用查询功能之前开启分页功能即可
     * Page page = PageHelper.startPage(int pageNum, int pageSize)
     * pageNum : 页码
     * pageSize: 每一页多少条记录
     */
    public void testDeptMBG() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession();
        DeptMapper deptMapper = session.getMapper(DeptMapper.class);

        // 1.测试查询所有数据
        // 在使用查询数据之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);// 当前访问第一页，每一页访问四条数据
        List<Dept> depts = deptMapper.selectByExample(null);
        System.out.println(page);
        // Page 对象
        // Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=7, pages=2,
        // reasonable=false, pageSizeZero=false}[Dept{did=1, deptName='测试'}, Dept{did=2, deptName='开发'}, Dept{did=3, deptName='运营'}, Dept{did=4, deptName='运维'}]
        depts.forEach(dept -> System.out.println(dept));
        System.out.println("===========================");
        // 2.根据条件查询

        // 3.修改数据

    }



}
