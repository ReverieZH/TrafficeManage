package com.reverie.controller;

import com.reverie.domain.LayUI;
import com.reverie.domain.Operator;
import com.reverie.domain.Syslog;
import com.reverie.domain.User;
import com.reverie.service.OperatorService;
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

@Controller      //@ResponseBody+@Controller
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping("/main.do")
    public String userMain(){
        return "operatorList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getPlateNumberList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer size){
        LayUI<Operator> layUI=new LayUI();
        List<Operator> operators = operatorService.selectAll(page,size);
        System.out.println(operators);
        if(operators!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(operators.size());
            layUI.setData(operators);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/seletcById.do")
    @ResponseBody
    public LayUI searchById(HttpServletRequest request, @RequestParam String jobnumber,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<Operator> layUI=new LayUI();
        Operator operator = operatorService.selectByKey(jobnumber);
        List<Operator> operators=new ArrayList<>();
        operators.add(operator);
        if(operators!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(operators.size());
            layUI.setData(operators);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("changeStatus.do")
    @ResponseBody
    public String changeStatus(@RequestParam("jobnumber")String jobnumber,@RequestParam("vaild")String status){
        boolean issuccess=false;
        int total=operatorService.changeStatus(jobnumber,status);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("/getaddOperator.do")
    public String getaddOperator(HttpServletRequest request){
        return "addOperator";
    }


    @RequestMapping("/addOperator.do")
    @ResponseBody
    public String addOperator(HttpServletRequest request,Operator operator) throws ParseException {
        boolean issuccess =false;
        issuccess=operatorService.save(operator)>0?true:false;
        return String.valueOf(issuccess);
    }

    @RequestMapping("/geteditOperator.do")
    public String geteditOperator(HttpServletRequest request,String jobnumber){
        Operator operator=operatorService.selectByKey(jobnumber);
        request.setAttribute("operator",operator);
        return "editOperator";
    }


    @RequestMapping("/editOperator.do")
    @ResponseBody
    public String editUser(HttpServletRequest request,Operator operator) throws ParseException {
        boolean issuccess =false;
        issuccess=operatorService.update(operator)>0?true:false;
        return String.valueOf(issuccess);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("jobnumber")String jobnumber){
        boolean issuccess=false;
        int total=operatorService.delete(jobnumber);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }
}
