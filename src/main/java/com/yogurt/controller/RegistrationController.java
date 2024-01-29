package com.yogurt.controller;

import com.yogurt.dto.UserDto;
import com.yogurt.service.impl.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/register")
public class RegistrationController {
    private final RegistrationService registrationService;


    @GetMapping()
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "registration";
    }

    @PostMapping()
    public String registerUser(@ModelAttribute("user") UserDto userDto) {
        registrationService.registerUser(userDto);
        return "redirect:/login";
    }
}
