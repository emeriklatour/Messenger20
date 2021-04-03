package com.colval.messenger20.controllers;

import com.colval.messenger20.model.entities.Users;
import com.colval.messenger20.repositories.interfaces.IUserRepository;
import com.colval.messenger20.repositories.interfaces.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    UserRepo repo = new UserRepo();
    @GetMapping()
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());

        return "register/register";
    }


    @PostMapping("/index")
    public String processRegister(Users user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);

        return "index";
    }


}
