package com.jiehfut.tx;

import com.jiehfut.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * ClassName: TestBookTX
 * Package: com.jiehfut.tx
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/12/2 21:08
 * @Version 1.0
 */
@Component
@SpringJUnitConfig(locations = "classpath:bean-jdbc.xml")
public class TestBookTX {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(2, 1);
    }

    /**
     * 事务的属性
     * 1.只读：@Transactional(readOnly = true) => 表示只能进行查询，不能修改添加和删除
     *
     * 2.超时：@Transactional(timeout = 3) => 表示在设置的超时时长内没有完成操作就报异常
     *
     * 3.只读：@Transactional(...) => 可以设置哪些异常不进行回滚
     *
     * 4.隔离级别：
     *
     * 5.事务的传播行为：事务方法之间进行调用，事务如何使用
     */

}
