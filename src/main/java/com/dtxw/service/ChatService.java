package com.dtxw.service;

import com.dtxw.entity.Reserve;
import com.dtxw.entity.Reserve_Multiple;
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

    public void sendReseverMessage(Reserve r,String path)
    {
        simpMessagingTemplate.convertAndSend("/chat"+path,r);
        System.out.println(r.toString());
    }

    public void sendMultipleReserveMessage(Reserve_Multiple reserve_multiple,String path)
    {
        simpMessagingTemplate.convertAndSend("/chat"+path,reserve_multiple);
        System.out.println(reserve_multiple.toString());
    }


}
