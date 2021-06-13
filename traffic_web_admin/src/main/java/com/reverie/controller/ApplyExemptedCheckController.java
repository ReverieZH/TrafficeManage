package com.reverie.controller;


import com.reverie.domain.Applyexemptedcheck;
import com.reverie.domain.Car;
import com.reverie.domain.LayUI;
import com.reverie.domain.Platenumberapply;
import com.reverie.service.ApplyExemptedCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exemptCheck")
public class ApplyExemptedCheckController {

    @Autowired
    private ApplyExemptedCheckService applyExemptedCheckService;

    @RequestMapping("/main.do")
    public String getMainPage(HttpServletRequest request){
        return "exemptedCheckList";
    }

    @RequestMapping("/data.do")
    @ResponseBody
    public LayUI dataList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        System.out.println("-----------------------------");
        LayUI<Applyexemptedcheck> layUI=new LayUI();
        List<Applyexemptedcheck> applyexemptedchecks = applyExemptedCheckService.selctAll();
        System.out.println(applyexemptedchecks);
        if(applyexemptedchecks!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(applyexemptedchecks.size());
            layUI.setData(applyexemptedchecks);
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
        LayUI<Applyexemptedcheck> layUI=new LayUI();
        List<Applyexemptedcheck> applyexemptedchecks = applyExemptedCheckService.selectCondiion(status);
        if(applyexemptedchecks!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(applyexemptedchecks.size());
            layUI.setData(applyexemptedchecks);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }
    @RequestMapping("/getinfo.do")
    public String getinfo(HttpServletRequest request,String acNumber){
        Applyexemptedcheck applyexemptedcheck = applyExemptedCheckService.selectoneById(acNumber);
        System.out.println(applyexemptedcheck);
        request.setAttribute("applyexemptedcheck",applyexemptedcheck);
        return "acceptexemptedCheck";
    }

    @RequestMapping("/accerpt.do")
    @ResponseBody
    public String accerpt(String acNumber,String status){
        boolean issccuess=false;
        int accpet = applyExemptedCheckService.accpet(acNumber, status);
        if (accpet>0){
            issccuess=true;
        }
        return String.valueOf(issccuess);
    }

}
