package com.dtxw.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry ser)
    {

        ser.addEndpoint("/endpoint-websocket").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry mbr) {
        long[] heartbeat = {30000,30000};
        mbr.enableSimpleBroker("/chat").setTaskScheduler(new DefaultManagedTaskScheduler()).setHeartbeatValue(heartbeat);
        mbr.setApplicationDestinationPrefixes("/app","/chat").setUserDestinationPrefix("/user");


    }


}
