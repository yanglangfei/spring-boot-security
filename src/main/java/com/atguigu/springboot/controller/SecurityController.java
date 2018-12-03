package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yanglf
 * @sine 2018.12.03
 * @descriptipon   安全 Controller
 * @see
 */
@Controller
public class SecurityController {

    @RequestMapping("")
    public  String index(){
        return "index";
    }


    @RequestMapping("/login")
    public  String login(){
        return "login";
    }

}
