package com.jiehfut.resource.dao.impl;

import com.jiehfut.resource.dao.UserDao;
import org.springframework.stereotype.Repository;


@Repository("myUserDaoy")
public class UserDaoImplY implements UserDao {
    @Override
    public void insertUser() {
        System.out.println("userdao-y...");
    }
}