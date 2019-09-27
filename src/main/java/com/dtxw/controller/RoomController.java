package com.dtxw.controller;


import com.dtxw.entity.Fieldtomac;
import com.dtxw.entity.Locationtofield;
import com.dtxw.entity.room;
import com.dtxw.entity.room_shotcut;
import com.dtxw.mapper.LocationMapper;
import com.dtxw.mapper.RoomMapper;
import com.dtxw.model.InMessage;
import com.dtxw.model.deleteID;
import com.dtxw.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RoomController {
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    ChatService chatService;
    @Autowired
    LocationMapper locationMapper;
    public final static Logger messageLogger = LoggerFactory.getLogger("messageLOG") ;
//    @ResponseBody
//    @RequestMapping("/query")
//    public room test()
//    {
//        room ROOM= roomMapper.getRoomById(1);
//        System.out.println(ROOM.getPATH());
//        return ROOM;
//    }
//    @ResponseBody
//    @RequestMapping("/queryAll")
//    public List<room> test1()
//    {
//
//        return roomMapper.getAllRoom();
//    }
    @RequestMapping("/chat")
    public String returnRoomList(HttpSession httpSession)
    {
        httpSession.setAttribute("RoomList",roomMapper.getAllRoom());
        return "ChatPage";
    }

    @MessageMapping("/chatroom/*")
    public void subscribeManager(InMessage inmessage)
    {
        System.out.println("inmessage = [" + inmessage.getContent() + "]");
        chatService.sendMessage(inmessage);
        messageLogger.info("RECV --- "+inmessage.toString());

    }

//    @MessageMapping("/ios/chatroom/*")
//    public void subscribeManagerios(String inmessage)
//    {
//        System.out.println(inmessage);
//
//
//    }

    @RequestMapping("/getroom")
    @ResponseBody
    public List<room> getRoomList()
    {
        return roomMapper.getAllRoom();
    }

    @SubscribeMapping("/*")
    public void notification(StompHeaderAccessor stompHeaderAccessor)
    {
        String add = stompHeaderAccessor.getDestination();
        System.out.println("订阅了 "+ add);
    }

    @RequestMapping("/ioschat")
    public String IOSH5()
    {
        return "IOSChatRoom";
    }

    @RequestMapping(value = "/getrooom",method = RequestMethod.POST)
    @ResponseBody
    public List<room> getRooomList(@RequestParam String mac)
    {
        String s=mac;
        if(mac.contains(":"))
        {
            s = mac.toUpperCase().replace(":","-");
        }
        System.out.println("Recieved Request"+s);
        List<room> temp = roomMapper.selectByMac(s);
        if (temp.size()==0)
            return null;
        else
        {
            String t = temp.get(0).getFIELD();
            temp.add(roomMapper.selectByUnitMac("0"));
            return temp;
        }



    }

    @RequestMapping(value = "/getFieldId")
    @ResponseBody
    public int getFieldId()
    {
        System.out.println("Request FID");
        Locationtofield locationtofield = locationMapper.getIndex();
        if (locationtofield==null)
            return 0;
        else
            return locationtofield.getField();

    }

    @RequestMapping(value = "/addFieldId" ,method = RequestMethod.GET)
    @ResponseBody
    public int addFieldId(String MAC,int FIELDID)
    {

        System.out.println("ADD MAC");
           return locationMapper.addMAC(new Fieldtomac(MAC,FIELDID));

    }

    @RequestMapping(value = "/addLocation",method = RequestMethod.GET)
    @ResponseBody
    public int addLocation(String Location,int FIELDID)
    {
        System.out.println("ADD LOCATION");
        return locationMapper.addLocation(new Locationtofield(Location,FIELDID));
    }

    @RequestMapping(value = "/getUnitInfo",method = RequestMethod.POST)
    @ResponseBody
    public List<room_shotcut> getUnitInfo(String location)
    {
        System.out.println("Received Location"+location);
        return roomMapper.getUnitRoom(location);
    }

    @RequestMapping(value = "/getLocationMacList",method = RequestMethod.POST)
    @ResponseBody
    public List<String> getLocationMacList(int fieldID)
    {
        return locationMapper.selectMacById(fieldID);
    }
//    @RequestMapping(value = "/addUnitRoom",method = RequestMethod.GET)
//    @ResponseBody
//    public int addUnitRoom(String Location,int FIELDID)
//    {
//        System.out.println("UINT_ROOM");
//        return locationMapper.addLocation(new Locationtofield(Location,FIELDID));
//    }

    @RequestMapping(value = "/deleteRoom",method = RequestMethod.POST)
    public String deleteRoom(@ModelAttribute deleteID delete, Model model)
    {
        int id = Integer.parseInt(delete.getId());
        roomMapper.deleteRoomByID(id);
        model.addAttribute("deleteID",new deleteID());
        return "manage/chat_room";
    }
}
