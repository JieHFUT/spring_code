package com.jiehfut.mapper;

import com.jiehfut.pojo.Emp;
import com.jiehfut.pojo.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Sat Dec 14 22:52:27 CST 2024
     */
    int countByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Sat Dec 14 22:52:27 CST 2024
     */
    int deleteByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Sat Dec 14 22:52:27 CST 2024
     */
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Sat Dec 14 22:52:27 CST 2024
     */
    int insertSelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Sat Dec 14 22:52:27 CST 2024
     */
    List<Emp> selectByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Sat Dec 14 22:52:27 CST 2024
     */
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Sat Dec 14 22:52:27 CST 2024
     */
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);
}