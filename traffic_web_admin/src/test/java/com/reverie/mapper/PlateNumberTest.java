package com.reverie.mapper;

import com.reverie.domain.Platenumber;
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
public class PlateNumberTest {
    @Autowired
    private PlatenumberMapper platenumberMapper;

    @Test
    public void selectById(){
        Platenumber platenumber = platenumberMapper.selectByPrimaryKey("Y3213");
        System.out.println(platenumber);
    }


}
