package com.dtxw.controller;

import com.dtxw.mapper.LocationMapper;
import com.dtxw.model.AddRoomInfo;
import com.dtxw.model.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class manageController {
    @Autowired
    LocationMapper locationMapper;
    @RequestMapping(value = "/addroom",method = RequestMethod.POST)
    public String addRoom(Model model, HttpSession httpSession,@ModelAttribute LoginInfo loginInfo){
        httpSession.setAttribute("loginInfo",loginInfo);
        httpSession.setAttribute("LocationList",locationMapper.getAll());
        model.addAttribute("addRoomInfo",new AddRoomInfo());
        return "manage/addRoom";
    }

    @RequestMapping("/viewAllRoom")
    public String viewAllRoom()
    {
        return "manage/chat_room";
    }



}
