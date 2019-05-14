package com.dtxw.model;

import com.dtxw.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Injection {
    @Autowired
    private ChatService chatService;

    public static Injection injection;

    @PostConstruct
    public void init()
    {
        injection = this;
        injection.chatService = this.chatService;
    }

    public ChatService getChatService()
    {
        return injection.chatService;
    }
}
