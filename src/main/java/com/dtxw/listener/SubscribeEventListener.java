package com.dtxw.listener;

import com.dtxw.dataCache.onLine_User;
import com.dtxw.model.InMessage;
import com.dtxw.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class SubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {
    @Autowired
    ChatService chatService;

    @Override
    public void onApplicationEvent(SessionSubscribeEvent sessionSubscribeEvent) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionSubscribeEvent.getMessage());
        String path = headerAccessor.getDestination();
        String ID = headerAccessor.getSessionId();
        onLine_User.subscribeID_Path.put(ID,path);
        onLine_User.path_count.put(path,onLine_User.path_count.get(path)+1);
        InMessage inMessage = new InMessage("0",path,"Online User"+onLine_User.path_count.get(path));
        chatService.sendMessage(inMessage);


    }
}
