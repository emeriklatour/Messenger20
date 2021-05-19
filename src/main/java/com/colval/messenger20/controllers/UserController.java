package com.colval.messenger20.controllers;


import com.colval.messenger20.exception.UserAlreadyExistsAuthenticationException;
import com.colval.messenger20.model.DTO.UserDto;
import com.colval.messenger20.services.implementation.UserService;
import com.colval.messenger20.services.mappers.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);

        return "register/register";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable Short id) {
        UserDto userDto = this.userService.readOne(id).map(userMapper::entityToDto).get();

        model.addAttribute("userDto", userDto);
        return "edit/edit";
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
