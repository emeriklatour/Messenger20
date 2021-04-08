package com.colval.messenger20.controllers;


import com.colval.messenger20.exception.UserAlreadyExistsAuthenticationException;
import com.colval.messenger20.model.DTO.UserDto;
import com.colval.messenger20.model.entities.Authorities;
import com.colval.messenger20.model.entities.Users;
import com.colval.messenger20.services.implementation.AuthorityService;
import com.colval.messenger20.services.implementation.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);

        return "register/register";
    }

    @PostMapping("/save")
    public String registerUserAccount(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "register/register";
        } else {
            try {
                userService.register(userDto);
            } catch (UserAlreadyExistsAuthenticationException e) {
                bindingResult.rejectValue("username", "userDto.username", "An account already exists with this username");
                return "register/register";

            }
            return "redirect:/login";
        }
    }

}
