package com.atguigu.springboot.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * XXX company
 * Copyright (c) 2018, xxx All Rights Reserved.
 *
 * @author yanglf
 * @date 2018/12/2/002
 * @descriptipon
 */
@Controller
public class JspController {


    @RequestMapping("/index")
    public String toIndex(Model model){
        model.addAttribute("name","admin");
        return "index";
    }

}
