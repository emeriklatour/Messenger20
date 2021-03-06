package com.colval.messenger20.config.listener;


import com.colval.messenger20.model.DTO.MessageDto;
import com.colval.messenger20.services.implementation.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
    private final UserService userService;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    public WebSocketEventListener(UserService userService) {
        this.userService = userService;
    }


    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if(username != null) {
            logger.info("User Disconnected : " + username);

            MessageDto chatMessage = new MessageDto();
            chatMessage.setType("LEAVE");
            chatMessage.setSender(username);

            messagingTemplate.convertAndSend("/topic/publicChatRoom", chatMessage);
        }
    }

}
