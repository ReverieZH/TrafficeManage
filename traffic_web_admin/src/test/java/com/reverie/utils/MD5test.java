package com.reverie.utils;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;
import tk.mybatis.spring.annotation.MapperScan;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@MapperScan("com.reverie.mapper")
public class MD5test {

    @Test
    public void getPassword(){
        String pass_md5 = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(pass_md5);
    }

}
