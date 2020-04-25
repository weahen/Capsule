package com.dtxw.controller;

import com.dtxw.mapper.RoomMapper;
import com.dtxw.model.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class helloController {

    @Autowired
    RoomMapper roomMapper;

    @RequestMapping("/hello")
    public String hello(Model model)
    {
        model.addAttribute("loginInfo",new LoginInfo());
        return "manage/login";
    }

    @RequestMapping("/hello1")
    public String hello1(HttpSession httpSession)
        {

            httpSession.setAttribute("RoomList",roomMapper.getAllRoom());
        return "ChatPage";
    }

    @RequestMapping("/hello2")
    public String hello2()
    {
        return "index1";
    }
}
