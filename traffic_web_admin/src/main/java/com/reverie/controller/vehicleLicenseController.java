package com.reverie.controller;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.LayUI;
import com.reverie.domain.Vehiclelicense;
import com.reverie.service.DriveLicenceService;
import com.reverie.service.VehiclelicenseService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vehiclelicense")
public class vehicleLicenseController {

    @Autowired
    private VehiclelicenseService vehiclelicenseService;

    @RequestMapping("/main.do")
    public String getMainPage(HttpServletRequest request){
        return "vehicleLicenceList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getVehicleLicenseList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Vehiclelicense> layUI=new LayUI();
        List<Vehiclelicense> vehiclelicenses =vehiclelicenseService .selectAll();
        if(vehiclelicenses!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(vehiclelicenses.size());
            layUI.setData(vehiclelicenses);
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
    public LayUI search(HttpServletRequest request,  @RequestParam String vlnumber){
        LayUI<Vehiclelicense> layUI=new LayUI();
        List<Vehiclelicense> vehiclelicenses=new ArrayList<>();
        Vehiclelicense vehiclelicense=vehiclelicenseService.selectByKey(vlnumber);
        vehiclelicenses.add(vehiclelicense);
        if(vehiclelicenses!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(vehiclelicenses.size());
            layUI.setData(vehiclelicenses);
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
        LayUI<Vehiclelicense> layUI=new LayUI();
        List<Vehiclelicense> vehiclelicenses=vehiclelicenseService.searchByName(name);
        if(vehiclelicenses!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(vehiclelicenses.size());
            layUI.setData(vehiclelicenses);
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
        int total=plateNumberService.deleteList(palteNumberList);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }*/

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(HttpServletRequest request, @RequestParam("vlnumber")String vlnumber){
        boolean issuccess=false;
        int total=vehiclelicenseService.delete(vlnumber);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("/getaddVehiclelicense.do")
    public String getaddDriveLicence(HttpServletRequest request){
        return "addVehicleLicence";
    }


    @RequestMapping("/addVehiclelicense.do")
    @ResponseBody
    public String addVehiclelicense(HttpServletRequest request,Vehiclelicense vehiclelicense) throws ParseException {
        boolean issuccess =false;
        vehiclelicense.setRegistationDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss",DateUtil.getCurrentTimeStr() ));
        vehiclelicense.setIssueDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss",DateUtil.getCurrentTimeStr() ));
        int total = vehiclelicenseService.save(vehiclelicense);
        if(total>0){
            issuccess=true;
        }
//        System.out.println(drivinglicence);
        return String.valueOf(issuccess);
    }

    @RequestMapping("changeStatus.do")
    @ResponseBody
    public String changeStatus(@RequestParam("vlnumber")String vlnumber,@RequestParam("status")String status){
        boolean issuccess=false;
        int total=vehiclelicenseService.changeStatus(vlnumber,status);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("geteditVehiclelicense.do")
    public String geteditDriveLicence(HttpServletRequest request,@RequestParam("vlnumber")String vlnumber){
        Vehiclelicense vehiclelicense = vehiclelicenseService.selectByKey(vlnumber);
        System.out.println(vehiclelicense);
        request.setAttribute("vehiclelicense",vehiclelicense);
        return "editVehiclelicense";
    }


    @RequestMapping("/editVehiclelicense.do")
    @ResponseBody
    public String editVehiclelicense(HttpServletRequest request,Vehiclelicense vehiclelicense) throws ParseException {
        boolean issuccess =false;
        int total = vehiclelicenseService.update(vehiclelicense);
        if(total>0){
            issuccess=true;
        }
//        System.out.println(drivinglicence);
        return String.valueOf(issuccess);
    }
}
