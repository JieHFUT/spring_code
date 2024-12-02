package com.jiehfut.tx.service.impl;

import com.jiehfut.tx.dao.BookDao;
import com.jiehfut.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: BookServiceImpl
 * Package: com.jiehfut.tx.service.impl
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/12/2 20:45
 * @Version 1.0
 */

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDao bookDao;

    @Transactional // 该注解表示对该方法添加事务，只会影响当前方法，也可以将该注解添加到类上面，可以对整个类的方法都添加事务
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 根据图书的 id 来查询图书的价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        // 更新图书表的库存量
        bookDao.updateStock(bookId);
        // 更新用户表的用户余额
        bookDao.updateUserBalance(userId, price);
    }




/*
    @Transactional // 该注解表示对该方法添加事务，只会影响当前方法，也可以将该注解添加到类上面，可以对整个类的方法都添加事务
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 根据图书的 id 来查询图书的价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        // 更新图书表的库存量
        bookDao.updateStock(bookId);
        // 更新用户表的用户余额
        bookDao.updateUserBalance(userId, price);
    }



    @Transactional(readOnly = true)  // 表示只能读数据，不能改数据，报错（Connection is read-only. Queries leading to data modification are not allowed）
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 根据图书的 id 来查询图书的价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        // 更新图书表的库存量
        bookDao.updateStock(bookId);
        // 更新用户表的用户余额
        bookDao.updateUserBalance(userId, price);
    }




    @Transactional(timeout = 3)  // 表示操作不能超时，否则报异常（TransactionTimedOutException: Transaction timed out）
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // TODO:模拟超时
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 根据图书的 id 来查询图书的价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        // 更新图书表的库存量
        bookDao.updateStock(bookId);
        // 更新用户表的用户余额
        bookDao.updateUserBalance(userId, price);
    }



    @Transactional(noRollbackFor = ArithmeticException.class)  // 表示出现设置的异常信息，不会进行回滚操作
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 根据图书的 id 来查询图书的价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        // 更新图书表的库存量
        bookDao.updateStock(bookId);
        // 更新用户表的用户余额
        bookDao.updateUserBalance(userId, price);
    }


    事务的隔离级别：
    如果对事务不考虑隔离性，会产生 3 种读的问题
    1.脏读：两个事务都没有提交，但是两个事务互相改数据，两个事务都能看到，导致脏读（读取到未提交的数据）
    2.不可重复读：一个事务没有提交，另外一个事务修改之后已经提交了，没有提交的事务能够读到另外一个事务修改之后提交的数据
    3.幻读：确保一个事务可以多次从一个字段中读取到相同的值，即一个事务执行期间禁止其它事务对这个字段进行更新。

    事务的隔离级别‌是数据库管理系统（DBMS）中用于控制不同事务之间相互影响的一种机制，
    确保在并发环境下数据的一致性和可靠性。事务隔离级别主要有四种，每种级别都提供不同的隔离水平：‌

    1.读未提交（Read Uncommitted）‌：这是最低的隔离级别，允许一个事务读取另一个事务未提交的数据。
    这可能导致脏读（读取到未提交的数据）、不可重复读（同一查询在不同时间点返回不同结果）和幻读（读取到其他事务插入的数据）问题。
    2.读已提交（Read Committed）‌：允许一个事务只能读取已经提交的其他事务的数据。这解决了脏读的问题，但仍可能存在不可重复读和幻读的问题。
    ‌可重复读（Repeatable Read）‌：保证一个事务在执行期间多次读取相同的数据时，其结果是一致的。它解决了不可重复读的问题，但仍可能存在幻读的问题。
    3.串行化（Serializable）‌：提供最高的隔离级别，通过强制事务串行执行来解决所有并发问题，包括脏读、不可重复读和幻读。
    虽然能够确保数据的完全一致性，但也导致了性能上的损失，因为事务需要等待其他事务释放锁。



    @Transactional(isolation = Isolation.DEFAULT)  // 设置事务的隔离级别
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 根据图书的 id 来查询图书的价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        // 更新图书表的库存量
        bookDao.updateStock(bookId);
        // 更新用户表的用户余额
        bookDao.updateUserBalance(userId, price);
    }
*/


}
