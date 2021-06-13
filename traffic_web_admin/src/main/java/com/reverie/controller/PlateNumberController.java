package com.reverie.controller;

import com.reverie.domain.LayUI;
import com.reverie.domain.Platenumber;
import com.reverie.service.PlateNumberService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/plateNumber")
@CrossOrigin
public class PlateNumberController {
    @Autowired
    private PlateNumberService plateNumberService;

    @RequestMapping("/main.do")
    public String getMainPage(HttpServletRequest request){
        return "plateNumberList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getPlateNumberList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Platenumber> layUI=new LayUI();
        List<Platenumber> platenumbers = plateNumberService.selectAll();
        if(platenumbers!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(platenumbers.size());
            layUI.setData(platenumbers);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/serachNumber.do")
    @ResponseBody
    public LayUI searchPlateNumberLike(HttpServletRequest request, @RequestParam() String plateNumber){
        LayUI<Platenumber> layUI=new LayUI();
        List<Platenumber> platenumbers = plateNumberService.findPlateNumberLike(plateNumber);
        if(platenumbers!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(platenumbers.size());
            layUI.setData(platenumbers);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public String add(){
        return "xixi";
    }

    @RequestMapping("/deleteList.do")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("plateNumber")List<String> palteNumberList){
        boolean issuccess=false;
        int total=plateNumberService.deleteList(palteNumberList);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("plateNumber")String palteNumber){
        boolean issuccess=false;
        int total=plateNumberService.delete(palteNumber);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("/getaddPlateNumber.do")
    public String getaddPlateNumber(HttpServletRequest request){
        return "addPlateNumber";
    }


    @RequestMapping("/addPlateNumber.do")
    @ResponseBody
    public String addPlateNumber(HttpServletRequest request,Platenumber platenumber) throws ParseException {
        boolean issuccess =false;
        System.out.println("=============="+platenumber);
        platenumber.setIssueDate(DateUtil.getSqlDateByFormatString("yyyy-MM-dd", DateUtil.getCurrentTime()));
        platenumber.setLocationName(platenumber.getProvince()+platenumber.getCity());
        issuccess=plateNumberService.save(platenumber)>0?true:false;
        return String.valueOf(issuccess);
    }

    @RequestMapping("changeStatus.do")
    @ResponseBody
    public String changeStatus(@RequestParam("plateNumber")String plateNumber,@RequestParam("status")String status){
        boolean issuccess=false;
        int total=plateNumberService.changeStatus(plateNumber,status);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("geteditPlateNumber.do")
    public String geteditPlateNumber(HttpServletRequest request,@RequestParam("plateNumber")String plateNumber){
        Platenumber platenumber = plateNumberService.selectByKey(plateNumber);
        request.setAttribute("PlateNumber",platenumber);
        return "editPlateNumber";
    }
    @RequestMapping("/editPlateNumber.do")
    @ResponseBody
    public String editPlateNumber(HttpServletRequest request,Platenumber platenumber) throws ParseException {
        boolean issuccess =false;
        issuccess=plateNumberService.update(platenumber)>0?true:false;
        return String.valueOf(issuccess);
    }


}
