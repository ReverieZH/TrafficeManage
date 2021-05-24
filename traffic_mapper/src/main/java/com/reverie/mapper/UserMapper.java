package com.reverie.mapper;

import com.reverie.domain.User;
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


}
