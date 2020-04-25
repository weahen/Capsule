package com.dtxw.listener;

import com.dtxw.dataCache.onLine_User;
import com.dtxw.model.InMessage;
import com.dtxw.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;

@Component
public class UnSubscribeEventListener implements ApplicationListener<SessionUnsubscribeEvent> {
    @Autowired
    ChatService chatService;
    @Override
    public void onApplicationEvent(SessionUnsubscribeEvent sessionUnsubscribeEvent) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionUnsubscribeEvent.getMessage());
        String id = headerAccessor.getSessionId();
        //onLine_User.online.put(path,onLine_User.online.get(path)-1);
        String path = onLine_User.subscribeID_Path.get(id);
        onLine_User.subscribeID_Path.remove(id);
        onLine_User.path_count.put(path,onLine_User.path_count.get(path)-1);
        InMessage inMessage = new InMessage("-1",path,String.valueOf(onLine_User.path_count.get(path)));
        chatService.sendMessage(inMessage);

    }
}
