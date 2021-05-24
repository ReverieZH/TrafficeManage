package com.reverie.service;

import com.reverie.domain.Drivinglicence;
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
public class DriveLicenceServiceTest {
    @Autowired
    private DriveLicenceService driveLicenceService;

    @Test
    public void selcetAll(){

        List<Drivinglicence> drivinglicences = driveLicenceService.selectAll();
        System.out.println(drivinglicences);
    }
}
