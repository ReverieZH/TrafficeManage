package com.reverie.controller;


import com.reverie.domain.Checkreservation;
import com.reverie.domain.LayUI;
import com.reverie.domain.Losereplace;
import com.reverie.service.LoseReplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/change")
public class ChangeDrivingLicenceController {

    @Autowired
    private LoseReplaceService loseReplaceService;


    @RequestMapping("/loseMain.do")
    public String loseMianPage(){
        return "loseReplaceList";
    }

    @RequestMapping("/losedatamain.do")
    @ResponseBody
    public LayUI dataList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Losereplace> layUI=new LayUI();
        List<Losereplace> losereplaces = loseReplaceService.selectAll();
        if(losereplaces!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(losereplaces.size());
            layUI.setData(losereplaces);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/loseApplying.do")
    @ResponseBody
    public LayUI loseApplyingList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Losereplace> layUI=new LayUI();
        List<Losereplace> losereplaces = loseReplaceService.selectApplying();
        if(losereplaces!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(losereplaces.size());
            layUI.setData(losereplaces);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/getLoseHandle.do")
    public String getHandle(HttpServletRequest request,String loseReplaceNumber){
        Losereplace losereplace = loseReplaceService.selectById(loseReplaceNumber);
        request.setAttribute("losereplace",losereplace);
        return "handleLoserReplace";
    }

    @RequestMapping("/loseHandle.do")
    @ResponseBody
    public String loseHandle(String loseReplaceNumber,String status){
        boolean isscuccess=false;
        int handle = loseReplaceService.handle(loseReplaceNumber, status);
        if(handle>0){
            isscuccess=true;
        }
        return String.valueOf(isscuccess);
    }
}
