package com.reverie.service;

import com.reverie.domain.User;
import com.reverie.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import tk.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.annotation.MapperScan;  此时的MapperScan应该是tk而不是org
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@MapperScan("com.reverie.mapper")
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Test
    public void selectAll(){
        User u=new User();
        u.setUsername("reverie");
        List<User> users = userMapper.select(u);
        System.out.println(users);
    }

    @Test
    public void selectById(){
        User user = userService.selectByUserName("reverie");
        System.out.println(user);
    }
}
