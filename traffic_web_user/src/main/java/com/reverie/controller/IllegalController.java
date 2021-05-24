package com.reverie.controller;


import com.reverie.domain.Trafficoffence;
import com.reverie.service.TrafficOffenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/illegal")
@CrossOrigin
public class IllegalController {

    @Autowired
    private TrafficOffenceService trafficOffenceService;


    @RequestMapping("/data")
    @ResponseBody
    public Map<String,Object> selectIllegalData(String plateNumber){
        Map<String,Object> map=new HashMap<>();
        List<Trafficoffence> trafficoffences =  trafficOffenceService.selectByCar(plateNumber);
        if(trafficoffences!=null){
            map.put("issuccess",true);
            map.put("trafficOffences",trafficoffences);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

    @RequestMapping("/info")
    @ResponseBody
    public Map<String,Object> viewInfo(String trafficOffenceNumber){
        Map<String,Object> map=new HashMap<>();
        Trafficoffence trafficoffence = trafficOffenceService.selectById(trafficOffenceNumber);
        if(trafficoffence!=null){
            map.put("issuccess",true);
            map.put("trafficOffence",trafficoffence);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

    @RequestMapping("/handle")
    @ResponseBody
    public Map<String,Object> handleIllegal(String username, int score, String trafficOffenceNumber,String status){
        System.out.println(username+" "+score+" "+trafficOffenceNumber+" "+status);
        Map<String,Object> map=new HashMap<>();
        boolean result = trafficOffenceService.handleIllegal(username, score, trafficOffenceNumber, status);
        map.put("issuccess",result);
        return map;
    }
}
