package com.jiehfut.springmybatisplusmultidatasource.pojo;


import lombok.Data;


@Data
public class User {

    private Integer uid;
    private String userName;
    private Integer age;
    private Integer sex;
    private String email;
    private Integer isDeleted;

}
