package com.mybatis.dao.inf;

import com.mybatis.model.Users;

import java.util.List;

public interface UserMapper {

    Users getUser(int id);
    List<Users> getListUser();
    void insertUsers(String name);
    void insertCourse(String title);
}
