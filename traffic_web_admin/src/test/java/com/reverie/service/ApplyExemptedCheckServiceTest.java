package com.reverie.service;

import com.reverie.domain.Applyexemptedcheck;
import com.reverie.mapper.ApplyExemptedCheckMapper;
import com.reverie.service.ApplyExemptedCheckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@MapperScan("com.reverie.mapper")
public class ApplyExemptedCheckServiceTest {
//    @Autowired
//    private ApplyExemptedCheckService applyExemptedCheckService;

    @Autowired
    private ApplyExemptedCheckMapper applyExemptedCheckMapper;

    @Autowired
    private ApplyExemptedCheckService applyExemptedCheckService;

    @Test
    public void testById(){
        List<Applyexemptedcheck> applyexemptedchecks = applyExemptedCheckService.selctAll();
        System.out.println(applyexemptedchecks);
        /*Applyexemptedcheck applyexemptedcheck=new Applyexemptedcheck();
        applyexemptedcheck.setAcNumber("20210519001");
        Applyexemptedcheck result=applyExemptedCheckMapper.selectByPrimaryKey("20210519001");
        System.out.println(result);*/
    }
}
