package com.reverie.controller;


import com.reverie.domain.Applyexemptedcheck;
import com.reverie.domain.Checkreservation;
import com.reverie.domain.LayUI;
import com.reverie.domain.Platenumberapply;
import com.reverie.service.CheckReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/checkReverse")
public class CheckReservationController {

    @Autowired
    private CheckReservationService checkReservationService;


    @RequestMapping("/main.do")
    public String getMainPage(){
        return "checkReverseList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI dataList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Checkreservation> layUI=new LayUI();
        List<Checkreservation> checkreservations = checkReservationService.selectAll();
        if(checkreservations!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(checkreservations.size());
            layUI.setData(checkreservations);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/applyingData.do")
    @ResponseBody
    public LayUI applyingList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Checkreservation> layUI=new LayUI();
        List<Checkreservation> checkreservations = checkReservationService.selectApplying();
        if(checkreservations!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(checkreservations.size());
            layUI.setData(checkreservations);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/search.do")
    @ResponseBody
    public LayUI search(HttpServletRequest request,  @RequestParam String reserveNumber){
        LayUI<Checkreservation> layUI=new LayUI();
        List<Checkreservation> checkreservations = checkReservationService.searchByReverseNumber(reserveNumber);
        if(checkreservations!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(checkreservations.size());
            layUI.setData(checkreservations);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/serachByUser.do")
    @ResponseBody
    public LayUI serachByUser(HttpServletRequest request,  @RequestParam String username){
        LayUI<Checkreservation> layUI=new LayUI();
        List<Checkreservation> checkreservations = checkReservationService.searchByUser(username);
        if(checkreservations!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(checkreservations.size());
            layUI.setData(checkreservations);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/getHandle.do")
    public String getHandle(HttpServletRequest request,String reserveNumber){
        Checkreservation checkreservation = checkReservationService.selecyById(reserveNumber);
        request.setAttribute("checkreservation",checkreservation);
        return "handleCheckReverse";
    }


    @RequestMapping("/handle.do")
    @ResponseBody
    public String handle(String reserveNumber,String status){
        boolean issuccess=false;
        int handle = checkReservationService.handle(reserveNumber, status);
        if(handle>0)
            issuccess=true;
        return String.valueOf(issuccess);
    }
}
