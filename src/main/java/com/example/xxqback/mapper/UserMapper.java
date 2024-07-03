package com.example.xxqback.mapper;

import com.example.xxqback.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO users(username, password, email, name) VALUES(#{username}, #{password}, #{email}, #{name})")
    void insertUser(User user);

    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);

}
