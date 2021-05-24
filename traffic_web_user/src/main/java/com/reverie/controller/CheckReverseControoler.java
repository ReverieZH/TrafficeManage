package com.reverie.controller;


import com.reverie.domain.Checkreservation;
import com.reverie.mapper.CheckreservationMapper;
import com.reverie.service.CheckReservationService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/checkReverse")
@CrossOrigin
public class CheckReverseControoler {

    @Autowired
    private CheckReservationService checkReservationService;

    @RequestMapping("/data")
    @ResponseBody
    public Map<String,Object>  getdataList(){
        Map<String,Object> map=new HashMap<>();


        return map;
    }

    @RequestMapping("/apply")
    @ResponseBody
    public Map<String,Object> apply(Checkreservation checkreservation,String checkDateStr) throws ParseException {
        Map<String,Object> map=new HashMap<>();
        checkreservation.setReserveDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss", DateUtil.getCurrentTime()));
        checkreservation.setCheckDate(DateUtil.getDateByFormatString("yyyy-MM-dd",checkDateStr));
        checkreservation.setStatus("2");
        System.out.println(checkreservation);
        String reserveNumber = checkReservationService.save(checkreservation);
        if(reserveNumber!=null){
            map.put("issuccess",true);
            map.put("reserveNumber",reserveNumber);
        }else{
            map.put("issuccess",false);
        }

        return map;
    }

    @RequestMapping("/select")
    @ResponseBody
    public Map<String,Object> selectByUsername(String username){
        Map<String,Object> map=new HashMap<>();
        List<Checkreservation> checkreservations = checkReservationService.selectByUsername(username);
        if(checkreservations!=null){
            map.put("issuccess",true);
            map.put("checkreservations",checkreservations);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

}
