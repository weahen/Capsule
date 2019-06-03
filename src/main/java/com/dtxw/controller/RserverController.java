package com.dtxw.controller;

import com.dtxw.entity.Reserve;
import com.dtxw.entity.Reserve_Multiple;
import com.dtxw.entity.RoomManager;
import com.dtxw.mapper.RoomManagerMapper;
import com.dtxw.mapper.RoomMapper;
import com.dtxw.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RserverController {
@Autowired
    RoomMapper mapper;
@Autowired
    ChatService service;
@Autowired
    RoomManagerMapper roomManagerMapper;
@RequestMapping(value = "/getNumber" ,method = RequestMethod.POST)
@ResponseBody
 public Reserve getNO(String path)
{
   Reserve r = mapper.getReserve(path);
   int tm = (int)r.getTOTAL_No();
   int i = mapper.updateReserve(path,tm+1);
   r.setTOTAL_No(tm+1);
   service.sendReseverMessage(r,path);
   return r;
}

@RequestMapping(value = "/getNumber_Multiple",method = RequestMethod.POST)
@ResponseBody
public Reserve_Multiple getNO_Multiple(String path,int individule)
{
    Reserve_Multiple reserve_multiple = mapper.getMultipleReserve(path);
    int type = (individule-1)/2;
    reserve_multiple.setTYPE_VALUE(type).plusTotal_NO();
    mapper.updateMultipleReserve(reserve_multiple,path);
    service.sendMultipleReserveMessage(reserve_multiple,path);
    return reserve_multiple;

}

@RequestMapping(value = "/processNumber")
@ResponseBody
    public int processNumber(String path)
{
    Reserve r = mapper.getReserve(path);
    int c = (int)r.getCURRENT_No();
    int t = (int)r.getTOTAL_No();
    if(c==t)
    {
        return 0;
    }
    else
    {
        r.setCURRENT_No(c+1);
        mapper.updateCurrent(path,c+1);
        service.sendReseverMessage(r,path);
        return 1;
    }

}

@RequestMapping(value = "/processMultipleNumber",method = RequestMethod.POST)
@ResponseBody
public int processMultipleNumber(String path,int type)
{
    Reserve_Multiple reserve_multiple = mapper.getMultipleReserve(path);
    int c = (int)reserve_multiple.getCURRENT_NO();
    int t = (int)reserve_multiple.getTOTAL_NO();
    if(c==t || reserve_multiple.testNULL(type)==0)
        return 0;
    else
    {
        reserve_multiple.plusCurrent_NO().Process_TYPE_VALUE(type);
        mapper.updateMultipleReserve(reserve_multiple,path);
        service.sendMultipleReserveMessage(reserve_multiple,path);
        return 1;
    }


}

@RequestMapping(value = "/processNumber_Login",method = RequestMethod.POST)
    RoomManager processNumber_Login(String userName , String PassWord)
{
    if(roomManagerMapper.getRoomManagerByName(userName).getPassword().equals(PassWord))
    {

        return roomManagerMapper.getRoomManagerByName(userName);
    }
    else
    {
        return null;
    }
}



}
