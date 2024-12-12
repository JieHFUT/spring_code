package conm.jiehfut;

import com.jiehfut.mapper.DynamicSQLMapper;
import com.jiehfut.pojo.Emp;
import com.jiehfut.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DynamicSQLTest {
    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 32, "", "234y12@qq.com", null);
        List<Emp> empList = dynamicSQLMapper.getEmpByCondition(emp);
        for (Emp emp1 : empList) {
            System.out.println(emp1);
        }
    }

    @Test
    // 使用 choose when otherwise
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 32, "男", "234y12@qq.com", null);
        List<Emp> empList = dynamicSQLMapper.getEmpByChoose(emp);
        for (Emp emp1 : empList) {
            System.out.println(emp1);
        }
        // select * from t_emp WHERE age = ?
    }



    @Test
    // 使用数组进行批量删除
    public void testMoreByArray(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int i = dynamicSQLMapper.deleteMoreByArray(new Integer[]{6, 7, 9, 10, 11});
        System.out.println("i = " + i);
    }











}
