package com.reverie.controller;

import com.reverie.domain.LayUI;
import com.reverie.domain.Platenumber;
import com.reverie.domain.Platenumberapply;
import com.reverie.service.PlateNumberApplyService;
import com.reverie.service.PlateNumberService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/plateNumberApply")
public class PlateNumberApplyController {
    @Autowired
    private PlateNumberApplyService plateNumberApplyService;

    @RequestMapping("/main.do")
    public String getMainPage(HttpServletRequest request){
        return "plateNumberApplyList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getPlateNumberApplyList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Platenumberapply> layUI=new LayUI();
        List<Platenumberapply> platenumbers = plateNumberApplyService.selectAll();
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

    @RequestMapping("/selectdatamain.do")
    @ResponseBody
    public LayUI selectPlateNumberApplyList(HttpServletRequest request,String status, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Platenumberapply> layUI=new LayUI();
        List<Platenumberapply> platenumbers = plateNumberApplyService.selectCondiion(status);
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


    @RequestMapping("/gethandle.do")
    public String gethandle(HttpServletRequest request,String applyNumber){
        Platenumberapply platenumberapply=plateNumberApplyService.selectByKey(applyNumber);
        request.setAttribute("platenumberapply",platenumberapply);
        return "handlePlateNumberApply";
    }

    @RequestMapping("/handle.do")
    @ResponseBody
    public String handle(HttpServletRequest request,String applyNumber){
        System.out.println("applyNumber:"+applyNumber);
        boolean issuccess=false;
        int total=plateNumberApplyService.handle(applyNumber);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
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
    }*/

    @RequestMapping("/getaddPlateNumberApply.do")
    public String getaddPlateNumberApply(HttpServletRequest request){
        return "addPlateNumberApply";
    }


    @RequestMapping("/addPlateNumberApply.do")
    @ResponseBody
    public String addPlateNumberApply(HttpServletRequest request,Platenumberapply platenumberapply) throws ParseException {
        boolean issuccess =false;
        issuccess=plateNumberApplyService.save(platenumberapply)!=null?true:false;
        return String.valueOf(issuccess);
    }

  /*  @RequestMapping("changeStatus.do")
    @ResponseBody
    public String changeStatus(@RequestParam("plateNumber")String plateNumber,@RequestParam("status")String status){
        boolean issuccess=false;
        int total=plateNumberService.changeStatus(plateNumber,status);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }
*/
   /* @RequestMapping("geteditPlateNumber.do")
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
*/

}
