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

    /**
     * 使一级缓存失效的四种办法
     *
     * 1) 不同的SqlSession对应不同的一级缓存
     * 2) 同一个SqlSession但是查询条件不同
     * 3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 4) 同一个SqlSession两次查询期间手动清空了缓存
     *
     * 也可以使用 sqlSession.clearChace() 清空一级缓存
     */
    @Test
    public void testCacheInsert() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        CacheMapper cacheMapper = session.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper.getEmpById(2);
        System.out.println(emp1);
        // 两次查询之间进行了插入
        Emp emp = new Emp(null, "dqwe", 21, "男", "3241@wef.com", null);
        cacheMapper.insertEmp(emp);
        // 一级缓存就会被清空
        Emp emp2 = cacheMapper.getEmpById(2);
        System.out.println(emp2);
        /**
         * DEBUG 12-12 17:37:46,220 ==>  Preparing: select * from t_emp where eid = ?  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:37:46,268 ==> Parameters: 2(Integer)  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:37:46,317 <==      Total: 1  (BaseJdbcLogger.java:137)
         * Emp(eid=2, empName=null, age=32, sex=男, email=42529@163.com, dept=null)
         * DEBUG 12-12 17:37:46,335 ==>  Preparing: insert into t_emp values (null, ?, ?, ?, ?, null)  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:37:46,337 ==> Parameters: dqwe(String), 21(Integer), 男(String), 3241@wef.com(String)  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:37:46,352 <==    Updates: 1  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:37:46,353 ==>  Preparing: select * from t_emp where eid = ?  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:37:46,353 ==> Parameters: 2(Integer)  (BaseJdbcLogger.java:137)
         * DEBUG 12-12 17:37:46,356 <==      Total: 1  (BaseJdbcLogger.java:137)
         * Emp(eid=2, empName=null, age=32, sex=男, email=42529@163.com, dept=null)
         *
         * 可见任意的一次增删改之后就会清空一级缓存
         */
    }






}
