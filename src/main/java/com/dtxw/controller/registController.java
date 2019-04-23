package com.dtxw.controller;

import com.dtxw.mapper.RoomManagerMapper;
import com.dtxw.model.LoginInfo;
import com.dtxw.model.RegistInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class registController {

    @Autowired
    RoomManagerMapper roomManagerMapper;

    @RequestMapping(value = "/registSubmit",method = RequestMethod.POST)
    public String regist(@ModelAttribute RegistInfo registInfo, Model model)
    {
        if(roomManagerMapper.getRoomManagerByName(registInfo.getID())==null)
        {
            roomManagerMapper.AddRoomManager(registInfo.getID(),registInfo.getPSW(),registInfo.getEMAIL());
            model.addAttribute("loginInfo",new LoginInfo());
            return "manage/login";
        }
        else
        {
            return "manage/register";
        }
    }
}
