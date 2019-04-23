package com.dtxw.controller;


import com.dtxw.entity.room;
import com.dtxw.mapper.RoomMapper;
import com.dtxw.model.InMessage;
import com.dtxw.service.ChatService;
import com.mysql.cj.xdevapi.JsonArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static com.mysql.cj.xdevapi.Type.JSON;

@Controller
public class RoomController {
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    ChatService chatService;
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
        return "chat1";
    }

    @RequestMapping(value = "/getrooom",method = RequestMethod.POST)
    @ResponseBody
    public List<room> getRooomList(@RequestParam String mac)
    {
        return roomMapper.selectByMac(mac);
    }
}
