package com.colval.messenger20.controllers;

import com.colval.messenger20.model.DTO.MessageDto;
import com.colval.messenger20.services.implementation.MessageService;
import com.colval.messenger20.services.implementation.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private final MessageService messageService;
    private final SessionService sessionService;

    @Autowired
    public ChatController(MessageService messageService, SessionService sessionService) {
        this.messageService = messageService;
        this.sessionService = sessionService;
    }

    @RequestMapping(path="/save",method = RequestMethod.POST)
    public String saveChat(@Valid @ModelAttribute("messageDto") MessageDto messageDto){
        String sender = sessionService.getuser();
        messageDto.setSender(sender);
        messageService.create(messageDto, sender);

        return "redirect:/";

    }
}
