package com.jiehfut.tx.dao;

/**
 * ClassName: BookDao
 * Package: com.jiehfut.tx.dao
 * Description:
 *
 * @Author jieHFUT
 * @Create 2024/12/2 20:44
 * @Version 1.0
 */
public interface BookDao {
    Integer getBookPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateUserBalance(Integer userId, Integer price);
}
