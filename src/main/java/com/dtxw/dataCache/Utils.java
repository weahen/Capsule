package com.dtxw.dataCache;

import com.dtxw.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    @Autowired
    public static ChatService chatService;
}
