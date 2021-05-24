package com.reverie.service;

import com.reverie.domain.Platenumber;
import com.reverie.domain.User;
import com.reverie.mapper.PlatenumberMapper;
import com.reverie.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

//import org.mybatis.spring.annotation.MapperScan;  此时的MapperScan应该是tk而不是org

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@MapperScan("com.reverie.mapper")
public class PlateNumberServiceTest {
    @Autowired
    private PlatenumberMapper platenumberMapper;
    @Autowired
    private PlateNumberService plateNumberService;
    @Test
    public void selectAll(){
        List<Platenumber> platenumbers = platenumberMapper.selectAll();
        System.out.println(platenumbers);
    }


}
