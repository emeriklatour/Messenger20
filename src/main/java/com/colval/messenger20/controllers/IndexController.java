package com.colval.messenger20.controllers;


import com.colval.messenger20.model.DTO.MessageDto;
import com.colval.messenger20.services.implementation.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final SessionService sessionService;

    @Autowired
    public IndexController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/") //GetMapping source de fichiers == resource/templates
    public String index(Model model){
        MessageDto messageDto = new MessageDto();
        model.addAttribute("messageDto", messageDto);
        model.addAttribute("username", sessionService.getuser());
        return "index/index"; //read as folder/file
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }



}


