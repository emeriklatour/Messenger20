package com.colval.messenger20.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class IndexController {

    @GetMapping("/") //GetMapping source de fichiers == resource/templates
    public String index(Model model){
        //Compter les customers
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String strDate= dtf.format(now);

        model.addAttribute("Greetings", "Hello World Emerik! " + strDate);
        return "index/index"; //read as folder/file
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }




}


