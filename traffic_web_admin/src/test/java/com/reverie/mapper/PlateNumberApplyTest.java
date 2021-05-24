package com.reverie.mapper;

import com.reverie.domain.Platenumber;
import com.reverie.utils.DateUtil;
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
public class PlateNumberApplyTest {
    @Autowired
    private PlatenumberapplyMapper platenumberapplyMapper;

    @Test
    public void selectMaxnumber(){
        String maxNumber = platenumberapplyMapper.getMaxNumber(DateUtil.getCurrentDateStr() + "%");
        System.out.println(maxNumber);
    }


}
