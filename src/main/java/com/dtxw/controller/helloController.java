package com.dtxw.controller;

import com.dtxw.model.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @RequestMapping("/hello")
    public String hello(Model model)
    {
        model.addAttribute("loginInfo",new LoginInfo());
        return "manage/login";
    }

    @RequestMapping("/hello1")
    public String hello1()
        {

        return "ChatPage";
    }
}
