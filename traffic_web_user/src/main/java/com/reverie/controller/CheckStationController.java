package com.reverie.controller;


import com.reverie.domain.Checkstation;
import com.reverie.domain.Vechileadminoffice;
import com.reverie.service.CheckStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/checkStaion")
@CrossOrigin
public class CheckStationController {

    @Autowired
    private CheckStationService checkStationService;


    @RequestMapping("/data")
    @ResponseBody
    public Map<String,Object> getdata(String province){
        Map<String,Object> map=new HashMap<>();
        List<Checkstation> checkstations = checkStationService.selectByProvince(province);
        if(checkstations.size()>0){
            map.put("checkstations",checkstations);
            map.put("issuccess",1);
        }else{
            map.put("issuccess",0);
        }
        return map;
    }
}
