package com.messanger.app.controllers;

import com.messanger.app.Exception.FealdExistException;
import com.messanger.app.Interface.RegistrationI;
import com.messanger.app.models.User;
import com.messanger.app.repositories.UserRepository;
import com.messanger.app.services.UserRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserRegistration {
    private RegistrationI registrationI;
    private UserRepository userRepository;
    public UserRegistration(RegistrationI registrationI, UserRepository userRepository) {
        this.registrationI = registrationI;
        this.userRepository = userRepository;
    }

    @GetMapping("/addUser")
    public String showAddUserPage() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String username,@RequestParam String password) throws FealdExistException {
        User user = registrationI.addUser(username,password);
        userRepository.save(user);
        return "redirect:/login";
    }

    @ExceptionHandler(FealdExistException.class)
    public String handleException(FealdExistException uee) {
        return "redirect:/addUser";
    }

}