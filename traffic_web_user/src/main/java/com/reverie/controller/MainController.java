package com.reverie.controller;

import com.reverie.domain.Operator;
import com.reverie.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class MainController {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping("/login.do")
    @ResponseBody
    public String login(HttpServletRequest request, @RequestParam("username") String jobNumber, String password){
        Operator operator = operatorService.login(jobNumber, password);
        if(operator!=null){
            request.getSession().setAttribute("jobNumber",jobNumber);
            return "true";
        }else{
            return "false";
        }
    }


    @RequestMapping("/main.do")
    public String manageMain(){
        return "manage_main";
    }

    @RequestMapping("/service.do")
    public String serviceMain(){
        return "service_main";
    }
}
