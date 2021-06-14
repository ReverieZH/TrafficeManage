package com.reverie.controller;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.LayUI;
import com.reverie.service.DriveLicenceService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/driveLicence")
public class driveLicenceController {
    @Autowired
    private DriveLicenceService driveLicenceService;

    @RequestMapping("/main.do")
    public String getMainPage(HttpServletRequest request){
        System.out.println("---------------------------------------------------------------------");
        return "driveLicenceList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getPlateNumberList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Drivinglicence> layUI=new LayUI();
        List<Drivinglicence> drivinglicences =driveLicenceService .selectAll();
        if(drivinglicences!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(drivinglicences.size());
            layUI.setData(drivinglicences);
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
    public LayUI search(HttpServletRequest request,  @RequestParam String dlnumber){
        LayUI<Drivinglicence> layUI=new LayUI();
        List<Drivinglicence> drivinglicences=new ArrayList<>();
        Drivinglicence drivinglicence=driveLicenceService.selectByKey(dlnumber);
        drivinglicences.add(drivinglicence);
        if(drivinglicences!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(drivinglicences.size());
            layUI.setData(drivinglicences);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/searchByName.do")
    @ResponseBody
    public LayUI searchByName(HttpServletRequest request,  @RequestParam String name){
        LayUI<Drivinglicence> layUI=new LayUI();
        List<Drivinglicence> drivinglicences=driveLicenceService.searchByName(name);
        if(drivinglicences!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(drivinglicences.size());
            layUI.setData(drivinglicences);
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

   /* @RequestMapping("/deleteList.do")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("plateNumber")List<String> palteNumberList){
        boolean issuccess=false;
        int total=driveLicenceService.deleteList(palteNumberList);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }*/

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("dlnumber")String dlnumber){
        boolean issuccess=false;
        int total=driveLicenceService.delete(dlnumber);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("/getaddDriveLicence.do")
    public String getaddDriveLicence(HttpServletRequest request){
        return "addDriveLicence";
    }


    @RequestMapping("/addDriveLicence.do")
    @ResponseBody
    public String addDriveLicence(HttpServletRequest request,Drivinglicence drivinglicence,@RequestParam String birthDate) throws ParseException {
        boolean issuccess =false;
        drivinglicence.setBirth(DateUtil.getDateByFormatString("yyyy-MM-dd",birthDate));
        drivinglicence.setStartDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss",DateUtil.getCurrentTimeStr() ));
        drivinglicence.setFirstDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss",DateUtil.getCurrentTimeStr() ));

        drivinglicence.setEndDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss",DateUtil.getBeforeAfterDate(DateUtil.getCurrentTimeStr(),5) ));
        int total = driveLicenceService.save(drivinglicence);
        if(total>0){
            issuccess=true;
        }
//        System.out.println(drivinglicence);
        return String.valueOf(issuccess);
    }

    @RequestMapping("changeStatus.do")
    @ResponseBody
    public String changeStatus(@RequestParam("dlnumber")String dlnumber,@RequestParam("status")String status){
        boolean issuccess=false;
        int total=driveLicenceService.changeStatus(dlnumber,status);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("geteditDriveLicence.do")
    public String geteditDriveLicence(HttpServletRequest request,@RequestParam("dlnumber")String dlnumber){
        Drivinglicence drivinglicence = driveLicenceService.selectByKey(dlnumber);
        request.setAttribute("drivinglicence",drivinglicence);
        return "editDrivelicence";
    }


    @RequestMapping("/editDriveLicence.do")
    @ResponseBody
    public String editDriveLicence(HttpServletRequest request,Drivinglicence drivinglicence) throws ParseException {
        boolean issuccess =false;
        System.out.println(drivinglicence);
        int total = driveLicenceService.update(drivinglicence);
        if(total>0){
            issuccess=true;
        }
//        System.out.println(drivinglicence);
        return String.valueOf(issuccess);
    }
}
