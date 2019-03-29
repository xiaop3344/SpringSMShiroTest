package com.xdl.controller;


import com.xdl.bean.User;
import com.xdl.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/alluser")
    @ResponseBody
    public List<User> findAllUser(){
        List<User> users = loginService.findAllUser();
        return users;
    }

    @PostMapping("/login.do")
    @ResponseBody
    public Map<String, String> loginAdmin(String name, String password){
        Map<String,String> msg=new HashMap<>();
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            msg.put("result","success");
            return msg;
        }
        catch (Exception e){
            System.out.println(e);
            msg.put("result","false");
            msg.put("errorMsg","登陆错误");
            return msg;
        }
    }






    @GetMapping("/user/{name}")
    @ResponseBody
    public User findByName(@PathVariable String name){
        User user = loginService.findByName(name);
        return user;

    }




    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;

    }
    @GetMapping("/loginsuccess")
    public ModelAndView loginsuccess(ModelAndView modelAndView){
        modelAndView.setViewName("loginSuccess");
        return modelAndView;

    }

    @GetMapping("/guanli")
    public ModelAndView guanli(ModelAndView modelAndView){
        modelAndView.setViewName("guanli");
        return modelAndView;

    }
    @GetMapping("/orderManager")
    public ModelAndView orderManager(ModelAndView modelAndView){
        modelAndView.setViewName("orderManager");
        return modelAndView;

    }




}
