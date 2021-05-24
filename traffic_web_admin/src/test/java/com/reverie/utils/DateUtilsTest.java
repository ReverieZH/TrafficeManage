package com.reverie.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@MapperScan("com.reverie.mapper")
public class DateUtilsTest {

    @Test
    public void testDate(){
        String afterDate = DateUtil.getBeforeAfterDate(DateUtil.getCurrentTimeStr(), 5);
        System.out.println(afterDate);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    }
    @Test
    public void testDate2(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date olddate = null;
        String time=df.format(new Date().getTime());
        try {
            System.out.println(df.parse("2021-04-09 17:45:00").getTime());
            df.setLenient(false);
//            olddate = new java.util.Date(df.parse("2021-04-09").getTime());
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误");
        }
    }

    @Test
    public void testDate3(){
        String currentTime = DateUtil.getCurrentDateStr();
        System.out.println(currentTime);
    }
}
