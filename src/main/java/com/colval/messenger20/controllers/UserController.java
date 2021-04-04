package com.colval.messenger20.controllers;


import com.colval.messenger20.model.DTO.UserDto;
import com.colval.messenger20.model.entities.Authorities;
import com.colval.messenger20.model.entities.Users;
import com.colval.messenger20.services.implementation.AuthorityService;
import com.colval.messenger20.services.implementation.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthorityService authorityService;

    public UserController(UserService userService, AuthorityService authorityService) {
        this.userService = userService;
        this.authorityService = authorityService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);

        return "register/register";
    }

    @PostMapping("/save")
    public String registerUserAccount(@Valid UserDto userDto){
        Users user;
        Authorities authority;

        if (userService.readOne(userDto.getUsername()) != null) {
            throw new IllegalArgumentException("User already exist");
        } else {
            user = new Users();
            user.setUsername(userDto.getUsername());
            user.setPassword(passwordEncoder().encode(userDto.getPassword()));
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEnabled(true);
            userService.create(user);

            authority = new Authorities();
            authority.setUsername(userDto.getUsername());
            authority.setAuthority("USER");
            authorityService.create(authority);

        }

        return "redirect:/login";
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
