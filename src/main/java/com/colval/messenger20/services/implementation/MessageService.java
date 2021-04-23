package com.colval.messenger20.services.implementation;

import com.colval.messenger20.model.DTO.MessageDto;
import com.colval.messenger20.model.entities.Messages;
import com.colval.messenger20.model.entities.Users;
import com.colval.messenger20.repositories.interfaces.IMessageRepository;
import com.colval.messenger20.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class MessageService implements IMessageService {
    private final IMessageRepository messageRepository;
    private final UserService userService;
    private final ConversationService conversationService;

    @Autowired
    public MessageService(IMessageRepository messageRepository, UserService userService, ConversationService conversationService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
        this.conversationService = conversationService;
    }

    @Override
    public Messages create(MessageDto messageDto, String username){
        Users sender = userService.readOne(messageDto.getSender());
        Messages newMessage = new Messages();

        newMessage.setContent(messageDto.getContent());
        newMessage.setUserId(sender);
        newMessage.setType("CHAT");
        newMessage.setSentDate(new Timestamp(new Date().getTime()));

        return messageRepository.save(newMessage);


    }
}
