package com.colval.messenger20.controllers;

import com.colval.messenger20.model.DTO.MessageDto;
import com.colval.messenger20.model.entities.Messages;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {



    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public MessageDto sendMessage(@Payload MessageDto messages) {
        return messages;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public MessageDto addUser(@Payload MessageDto messages, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", messages.getSender());
        return messages;
    }

}