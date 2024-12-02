package com.jiehfut.tx.service.impl;

import com.jiehfut.tx.dao.BookDao;
import com.jiehfut.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
