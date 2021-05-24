package com.reverie.mapper;

import com.reverie.domain.Userplateapply;
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
public class UserPlateApplyTest {
    @Autowired
    private UserPlateApplyMapper userPlateApplyMapper;

    @Test
    public void selectInfo(){
        Userplateapply userPlateApply = userPlateApplyMapper.selectPalteApply("rtest");
        System.out.println(userPlateApply);
    }


}
