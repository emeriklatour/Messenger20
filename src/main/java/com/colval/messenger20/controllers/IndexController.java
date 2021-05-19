package com.colval.messenger20.controllers;


import com.colval.messenger20.model.DTO.MessageDto;
import com.colval.messenger20.model.DTO.UserDto;
import com.colval.messenger20.model.entities.Users;
import com.colval.messenger20.services.implementation.SessionService;
import com.colval.messenger20.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final SessionService sessionService;
    private final UserService userService;

    @Autowired
    public IndexController(SessionService sessionService, UserService userService) {
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @GetMapping("/") //GetMapping source de fichiers == resource/templates
    public String index(Model model){
        MessageDto messageDto = new MessageDto();
        String username = sessionService.getuser();
        Users user = userService.findByUsername(username);
        model.addAttribute("messageDto", messageDto);
        model.addAttribute("username", username);
        model.addAttribute("user", user);
        return "index/index"; //read as folder/file
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }



}


