package com.reverie.controller;

import com.reverie.domain.Operator;
import com.reverie.mapper.OperatorMapper;
import com.reverie.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manage")
public class MainController {
    @Autowired
    private OperatorMapper operatorMapper;
    @Autowired
    private OperatorService operatorService;



    @RequestMapping("/main.do")
    public String manageMain(HttpServletRequest request){
        String jobNumber= SecurityContextHolder.getContext().getAuthentication().getName();
        Operator operator = operatorMapper.loginSelect(jobNumber);
        String rid= String.valueOf(operator.getRid());
        request.getSession().setAttribute("rid",rid);
        System.out.println("------------rid-----------"+rid);
        if(rid.equals("1")||rid.equals("2")){
            return "manage_main";
        }else{
            return "service_main";
        }
    }

    @RequestMapping("/service.do")
    public String serviceMain(){
        return "service_main";
    }
}
