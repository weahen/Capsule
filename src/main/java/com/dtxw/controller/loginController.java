package com.dtxw.controller;

import com.dtxw.entity.RoomManager;
import com.dtxw.mapper.LocationMapper;
import com.dtxw.mapper.RoomManagerMapper;
import com.dtxw.model.AddRoomInfo;
import com.dtxw.model.LoginInfo;
import com.dtxw.model.RegistInfo;
import com.dtxw.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    @Autowired
    RoomManagerMapper roomManagerMapper;
    @Autowired
    RoomService roomService;

//    @RequestMapping(value = "/login" , method = RequestMethod.POST)
//    public String ManagerLogin(@RequestParam(value = "password") String password, @RequestParam(value = "name")String name, HttpSession httpSession)
//    {
//        RoomManager roomManager = roomManagerMapper.getRoomManagerByName(name);
//        if(roomManager.getPassword().equals(password))
//        {
//            return "ChatPage";
//        }
//        else
//        {
//            return "hello";
//        }
//    }
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public String ManagerLogin(@ModelAttribute LoginInfo loginInfo,Model model)
    {
        System.out.println(loginInfo.getID()+loginInfo.getPSW());

        model.addAttribute("loginInfo",loginInfo);
        if(roomManagerMapper.getRoomManagerByName(loginInfo.getID()).getPassword().equals(loginInfo.getPSW()))
        {
            return "manage/backgroundSystem";
        }
        else
        {
            return "manage/login";
        }
    }



    @RequestMapping(value = "/addChatRoom",method = RequestMethod.POST)
    public String AddChatRoom(@ModelAttribute AddRoomInfo addRoomInfo,Model model)
    {

        model.addAttribute("addRoomInfo",new AddRoomInfo());
        System.out.println(addRoomInfo.getName());
        System.out.println(addRoomInfo.getLocation());
        roomService.addRoom(addRoomInfo);
        return "manage/addRoom";
    }
}
