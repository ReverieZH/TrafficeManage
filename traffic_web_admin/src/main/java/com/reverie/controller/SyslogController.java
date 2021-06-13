package com.reverie.controller;


import com.reverie.domain.LayUI;
import com.reverie.domain.Platenumber;
import com.reverie.domain.Syslog;
import com.reverie.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/syslog")
@CrossOrigin
public class SyslogController {

    @Autowired
    private SyslogService syslogService;

    @RequestMapping("/main.do")
    public String getMainPage(HttpServletRequest request){
        return "syslogList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getPlateNumberList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Syslog> layUI=new LayUI();
        List<Syslog> syslogs = syslogService.selectAll();
        if(syslogs!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(syslogs.size());
            layUI.setData(syslogs);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/userlog.do")
    @ResponseBody
    public LayUI searchLogById(HttpServletRequest request, @RequestParam String jobnumber,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Syslog> layUI=new LayUI();
        List<Syslog> syslogs = syslogService.findByJobNumber(jobnumber);
        if(syslogs!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(syslogs.size());
            layUI.setData(syslogs);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }
}
