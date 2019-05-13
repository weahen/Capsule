package com.dtxw.controller;

import com.dtxw.entity.Fieldtomac;
import com.dtxw.entity.Locationtofield;
import com.dtxw.mapper.LocationMapper;
import com.dtxw.mapper.RoomManagerMapper;
import com.dtxw.model.AddRoomInfo;
import com.dtxw.model.LoginInfo;
import com.dtxw.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class loginController {

    @Autowired
    RoomManagerMapper roomManagerMapper;
    @Autowired
    RoomService roomService;
    @Autowired
    LocationMapper locationMapper;

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
        int index = locationMapper.getAll().size()+1;
        String t = addRoomInfo.getField();
        String fieldGroup = t.substring(0,t.length()-1);
        if (!fieldGroup.contains(","))
        {
            String s = addRoomInfo.getField();
            addRoomInfo.setField(s.substring(0,s.length()-1));
            s = addRoomInfo.getLocation();
            addRoomInfo.setLocation(s.substring(0,s.length()-1));
            roomService.addRoom(addRoomInfo);
        }
        else
        {

            String fg[] = fieldGroup.split(",");
            for(int i=0;i<fg.length;i++)
            {
                if(fg[i]!=null)
                {
                    List<Fieldtomac> list = locationMapper.selectFieldtomacById(Integer.parseInt(fg[i]));
                    for(int j=0;j<list.size();j++)
                    {
                        locationMapper.addMAC(new Fieldtomac(list.get(j).getMac(),index));
                    }

                }
            }
            locationMapper.addLocation(new Locationtofield(addRoomInfo.getLocation(),index));
            addRoomInfo.setField(String.valueOf(index));
            roomService.addRoom(addRoomInfo);
        }


        model.addAttribute("addRoomInfo",new AddRoomInfo());
        System.out.println(addRoomInfo.getName());
        System.out.println(addRoomInfo.getLocation());
        return "manage/addRoom";
    }
}
