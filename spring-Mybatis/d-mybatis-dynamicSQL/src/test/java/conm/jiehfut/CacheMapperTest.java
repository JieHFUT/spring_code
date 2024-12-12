package conm.jiehfut;

import com.jiehfut.mapper.CacheMapper;
import com.jiehfut.pojo.Emp;
import com.jiehfut.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class CacheMapperTest {

    @Test
    public void testCache(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        CacheMapper cacheMapper = session.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper.getEmpById(2);
        System.out.println(emp1);
        Emp emp2 = cacheMapper.getEmpById(2);
        System.out.println(emp2);

        /**
         * DEBUG 12-12 17:20:59,544 ==>  Preparing: select * from t_emp where eid = ?  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:20:59,589 ==> Parameters: 2(Integer)  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:20:59,637 <==      Total: 1  (BaseJdbcLogger.java:137)
         * Emp(eid=2, empName=null, age=32, sex=男, email=42529@163.com, dept=null)
         * Emp(eid=2, empName=null, age=32, sex=男, email=42529@163.com, dept=null)
         */
    }



}
