package com.reverie.utils;

import com.reverie.mapper.DrivinglicenceMapper;
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
public class StringUtilTest {

    @Autowired
    private DrivinglicenceMapper drivinglicenceMapper;
    @Test
    public void testMaxNum(){
        String maxNumber = drivinglicenceMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
//        String maxNumber = drivinglicenceMapper.getMaxNumber("20210409"+"%");
        if(maxNumber!=null){
            String maxNum = StringUtil.getMaxNum(maxNumber);
            System.out.println(maxNum);
        }else{
            System.out.println("001");
        }
    }

    @Test
    public void testNumber(){
        int num=2;
//三位，不足左侧补零
        String str = String.format("{0:d3}",num);
        System.out.println(str);
    }
}
