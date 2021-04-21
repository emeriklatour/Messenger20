package com.colval.messenger20.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/") //GetMapping source de fichiers == resource/templates
    public String index(Model model){

        model.addAttribute("username", getuser());
        return "index/index"; //read as folder/file
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    private String getuser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return null;
    }

}


