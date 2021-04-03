package com.colval.messenger20.controllers;

import com.colval.messenger20.model.entities.Users;
import com.colval.messenger20.repositories.interfaces.IUserRepository;
import com.colval.messenger20.repositories.interfaces.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class RegisterController {

    UserRepo repo = new UserRepo();
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());

        return "signup_form";
    }

    @GetMapping("/register")
    public String login() {
        return "register/register";
    }

    @PostMapping("process_register")
    public String processRegister(Users user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

       repo.save(user);

        return "login/login";
    }
}
