package com.dtxw.service;

import com.dtxw.model.InMessage;
import com.dtxw.model.OutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import static com.dtxw.controller.RoomController.messageLogger;
@Service
public class ChatService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessage(InMessage inMessage)
    {

        simpMessagingTemplate.convertAndSend("/chat"+inMessage.getPath(),new OutMessage(inMessage));
        messageLogger.info("SEND --- "+new OutMessage(inMessage).toString());
    }

}
