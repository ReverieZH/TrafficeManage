package com.reverie.service;


import com.reverie.domain.Car;
import com.reverie.mapper.UserVehcileMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@MapperScan("com.reverie.mapper")
public class UserVehicleTest {
    @Autowired
    private UserVehcileService userVehcileService;
    @Autowired
    private UserVehcileMapper userVehcileMapper;

    @Test
    public void insert(){
        try {
            int bind = userVehcileService.bind("reverie", "陕F8688");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("------------------"+"绑定失败");
        }

    }

    @Test
    public void select(){
        List<Car> cars = userVehcileMapper.selectCarByUser("reverie");
        System.out.println(cars);

    }

}
