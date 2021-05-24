package com.reverie.controller;

import com.reverie.domain.LayUI;
import com.reverie.domain.Platenumber;
import com.reverie.domain.User;
import com.reverie.service.UserService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@Controller      //@ResponseBody+@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/main.do")
    public String userMain(){
        return "userList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getPlateNumberList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){
        LayUI<User> layUI=new LayUI();
        List<User> users = userService.selectAll();
        if(users!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(users.size());
            layUI.setData(users);
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
    public String changeStatus(@RequestParam("username")String username,@RequestParam("status")String status){
        boolean issuccess=false;
        int total=userService.changeStatus(username,status);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }


    @RequestMapping("/getaddUser.do")
    public String getaddUser(HttpServletRequest request){
        return "addUser";
    }


    @RequestMapping("/addUser.do")
    @ResponseBody
    public String addUser(HttpServletRequest request,User user) throws ParseException {
        boolean issuccess =false;
        issuccess=userService.save(user)>0?true:false;
        return String.valueOf(issuccess);
    }

    @RequestMapping("/geteditUser.do")
    public String geteditUser(HttpServletRequest request,String username){
        User user=userService.selectByUserName(username);
        request.setAttribute("user",user);
        return "editUser";
    }


    @RequestMapping("/editUser.do")
    @ResponseBody
    public String editUser(HttpServletRequest request,User user) throws ParseException {
        boolean issuccess =false;
        issuccess=userService.update(user)>0?true:false;
        return String.valueOf(issuccess);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("username")String username){
        boolean issuccess=false;
        int total=userService.delete(username);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }
}
