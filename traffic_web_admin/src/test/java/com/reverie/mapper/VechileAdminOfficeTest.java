package com.reverie.mapper;


import com.reverie.domain.Vechileadminoffice;
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
public class VechileAdminOfficeTest {

    @Autowired
    private VechildAdminOfficeMapper vechildAdminOfficeMapper;

    @Test
    public void testAll(){
        List<Vechileadminoffice> vechileadminoffices = vechildAdminOfficeMapper.selectAll();
        Vechileadminoffice vechileadminoffice=new Vechileadminoffice();
        vechileadminoffice.setProvince("sx");
        vechileadminoffice.setCity("hz");
        List<Vechileadminoffice> select = vechildAdminOfficeMapper.select(vechileadminoffice);
        System.out.println(vechileadminoffices);
        System.out.println(select);
    }
}
