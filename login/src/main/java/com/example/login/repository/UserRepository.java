package com.example.login.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.login.entity.User;

@Mapper
public interface UserRepository{

    @Select("select * frojm user")
    List<User> findAll();

    @Select("select * from user where userId=#{userId}")
    public User findById(String userId);
}
