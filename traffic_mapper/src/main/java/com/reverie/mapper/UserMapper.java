package com.reverie.mapper;

import com.reverie.domain.Syslog;
import com.reverie.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User> {

    @Select("select * from user where username=#{username}")
    public User selectByUserName(String username);

    @Select("select * from user")
    public List<User> selectAll();

    @Select("select * from user where username like #{username}")
    @Results({
            @Result(column = "username",property = "username",id = true),
            @Result(column = "password",property = "password"),
            @Result(column = "certificatetype",property = "certificatetype"),
            @Result(column = "certificatenumber",property = "certificatenumber"),
            @Result(column = "phonenumber",property = "phonenumber"),
            @Result(column = "valid",property = "valid"),
            @Result(column = "type",property = "type"),
    })
    public List<User> findUsernameLike(String username);

}
