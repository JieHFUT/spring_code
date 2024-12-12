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
         *
         * 可见 mybatis 的一级缓存是默认开启的，级别是 SqlSession 的
         */
    }


    @Test
    public void testCacheNew(){
        SqlSession session1 = SqlSessionUtil.getSqlSession();
        CacheMapper cacheMapper = session1.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper.getEmpById(2);
        System.out.println(emp1);
        Emp emp2 = cacheMapper.getEmpById(2);
        System.out.println(emp2);

        SqlSession session2 = SqlSessionUtil.getSqlSession();
        CacheMapper cacheMapper2 = session2.getMapper(CacheMapper.class);
        Emp emp3 = cacheMapper2.getEmpById(2);
        System.out.println(emp3);

        /**
         * DEBUG 12-12 17:26:24,433 ==>  Preparing: select * from t_emp where eid = ?  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:26:24,481 ==> Parameters: 2(Integer)  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:26:24,528 <==      Total: 1  (BaseJdbcLogger.java:137)
         * Emp(eid=2, empName=null, age=32, sex=男, email=42529@163.com, dept=null)
         * Emp(eid=2, empName=null, age=32, sex=男, email=42529@163.com, dept=null)
         * DEBUG 12-12 17:26:24,632 ==>  Preparing: select * from t_emp where eid = ?  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:26:24,633 ==> Parameters: 2(Integer)  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:26:24,636 <==      Total: 1  (BaseJdbcLogger.java:137)
         * Emp(eid=2, empName=null, age=32, sex=男, email=42529@163.com, dept=null)
         *
         *
         * 可见 mybatis 的一级缓存是默认开启的，级别是 SqlSession 的
         * 当通过不同的 SqlSession 进行查询的时候，就会执行不同的查询
         */
    }




}
