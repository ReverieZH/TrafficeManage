package com.reverie.controller;


import com.reverie.domain.Car;
import com.reverie.domain.Uservehcile;
import com.reverie.service.UserVehcileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    private UserVehcileService userVehcileService;

    @RequestMapping("/bind")
    @ResponseBody
    public  Map<String,Object> bind(String plateNumber,String username){
        Map<String,Object> map=new HashMap<>();
        try {
            userVehcileService.bind(username,plateNumber);
            map.put("issuccess",true);
            map.put("message","成功");
            return map;
        } catch (Exception e) {
            map.put("issuccess",false);
            map.put("message","绑定失败未找到机动车");
        }
        return map;
    }

    @RequestMapping("/userVehicle")
    @ResponseBody
    public Map<String,Object> userVehicle(String username){
        Map<String,Object> map=new HashMap<>();
        List<Car> cars = userVehcileService.selectCarByUser(username);
        if(cars!=null){
            map.put("issuccess",true);
            map.put("cars",cars);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }
}
