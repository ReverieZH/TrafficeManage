package com.reverie.mapper;


import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Operator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@MapperScan("com.reverie.mapper")
public class OperatorMapperTest {

    @Autowired
    private OperatorMapper operatorMapper;

    @Test
    public void login(){
        Operator operator= operatorMapper.loginSelect("20210407001");
        System.out.println(operator);
    }
}
