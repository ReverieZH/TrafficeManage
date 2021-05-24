package com.reverie.controller;


import com.reverie.domain.Drivinglicence;
import com.reverie.domain.LayUI;
import com.reverie.domain.Platenumber;
import com.reverie.domain.Trafficoffence;
import com.reverie.service.TrafficOffenceService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/illegal")
public class IllegalController {

    @Autowired
    private TrafficOffenceService trafficOffenceService;


    @RequestMapping("/main.do")
    public String getMainPage(HttpServletRequest request){
        System.out.println("-----------------illegalmain-----------------");
        return "trafficOffenceList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getPlateNumberList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Trafficoffence> layUI=new LayUI();
        List<Trafficoffence> trafficoffences =trafficOffenceService.selectAll();
        if(trafficoffences!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(trafficoffences.size());
            layUI.setData(trafficoffences);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }


    @RequestMapping("/getaddTrafficOffence.do")
    public String getaddDriveLicence(HttpServletRequest request){
        return "addTrafficOffence";
    }


    @RequestMapping("/addTrafficOffence.do")
    @ResponseBody
    public String addDriveLicence(HttpServletRequest request,Trafficoffence trafficoffence,@RequestParam String trafficOffenceDateStr) throws ParseException {
        boolean issuccess =false;
        trafficoffence.setTrafficOffenceDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss",trafficOffenceDateStr));
        trafficoffence.setStatus("2");
        System.out.println(trafficoffence);
        int total = trafficOffenceService.save(trafficoffence);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }


    @RequestMapping("geteditTrafficOffence.do")
    public String geteditPlateNumber(HttpServletRequest request,@RequestParam("trafficOffenceNumber")String trafficOffenceNumber){
        Trafficoffence trafficoffence = trafficOffenceService.selectById(trafficOffenceNumber);
        request.setAttribute("trafficoffence",trafficoffence);
        return "editTrafficOffence";
    }


    @RequestMapping("/editTrafficOffence.do")
    @ResponseBody
    public String editPlateNumber(HttpServletRequest request,Trafficoffence trafficoffence,@RequestParam String trafficOffenceDateStr) throws ParseException {
        boolean issuccess =false;
        trafficoffence.setTrafficOffenceDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss",trafficOffenceDateStr));
        issuccess=trafficOffenceService.update(trafficoffence)>0?true:false;
        return String.valueOf(issuccess);
    }
}
