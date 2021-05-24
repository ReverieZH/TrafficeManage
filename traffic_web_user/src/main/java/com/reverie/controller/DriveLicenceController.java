package com.reverie.controller;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.LayUI;
import com.reverie.service.DriveLicenceService;
import com.reverie.service.DrivingLicenceBindingService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/drivingLicence")
@CrossOrigin
public class DriveLicenceController {
    @Autowired
    private DriveLicenceService driveLicenceService;

    @Autowired
    private DrivingLicenceBindingService drivingLicenceBindingService;

    @RequestMapping("/bind")
    @ResponseBody
    public Map<String,Object> bind(String dlNumber,String username)  {
        Map<String,Object> map=new HashMap<>();
        int count=drivingLicenceBindingService.selectCountByUser(username);
        if(count==0){
            int save = drivingLicenceBindingService.save(dlNumber, username);
            if(save>0){
                map.put("issuccess",true);
                map.put("message","绑定成功");
            }else{
                map.put("issuccess",false);
                map.put("message","绑定失败");
            }
            return map;
        }else{
            map.put("issuccess",false);
            map.put("message","不可重复绑定");
            return  map;
        }
    }

    @RequestMapping("/info")
    @ResponseBody
    public Map<String,Object> getInfo(String username){
        Map<String,Object> map=new HashMap<>();
        Drivinglicence drivinglicence=drivingLicenceBindingService.selectByUser(username);
        if(drivinglicence!=null){
            map.put("issuccess",true);
            map.put("drivingLicence",drivinglicence);
        }else{
            map.put("issuccess",false);
            map.put("message","未查询到驾驶证");
        }
        return map;
    }

}
