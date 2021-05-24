package com.reverie.controller;


import com.reverie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(String username,String password){
        Map<String,Object> map=new HashMap<>();
        boolean login = userService.login(username, password);
        map.put("issuccess",login);
        return map;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Map<String,Object> register(String username,String password,String phoneNumber){
        Map<String,Object> map=new HashMap<>();
        boolean register = userService.register(username, password,phoneNumber);
        map.put("issuccess",register);
        return map;
    }
}
