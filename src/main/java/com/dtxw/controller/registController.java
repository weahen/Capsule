package com.dtxw.controller;

import com.dtxw.entity.RegistCache;
import com.dtxw.entity.RoomManager;
import com.dtxw.mapper.RoomManagerMapper;
import com.dtxw.model.AccessField;
import com.dtxw.model.LoginInfo;
import com.dtxw.model.RegistInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class registController {

    @Autowired
    RoomManagerMapper roomManagerMapper;

    @RequestMapping(value = "/registSubmit",method = RequestMethod.POST)
    public String regist(@ModelAttribute RegistInfo registInfo, Model model)
    {
        if(roomManagerMapper.getRoomManagerByName(registInfo.getID())==null)
        {
            roomManagerMapper.AddToCache(registInfo.getID(),registInfo.getPSW(),registInfo.getEMAIL());
            model.addAttribute("loginInfo",new LoginInfo());
            return "manage/login";
        }
        else
        {
            return "manage/register";
        }
    }

    @RequestMapping("/regist_cache")
    @ResponseBody
    List<RegistCache> getCache()
    {
        return roomManagerMapper.getCache();
    }

    @RequestMapping(value = "/audit_pass" ,method = RequestMethod.POST)
    public String addManager(@ModelAttribute AccessField accessField ,Model model)
    {
        RoomManager roomManager =roomManagerMapper.getCacheByName(accessField.getNAME());
        System.out.println("aa"+roomManager.getPassword()+roomManager.getName()+roomManager.getEmail());
        roomManagerMapper.AddManager(roomManager.getName(),roomManager.getPassword(),roomManager.getEmail(),accessField.getACCESSFIELD());
        roomManagerMapper.deleteCacheByName(accessField.getNAME());
        model.addAttribute("access",new AccessField());
        return "manage/updateRoom";
    }
}
