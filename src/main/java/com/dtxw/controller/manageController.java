package com.dtxw.controller;

import com.dtxw.entity.room;
import com.dtxw.mapper.LocationMapper;
import com.dtxw.mapper.RoomMapper;
import com.dtxw.model.AddRoomInfo;
import com.dtxw.model.LoginInfo;
import com.dtxw.model.ModifyRoomInfo;
import com.dtxw.model.deleteID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class manageController {
    @Autowired
    LocationMapper locationMapper;
    @Autowired
    RoomMapper roomMapper;
    @RequestMapping(value = "/addroom",method = RequestMethod.POST)
    public String addRoom(Model model, HttpSession httpSession,@ModelAttribute LoginInfo loginInfo){
        httpSession.setAttribute("loginInfo",loginInfo);
        httpSession.setAttribute("LocationList",locationMapper.getAll());
        model.addAttribute("addRoomInfo",new AddRoomInfo());
        return "manage/addRoom";
    }

    @RequestMapping(value = "/modifyroom",method = RequestMethod.POST)
    public String modifyRoom(Model model, HttpSession httpSession,@ModelAttribute LoginInfo loginInfo){
        httpSession.setAttribute("loginInfo",loginInfo);
        httpSession.setAttribute("RoomList",roomMapper.getAllRoom());
        httpSession.setAttribute("LocationList",locationMapper.getAll());
        model.addAttribute("ModifyRoomInfo",new ModifyRoomInfo());
        return "manage/modify";
    }

    @RequestMapping("/viewAllRoom")
    public String viewAllRoom(Model model, HttpSession httpSession,@ModelAttribute LoginInfo loginInfo)
    {
        int field = Integer.parseInt(loginInfo.getFIELD());
        List<room> roomList;
        if (field==0)
            roomList = roomMapper.getAllRoom();
        else
            roomList = roomMapper.getRoomByField(field);
        if (roomList.isEmpty())
            roomList.add(new room("暂无可管理的聊天室"));
        httpSession.setAttribute("roomList",roomList);
        httpSession.setAttribute("loginInfo",loginInfo);
        model.addAttribute("deleteID",new deleteID());
        return "manage/chat_room";
    }



}
