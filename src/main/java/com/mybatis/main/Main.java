package com.mybatis.main;

import com.mybatis.dao.inf.UserMapper;
import com.mybatis.model.Course;
import com.mybatis.model.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory;
        UserMapper userMapper;

        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = factory.openSession();
        userMapper = session.getMapper(UserMapper.class);
        Users users = userMapper.getUser(7);
        System.out.println("User id: " + " " + users.getId()+ " " + "User name: " + " " + users.getName());
        for (Course course:users.getCourseList()){
            System.out.println("Course id: " + " " + course.getId() + " " + "Course name: " + " " + course.getTitle());
        }
    }
}
