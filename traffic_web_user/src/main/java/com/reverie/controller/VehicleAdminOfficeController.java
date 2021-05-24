package com.reverie.controller;


import com.reverie.domain.Vechileadminoffice;
import com.reverie.service.VechildAdminOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vehicleAdmin")
@CrossOrigin
public class VehicleAdminOfficeController {

    @Autowired
    private VechildAdminOfficeService vechildAdminOfficeService;


    @RequestMapping("/data")
    @ResponseBody
    public Map<String,Object> selectByProince(String province){
        System.out.println("province:"+province);
        Map<String,Object> map=new HashMap<>();
        List<Vechileadminoffice> vechileadminoffices = vechildAdminOfficeService.selectByProvince(province);
        System.out.println(vechileadminoffices);
        if(vechileadminoffices.size()>0){
            map.put("data",vechileadminoffices);
            map.put("success",1);
        }else{
            map.put("success",0);
        }
        return map;
    }

    @RequestMapping("/getNumberHead")
    @ResponseBody
    public String getNumberHead(String province,String city){
        Vechileadminoffice vechileadminoffice=new Vechileadminoffice();
        vechileadminoffice.setProvince(province);
        vechileadminoffice.setCity(city);
        Vechileadminoffice select = vechildAdminOfficeService.select(vechileadminoffice);
        return select.getOptionalPlateHead();
    }


}
